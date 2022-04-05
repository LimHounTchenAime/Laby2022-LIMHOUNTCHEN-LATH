import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) throws FichierIncorrectException {

        //chargement du labyrinthe et affichage de l'etat initial
        Labyrinthe l = Labyrinthe.chargerLabyrinthe(args[0]);
        System.out.println(l);

        //debut du jeu
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez saisir une direction : ");
        String direction = sc.nextLine();

        while (!l.etreFini() && !direction.equals("exit") ) {
            l.deplacerPerso(direction);
            System.out.println(l);

            System.out.println("Veuillez saisir une direction : ");
            direction = sc.nextLine();
        }
    }
}
