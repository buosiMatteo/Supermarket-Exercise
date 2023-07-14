package Exception;

public class UnvailableProductException extends Exception {
    public UnvailableProductException(){
        super("Il prodotto non è disponibile");
    }
}
