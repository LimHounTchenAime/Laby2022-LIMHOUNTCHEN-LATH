import java.io.*;

/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe {

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
    static int[] getSuivant(int x, int y, String action) throws ActionInconnueException {
        if ((action != Labyrinthe.HAUT) || (action != Labyrinthe.BAS) || (action != Labyrinthe.GAUCHE) || (action != Labyrinthe.DROITE) || (action != "exit"))
            throw new ActionInconnueException("direction inconnue");

    }

    /**
     * permet de charger un labyrinthe a partir d’un fichier
     *
     * @param nom nom du fichier
     * @return labyrinthe charge
     */
    public static Labyrinthe chargerLabyrinthe(String nom) throws FichierIncorrectException {

        //on cree un labyrinthe null par default
        Labyrinthe res = null;

        //on voit si on arrive a charger le fichier
        try {
            //on charge le fichier
            BufferedReader br = new BufferedReader(new FileReader(nom));

            //on releve le nombre de lignes de lignes et colonnes avec le BufferedReader
            int ligne = Integer.parseInt(br.readLine());
            int colonne = Integer.parseInt(br.readLine());

            //on initialise le labyrinthe s'il n'y a pas eu d'erreur de chargement de fichier
            res = new Labyrinthe();

            //on initialise le nombre de murs et de colonnes du labyrinthe a renvoyer
            res.murs = new boolean[ligne][colonne];


            //on cree une variable cpt qui compte le nombre de lignes parcourues durant la lecture du fichier
            int cpt = 0;

            //on lit le fichier
            String elems = br.readLine();
            while (elems != null) {
                cpt++;
                if (elems.length() != colonne || cpt > ligne)
                    throw new FichierIncorrectException("le nombre de lignes/colonnes annonce ne correspond pas au labyrinthe");
                for (int i = 0; i < colonne; i++) {
                    if ((elems.charAt(i)!=Labyrinthe.MUR) || (elems.charAt(i)!=Labyrinthe.PJ) || (elems.charAt(i)!=Labyrinthe.SORTIE) || (elems.charAt(i)!=Labyrinthe.VIDE))
                        throw new FichierIncorrectException("un element du labyrinthe est inconnu");
                    res.murs[cpt][i] = elems.charAt(i) == Labyrinthe.MUR;
                    if (elems.charAt(i)!=Labyrinthe.PJ)
                        if (res.personnage == null)
                            res.personnage = new Personnage(cpt, i);
                        else
                            throw new FichierIncorrectException("il y a deux personnages dans le labyrinthe");
                }
                elems = br.readLine();
            }
        } catch (FichierIncorrectException e) {
            System.out.println("nom de fichier incorrect");
        }
        catch (IOException e){

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
        throw new Error("TODO");
    }

    /**
     * deplace le personnage lorsqu’il fait l’action action
     *
     * @param action direction (haut, bas, gauche, droite)
     * @throws ActionInconnueException
     */
    void deplacerPerso(String action) throws ActionInconnueException {
        throw new Error("TODO");
    }

    /**
     * retourne une chaine decrivant le labyrinthe actuel
     *
     * @return affichage du labyrinthe
     */
    public String toString() {
        String res = "";
        for (int i = 0; i < murs.length; i++)
            for (int j = 0; j < murs.length; j++) {
                if ((this.personnage.getDx() == i) && (this.personnage.getDy() == j))
                    res += Character.toString(Labyrinthe.PJ);
                else if ((this.sortie.getDx() == i) && (this.sortie.getDy() == j))
                    res += Character.toString(Labyrinthe.SORTIE);
                else if ((this.murs[i][j] == true))
                    res += Character.toString(Labyrinthe.MUR);
                else
                    res += Character.toString(Labyrinthe.VIDE);
            }
        return res;
    }

    /**
     * retourne true si et seulement si le jeu est fini
     *
     * @return etat du jeu fini
     */
    public boolean etreFini() {
        throw new Error("TODO");
    }
    //TODO Ecrire la méthode chargeant le labyrinthe en lisant le fichier avec les flux
}
