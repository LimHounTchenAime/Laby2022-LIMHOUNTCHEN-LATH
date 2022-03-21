import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void testDeplacerPositionPositive(){
        Position p = new Position(2,6);
        p.deplacer(Labyrinthe.HAUT);
        assertEquals(1,p.getDx(),"x devrait etre egal 1");
        p.deplacer(Labyrinthe.BAS);
        p.deplacer(Labyrinthe.GAUCHE);
        assertEquals(2,p.getDx()," x != 2" );
        assertEquals(5,p.getDy()," x != 2" );
    }

    @Test
    public void testDeplacerPositionNegative(){
        Position p = new Position(-4,-7);
        p.deplacer(Labyrinthe.HAUT);
        assertEquals(-3,p.getDx(),"x != -3");
        p.deplacer(Labyrinthe.BAS);
        p.deplacer(Labyrinthe.GAUCHE);
        assertEquals(-4,p.getDx()," x != -4" );
        assertEquals(-8,p.getDy()," x != -8" );
    }

}