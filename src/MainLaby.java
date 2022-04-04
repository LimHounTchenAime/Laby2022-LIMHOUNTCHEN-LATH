import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) throws FichierIncorrectException {

        //chargement du labyrinthe et affichage de l'etat initial
        Labyrinthe l = Labyrinthe.chargerLabyrinthe(args[0]);
        String s = l.toString();
        System.out.println(s);

        //debut du jeu
        Scanner sc = new Scanner(System.in);
        String direction = "";

        int[] suivant;
        //sortie

        //personnage

        while (!l.etreFini()) {

            //exit -> sort labyrinthe
            direction = sc.nextLine();
            if (!direction.equals("exit")) {
                l.setPersonn;

            }else{

                if(get)
            }
        }
    }
}
