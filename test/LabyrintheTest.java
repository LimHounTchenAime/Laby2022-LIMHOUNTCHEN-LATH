import java.io.*;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class LabyrintheTest {

    @Test
    public void testChargerLabyrintheLaby0() {
        //chargement des donnees
        Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXX\n" + "XS....X\n" + "X..P..X\n" + "X.....X\n" + "XXXXXXX\n");
    }

    @Test
    public void testChargerLabyrintheLaby1() {
        //chargement des donnees
        Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/laby1.txt");

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXXXXX\n" +
                "X.....XX.X\n" +
                "X.XS.....X\n" +
                "X......X.X\n" +
                "X........X\n" +
                "X..XXP...X\n" +
                "XXXXXXXXXX\n");
    }

    @Test
    public void testChargerLabyrintheLaby2() {
        //chargement des donnees
        Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/laby2.txt");

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXXXXXXXXXXXXXXX\n" +
                "XX.......X........XX\n" +
                "X........X.........X\n" +
                "X........X...X.....X\n" +
                "X..X.....X.......SXX\n" +
                "X......XXX.........X\n" +
                "X...X....X.........X\n" +
                "X..X..........X....X\n" +
                "X.....X..X.........X\n" +
                "XX.......XX........X\n" +
                "X........X.........X\n" +
                "X........X.........X\n" +
                "XX...............PXX\n" +
                "XXXXXXXXXXXXXXXXXXXX\n");
    }

    @Test
    public void testGetSuivant(){
        //initialisation des variables
        int[] test=new int[2];
        test[0]=0;
        test[1]=1;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.HAUT), test);

        test[0]=1;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(0, 1, Labyrinthe.BAS), test);

        test[1]=2;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.DROITE), test);

        test[1]=1;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(1, 2, Labyrinthe.GAUCHE), test);
    }

    @Test
    public void testDeplacerPerso() throws ActionInconnueException{
        //chargement des donnes
        Labyrinthe labyrinthe=Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //methode a tester
        labyrinthe.deplacerPerso(Labyrinthe.HAUT);

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXX\n" +
                "XS.P..X\n" +
                "X.....X\n" +
                "X.....X\n" +
                "XXXXXXX\n");

        //methode a tester
        labyrinthe.deplacerPerso(Labyrinthe.BAS);

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXX\n" +
                "XS....X\n" +
                "X.....X\n" +
                "X..P..X\n" +
                "XXXXXXX\n");

        //methode a tester
        labyrinthe.deplacerPerso(Labyrinthe.GAUCHE);

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXX\n" +
                "XS....X\n" +
                "X.....X\n" +
                "XP....X\n" +
                "XXXXXXX\n");

        //methode a tester
        labyrinthe.deplacerPerso(Labyrinthe.DROITE);

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXX\n" +
                "XS....X\n" +
                "X.....X\n" +
                "X....PX\n" +
                "XXXXXXX\n");
    }
}