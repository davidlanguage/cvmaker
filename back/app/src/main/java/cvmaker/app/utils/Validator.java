package cvmaker.app.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validator {

    private Validator(){}

    public static boolean validateEmail(final String email){

        if (email == null){
            return false;
        }

        final Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        final Matcher matcher = emailPattern.matcher(email);

        return matcher.find();

    }

    /** REGEX VALIDATION: <a href="https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/">Source</a>
     * It contains at least 8 characters and at most 20 characters.
     * It contains at least one digit.
     * It contains at least one upper case alphabet.
     * It contains at least one lower case alphabet.
     * It contains at least one special character which includes !@#$%&*()-+=^.
     * It doesn’t contain any white space.
     * */
    public static boolean isValidPassword(final String password){

        if (password == null){
            return false;
        }

        final String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[!@#$%&*()-+=^])"
                + "(?=\\S+$).{8,20}$";

        final Pattern pattern = Pattern.compile(regex);

        final Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }


}
