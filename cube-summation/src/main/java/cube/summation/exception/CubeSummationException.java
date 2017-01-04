package cube.summation.exception;

/**
 *
 * @author sergioleottau
 */
public class CubeSummationException extends Exception {

    public CubeSummationException() {
    }

    public CubeSummationException(String message) {
        super(message);
    }

    public CubeSummationException(String message, Throwable cause) {
        super(message, cause);
    }

    public CubeSummationException(Throwable cause) {
        super(cause);
    }

}
