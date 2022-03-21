public class Position {
    /**
     * Constante de direction
     */
    public static final String HAUT = "haut";
    public static final String BAS = "bas";
    public static final String GAUCHE = "gauche";
    public static final String DROITE = "droite";


    /**
     * dx, position en x
     * dy, position en y
     */
    private int dx;
    private int dy;

    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }

    /**
     * @param x, postion en x
     * @param y, position en y
     */

    Position(int x, int y) {
        this.dx = x;
        this.dy = y;
    }

    Position() {
        this.dx = 0;
        this.dy = 0;
    }

    public void deplacer(String direction) {
        switch (direction) {
            case HAUT -> this.dx--;
            case BAS -> this.dx++;
            case GAUCHE -> this.dy--;
            case DROITE -> this.dy++;
        }
    }


}
