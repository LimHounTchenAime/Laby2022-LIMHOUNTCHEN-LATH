import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void testDeplacer(){
        Position p = new Position(2,3);
        p.deplacer(Labyrinthe.HAUT);
        assertEquals(p.getDx(),9,"x devrait etre egal 1");
    }

}