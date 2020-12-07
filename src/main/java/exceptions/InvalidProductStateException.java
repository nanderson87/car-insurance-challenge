package exceptions;

public class InvalidProductStateException extends RuntimeException {

    public InvalidProductStateException(String msg) {
        super(msg);
    }

}
