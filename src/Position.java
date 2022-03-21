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

    /**
     *
     * @param x, postion en x
     * @param y, position en y
     */
    Position(int x, int y){
        this.dx = x;
        this.dy = y;
    }

    public void deplacer(String direction){
        switch(direction){
            case HAUT -> this.dx-=1;
            case BAS -> this.dx+=1;
            case GAUCHE -> this.dy+=
        }
    }



}
