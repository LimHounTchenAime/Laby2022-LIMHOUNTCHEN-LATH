import java.io.IOException;

public class FichierIncorrectException extends IOException {
    //constructeurs
    public FichierIncorrectException(){
        super();
    }

    public FichierIncorrectException(String message){
        super(message);
    }
}
