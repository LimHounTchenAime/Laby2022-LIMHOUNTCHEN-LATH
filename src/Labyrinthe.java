/**
 * Squelette de classe labyrinthe
 */
class Labyrinthe {

    //attributs

    private boolean[][] murs;
    private Personnage personnage;
    private Sortie sortie;

    //methodes

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
     * donne les coordonnees de la case voisine de (x,y) selon la direction action
     *
     * @param x      numero de ligne (ordonnee)
     * @param y      numero de colonne (abscisse)
     * @param action direction (haut, bas, gauche, droite)
     * @return coordonnes de la case voisine
     */
    static int[] getSuivant(int x, int y, String action) {
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
        throw new Error("TODO");
    }

    /**
     * retourne true si et seulement si le jeu est fini
     *
     * @return etat du jeu fini
     */
    public boolean etreFini() {
        throw new Error("TODO");
    }

    /**
     * permet de charger un labyrinthe a partir d’un fichier
     *
     * @param nom nom du fichier
     * @return labyrinthe charge
     */
    public static Labyrinthe chargerLabyrinthe(String nom) {
        throw new Error("TODO");
    }

}
