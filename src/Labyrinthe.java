import java.io.*;

/**
 * Squelette de classe labyrinthe
 */
public class Labyrinthe {

    //attributs

    /**
     * • "haut" represente par la constante nommee HAUT
     * • "bas" represente par la constante nommee BAS
     * • "gauche" represente par la constante nommee GAUCHE
     * • "droite" represente par la constante nommee DROITE
     */
    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String GAUCHE = "gauche";
    public static final String DROITE = "droite";

    /**
     * • ’X’ represente un mur et sera represente par la constante MUR ;
     * • ’P’ represente le personnage et sera represente par la constante PJ ;
     * • ’S’ represente une sortie et sera represente par la constante SORTIE ;
     * • ’.’ represente une case vide sera represente par la constante VIDE.
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char SORTIE = 'S';
    public static final char VIDE = '.';

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;

    //methodes

    /**
     * donne les coordonnees de la case voisine de (x,y) selon la direction action
     *
     * @param x      numero de ligne (ordonnee)
     * @param y      numero de colonne (abscisse)
     * @param action direction (haut, bas, gauche, droite)
     * @return coordonnes de la case voisine
     */
    public static int[] getSuivant(int x, int y, String action) {
        int[] res = new int[2];
        try {
            if ((!action.equals(Labyrinthe.HAUT)) && (!action.equals(Labyrinthe.BAS)) && (!action.equals(Labyrinthe.GAUCHE)) && (!action.equals(Labyrinthe.DROITE)) && (!action.equals("exit")))
                throw new ActionInconnueException("direction inconnue");
            if (action.equals(Labyrinthe.HAUT)) {
                res[0] = x - 1;
                res[1] = y;
            } else if (action.equals(Labyrinthe.BAS)) {
                res[0] = x + 1;
                res[1] = y;
            } else if (action.equals(Labyrinthe.GAUCHE)) {
                res[0] = x;
                res[1] = y - 1;
            } else if (action.equals(Labyrinthe.DROITE)) {
                res[0] = x;
                res[1] = y + 1;
            }
        } catch (ActionInconnueException e) {
            System.out.println("action inconnue");
        }
        return res;
    }

    /**
     * permet de charger un labyrinthe a partir d’un fichier
     *
     * @param nom nom du fichier
     * @return labyrinthe charge
     */
    public static Labyrinthe chargerLabyrinthe(String nom) {

        //on cree un labyrinthe
        Labyrinthe res = new Labyrinthe();

        //on voit si on arrive a charger le fichier
        try {
            //on charge le fichier
            BufferedReader br = new BufferedReader(new FileReader(nom));

            //on releve le nombre de lignes de lignes et colonnes avec le BufferedReader
            int ligne = Integer.parseInt(br.readLine());
            int colonne = Integer.parseInt(br.readLine());

            //on initialise le nombre de murs et de colonnes du labyrinthe a renvoyer
            res.murs = new boolean[ligne][colonne];


            //on cree une variable cpt qui compte le nombre de lignes parcourues durant la lecture du fichier
            int cpt = 0;

            //on lit le fichier
            String elems = br.readLine();
            while (elems != null) {
                if (elems.length() != colonne || cpt > ligne)
                    throw new FichierIncorrectException("le nombre de lignes/colonnes annonce ne correspond pas au labyrinthe");
                for (int i = 0; i < colonne; i++) {
                    if ((elems.charAt(i) != Labyrinthe.MUR) && (elems.charAt(i) != Labyrinthe.PJ) && (elems.charAt(i) != Labyrinthe.SORTIE) && (elems.charAt(i) != Labyrinthe.VIDE))
                        throw new FichierIncorrectException("un element du labyrinthe est inconnu");

                    //creation du tableau de murs
                    res.murs[cpt][i] = (elems.charAt(i) == Labyrinthe.MUR);

                    //creation personnage
                    if (elems.charAt(i) == Labyrinthe.PJ) {
                        if (res.personnage == null)
                            res.personnage = new Personnage(cpt, i);
                        else
                            throw new FichierIncorrectException("il y a plus d'un personnage dans le labyrinthe");
                    }

                    //creation sortie
                    if (elems.charAt(i) == Labyrinthe.SORTIE)
                        if (res.sortie == null)
                            res.sortie = new Sortie(cpt, i);
                        else
                            throw new FichierIncorrectException("il y a plus d'une sortie dans le labyrinthe");
                }
                cpt++;
                elems = br.readLine();
            }
            if ((res.sortie == null) || (res.personnage == null))
                throw new FichierIncorrectException("il n'y a pas de sortie ou de personnage");
        } catch (FileNotFoundException e) {
            System.out.println("nom de fichier incorrect");
        } catch (IOException e) {
            System.out.println("probleme a la lecture du fichier");
        }
        return res;
    }

    /**
     * retourne un caractere decrivant le contenu de
     * la case (x,y)
     *
     * @param x numero de ligne (ordonnee)
     * @param y numero de colonne (abscisse)
     * @return caractere
     */
    char getChar(int x, int y) {
        char res = '.';
        if (this.murs[x][y] == true)
            res = Labyrinthe.MUR;
        else if (this.sortie.getDx() == x && this.sortie.getDy() == y)
            res = Labyrinthe.SORTIE;
        else if (this.personnage.getDx() == x && this.personnage.getDy() == y)
            res = Labyrinthe.PJ;
        return res;
    }

    /**
     * deplace le personnage lorsqu’il fait l’action action
     *
     * @param action direction (haut, bas, gauche, droite)
     * @throws ActionInconnueException
     */
    void deplacerPerso(String action) throws ActionInconnueException {
        int[] chemin = Labyrinthe.getSuivant(this.personnage.getDx(), this.personnage.getDy(), action);
        while (this.murs[chemin[0]][chemin[1]] == false) {
            this.personnage = new Personnage(chemin[0], chemin[1]);
            chemin = Labyrinthe.getSuivant(this.personnage.getDx(), this.personnage.getDy(), action);
        }
    }

    /**
     * retourne une chaine decrivant le labyrinthe actuel
     *
     * @return affichage du labyrinthe
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < murs.length; i++) {
            for (int j = 0; j < murs[0].length; j++) {
                if ((this.murs[i][j] == true))
                    res += Character.toString(Labyrinthe.MUR);
                else if ((this.personnage.getDx() == i) && (this.personnage.getDy() == j))
                    res += Character.toString(Labyrinthe.PJ);
                else if ((this.sortie.getDx() == i) && (this.sortie.getDy() == j))
                    res += Character.toString(Labyrinthe.SORTIE);
                else
                    res += Character.toString(Labyrinthe.VIDE);
            }
            res += "\n";
        }
        return res;
    }

    /**
     * retourne true si et seulement si le jeu est fini
     *
     * @return etat du jeu fini
     */
    public boolean etreFini() {
        return ((this.personnage.getDx() == this.sortie.getDx()) && (this.personnage.getDy() == this.sortie.getDy()));
    }

}
