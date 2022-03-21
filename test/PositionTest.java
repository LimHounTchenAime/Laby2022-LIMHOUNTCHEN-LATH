import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    public void testDeplacerPositionPositive(){
        //Test si x se deplace vers le haut
        Position p = new Position(2,6);
        p.deplacer(Labyrinthe.HAUT);
        assertEquals(1,p.getDx(),"x devrait etre egal 1");
        //Test de déplacement de x,y
        p.deplacer(Labyrinthe.BAS);
        p.deplacer(Labyrinthe.GAUCHE);
        assertEquals(2,p.getDx()," x != 2" );
        assertEquals(5,p.getDy()," x != 2" );
    }

    @Test
    public void testDeplacerPositionNegative(){
        //Test de x avec des coordonnees negatives
        Position p = new Position(-4,-7);
        p.deplacer(Labyrinthe.BAS);
        assertEquals(-3,p.getDx(),"x != -3");
        p.deplacer(Labyrinthe.HAUT);
        p.deplacer(Labyrinthe.GAUCHE);
        assertEquals(-4,p.getDx()," x != -3" );
        assertEquals(-8,p.getDy()," x != -8" );
    }

}