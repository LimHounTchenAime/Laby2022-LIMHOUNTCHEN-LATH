public class Position {

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
            case Labyrinthe.HAUT -> this.dx--;
            case Labyrinthe.BAS -> this.dx++;
            case Labyrinthe.GAUCHE -> this.dy--;
            case Labyrinthe.DROITE -> this.dy++;
        }
    }


}
