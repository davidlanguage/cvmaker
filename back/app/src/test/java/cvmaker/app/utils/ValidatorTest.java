package cvmaker.app.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration()
class ValidatorTest {

    @Test
    void should_validateEmail_when_emailPatternIsCorrect(){

        //given
        final String email = "test@test.com";

        //when
        final boolean validatedEmail = Validator.validateEmail(email);

        //then
        assertTrue(validatedEmail);

    }

    @Test
    void should_notValidateEmail_when_emailIsNull(){

        //when
        final boolean validatedEmail = Validator.validateEmail(null);

        //then
        assertFalse(validatedEmail);

    }

    @Test
    void should_notValidateEmail_when_atIsMissing(){

        //given
        final String email = "testtest.com";

        //when
        final boolean validatedEmail = Validator.validateEmail(email);

        //then
        assertFalse(validatedEmail);
    }

    @Test
    void should_notValidateEmail_when_dotIsMissing(){

        //given
        final String email = "test@testcom";

        //when
        final boolean validatedEmail = Validator.validateEmail(email);

        //then
        assertFalse(validatedEmail);
    }

    @Test
    void should_validatePassword_when_passwordPatternIsCorrect(){

        //given
        final String password = "Password123@";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertTrue(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordIsNull(){

        //when
        final boolean validatePassword = Validator.isValidPassword(null);

        //then
        assertFalse(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordHasFewerThanEightCharacters(){

        //given
        final String password = "Pass1!";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertFalse(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordHasMoreThanOrEqualToTwentyCharacters(){

        //given
        final String password = "12345678901234567aA!";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertTrue(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordDoesNotContainASingleDigit(){

        //given
        final String password = "PasswordGGGG@";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertFalse(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordDoesNotContainASingleUpperCase(){

        //given
        final String password = "password12345@";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertFalse(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordDoesNotContainASingleLowerCase(){

        //given
        final String password = "PASSWORD12345@";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertFalse(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordDoesNotContainASingleSpecialCharacter(){

        //given
        final String password = "Password1234567890";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertFalse(validatePassword);

    }

    @Test
    void should_noValidatePassword_when_passwordIncludesOneOrMoreWhiteSpaces(){

        //given
        final String password = "     Password12345!";

        //when
        final boolean validatePassword = Validator.isValidPassword(password);

        //then
        assertFalse(validatePassword);

    }

}