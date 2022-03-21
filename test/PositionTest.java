import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void testDeplacer(){
        Position p = new Position(2,3);
        p.deplacer(Position.HAUT);
        assertEquals(p.getDx(),1);
    }

}