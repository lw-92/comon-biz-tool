package exception;

/**
 * @author wei.li
 * @date 2018/11/18 10:00
 * @desc
 */
public class FileNotSurportException extends RuntimeException{

    public FileNotSurportException(String message) {
        super(message);
    }

    public FileNotSurportException(String message, Throwable cause) {
        super(message, cause);
    }
}
