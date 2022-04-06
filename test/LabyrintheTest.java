import java.io.*;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class LabyrintheTest {

    @Test
    public void testChargerLabyrintheLaby0() throws ActionInconnueException, IOException {
        //chargement des donnees
        Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXX\n" + "XS....X\n" + "X..P..X\n" + "X.....X\n" + "XXXXXXX\n");
    }

    @Test
    public void testChargerLabyrintheLaby1() throws ActionInconnueException, IOException {
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
    public void testChargerLabyrintheLaby2() throws ActionInconnueException, IOException {
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
    public void testGetSuivant() {
        //initialisation des variables
        int[] test = new int[2];
        test[0] = 0;
        test[1] = 1;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.HAUT), test);

        test[0] = 1;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(0, 1, Labyrinthe.BAS), test);

        test[1] = 2;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(1, 1, Labyrinthe.DROITE), test);

        test[1] = 1;

        //verification methode a tester
        assertArrayEquals(Labyrinthe.getSuivant(1, 2, Labyrinthe.GAUCHE), test);
    }

    @Test
    public void testDeplacerPerso() throws ActionInconnueException, IOException {
        //chargement des donnes
        Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

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

    @Test
    public void testLabyDeuxSortie() throws IOException{
        String res = "";
        try {
            //initialisation des donnees et methode a tester
            Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/laby_deuxSortie.txt");
        } catch (FichierIncorrectException e) {
            res = e.getMessage();
        }

        //verification
        assertEquals("il y a plus d'une sortie dans le labyrinthe", res);
    }

    @Test
    public void testLabyPasDeSortie() throws IOException {
        String res ="";
        try{
            //initialisation des donnees et methode a tester
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/laby_pasSortie.txt");
        }catch (FichierIncorrectException fie){
           res = fie.getMessage();
        }

        //verification
        assertEquals("il n'y a pas de sortie ou de personnage", res);
    }

    @Test
    public void testLabyElementIncorrect() throws IOException{
        String res ="";
        try {
            //initialisation des donnees et methode a tester
            Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/testLabyElementIncorrect.txt");
        }
        catch (FichierIncorrectException e){
            res = e.getMessage();
        }

        //verification
        assertEquals("un element du labyrinthe est inconnu", res);
    }

    @Test
    public void testLabyPasPersonnage() throws IOException{
        String res ="";
        try{
            //initialisation des donnees et methode a tester
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/testLabyPasPersonnage.txt");
        }catch (FichierIncorrectException e){
            res = e.getMessage();
        }

        //verification
        assertEquals("il n'y a pas de sortie ou de personnage", res);
    }

    @Test
    public void testLabyDeuxPersonnage() throws IOException{
        String res ="";
        try{
            //initialisation des donnees et methode a tester
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/testLabyDeuxPersonnages.txt");
        }catch (FichierIncorrectException e){
            res = e.getMessage();
        }

        //verification
        assertEquals("il y a plus d'un personnage dans le labyrinthe", res);
    }

    @Test
    public void testDimensionsIncorrectes() throws IOException{
        String res ="";
        try{
            //initialisation des donnees et methode a tester
            Labyrinthe l = Labyrinthe.chargerLabyrinthe("laby/testDimensionsIncorrectes.txt");
        }catch (FichierIncorrectException e){
            res = e.getMessage();
        }

        //verification
        assertEquals("le nombre de lignes/colonnes annonce ne correspond pas au labyrinthe", res);
    }
}