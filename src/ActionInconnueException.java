/**
 * classe permettant de generer des erreurs dues aux directions
 */
public class ActionInconnueException extends Exception {

    //constructeurs
    public ActionInconnueException(String message){
        super(message);
    }
}
