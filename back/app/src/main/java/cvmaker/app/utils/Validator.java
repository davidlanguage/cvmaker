package cvmaker.app.utils;

import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validator {

    private Validator(){}

    public static boolean validateEmail(final String email){

        final Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");

        final Matcher matcher = emailPattern.matcher(email);

        return matcher.find();

    }

    public static boolean validatePassword(final String password){

        return password.length() >= 8;
    }
}
