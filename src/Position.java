public class Position {

    /**
     * dx, position en x
     * dy, position en y
     */
    protected int dx;
    protected int dy;

    /**
     * contructeur de Position
     *
     * @param x, coord en x
     * @param y, coord en y
     */
    Position(int x, int y) {
        this.dx = x;
        this.dy = y;
    }

    Position() {
        this.dx = 0;
        this.dy = 0;
    }


    public int getDx() {
        return dx;
    }


    public int getDy() {

        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void deplacer(String direction) {
        switch (direction) {
            case Labyrinthe.HAUT -> this.dx--;
            case Labyrinthe.BAS -> this.dx++;
            case Labyrinthe.GAUCHE -> this.dy--;
            case Labyrinthe.DROITE -> this.dy++;
        }
    }


}
