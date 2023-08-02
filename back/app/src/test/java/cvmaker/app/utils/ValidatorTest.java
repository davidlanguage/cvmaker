package cvmaker.app.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration()
class ValidatorTest {

    @BeforeEach
    void setUp() {
    }

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
    void should_validatePassword_when_passwordPatternIsCorrect(){
        //given
        final String password = "Password123!";
        //when
        final boolean validatePassword = Validator.validatePassword(password);
        //then
        assertTrue(validatePassword);

    }

    //TODO create further tests for untested invalid password and email conditions

}