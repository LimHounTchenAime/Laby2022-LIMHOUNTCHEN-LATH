import java.util.Scanner;

public class MainLaby {
    public static void main(String[] args) {

        //chargement du labyrinthe et affichage de l'etat initial
        Labyrinthe l = Labyrinthe.chargerLabyrinthe(args[0]);
        System.out.println(l);

        //debut du jeu
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez saisir une direction : ");
        String direction = sc.nextLine();

        while (!l.etreFini() && !direction.equals("exit")) {
            try {
                l.deplacerPerso(direction);
            }
            catch (ActionInconnueException e){
                System.out.println("action inconnue");
            }
            System.out.println(l);
            if(l.etreFini()){
                System.out.println("Vous avez gagne");
                System.exit(0);
            }
            if (!l.etreFini()) {

                System.out.println("Veuillez saisir une direction : ");
                direction = sc.nextLine();
            }
        }
    }
}
