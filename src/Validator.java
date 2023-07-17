import java.util.NoSuchElementException;
import max.*;

public class Validator {
    public static boolean isValid(String email)
            throws NullPointerException, NoSuchElementException {

        if (isEmpty(email)) {
            throw new NullPointerException("ERROR: E-Mail is null or empty!");
        }
        if (!length(email)) {
            throw new NullPointerException("ERROR: E-Mail doesn't match standards, it is to short!");
        }
        if (!gotAt(email)) {
            throw new NoSuchElementException("ERROR: E-Mail doesn't match standards, it doesn't contain '@'!");
        }

        return true;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static boolean length(String text) {
        return text.length() >= 10;
    }

    private static boolean gotAt(String text) {
        return text.contains("@");
    }

}
