import java.io.*;

import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;


class LabyrintheTest {

    /**
     * verifie le bon chargement et affichage du labyrinthe laby0.txt avec le bon format
     * @throws ActionInconnueException
     * @throws IOException
     */
    @Test
    public void testChargerLabyrintheLaby0() throws ActionInconnueException, IOException {
        //chargement des donnees
        Labyrinthe labyrinthe = Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

        //verification
        assertEquals(labyrinthe.toString(), "XXXXXXX\n" + "XS....X\n" + "X..P..X\n" + "X.....X\n" + "XXXXXXX\n");
    }

    /**
     * verifie le bon chargement et affichage du labyrinthe laby1.txt avec le bon format
     * @throws ActionInconnueException
     * @throws IOException
     */
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

    /**
     * verifie le bon chargement et affichage du labyrinthe laby2.txt avec le bon format
     * @throws ActionInconnueException
     * @throws IOException
     */
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

    /**
     * verifie le bon fonctionnement de la methode getSuivant(int x, int y, String direction)
     */
    @Test
    public void testGetSuivant() throws ActionInconnueException{
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

    /**
     * test le bon deplacement du personnage dans le labyrinthe
     * @throws ActionInconnueException
     * @throws IOException
     */
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

    /**
     * verifie l'envoi de l'exception FichierIncorrectException lorsque le labyrinthe a deux sorties
     * @throws IOException
     */
    @Test
    public void testLabyDeuxSortie() throws IOException, ActionInconnueException{
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

    /**
     * verifie l'envoi de l'exception FichierIncorrectException lorsque le labyrinthe n'a pas de sortie
     * @throws IOException
     */
    @Test
    public void testLabyPasDeSortie() throws IOException, ActionInconnueException{
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

    /**
     * verifie l'envoi de l'exception FichierIncorrectException lorsque le labyrinthe contient un element eronne
     * @throws IOException
     */
    @Test
    public void testLabyElementIncorrect() throws IOException, ActionInconnueException{
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

    /**
     * verifie l'envoi de l'exception FichierIncorrectException lorsque le labyrinthe ne contient pas de personnage
     * @throws IOException
     */
    @Test
    public void testLabyPasPersonnage() throws IOException, ActionInconnueException{
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

    /**
     * verifie l'envoi de l'exception FichierIncorrectException lorsque le labyrinthe contient deux personnages
     * @throws IOException
     */
    @Test
    public void testLabyDeuxPersonnage() throws IOException, ActionInconnueException{
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

    /**
     * verifie l'envoi de l'exception FichierIncorrectException lorsque ne respecte pas les dimensions declarees
     * @throws IOException
     */
    @Test
    public void testDimensionsIncorrectes() throws IOException, ActionInconnueException{
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

    /**
     * verifie l'envoi de l'exception ActionInconnueException lorsqu'on essaie de deplacer le personnage avec une direction inconnue
     */
    @Test
    public void testDirectionInconnue() throws IOException{
        String res="";
        try{
            //initialisation des donnees
            Labyrinthe labyrinthe=Labyrinthe.chargerLabyrinthe("laby/laby0.txt");

            //methode a tester
            labyrinthe.deplacerPerso("test");
        }
        catch (ActionInconnueException e){
            res=e.getMessage();
        }

        //verification
        assertEquals("direction inconnue", res);
    }
}