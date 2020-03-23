package Exceptions;

/**
 *
 * @author wizard
 */
public final class NoDataException extends Exception {

    /**
     * Creates a new instance of NoDataException
     */
    public NoDataException() {
    }

    public NoDataException(final String msg) {
        super(msg);
    }
}
