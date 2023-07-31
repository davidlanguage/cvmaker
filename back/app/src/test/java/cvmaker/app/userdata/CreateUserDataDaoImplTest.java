package cvmaker.app.userdata;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration()
class CreateUserDataDaoImplTest {

    @Mock
    private UserdataMapper mapper;
    @Mock
    private UserDataRepository repository;

    private CreateUserDataDaoImpl dao;


    @BeforeEach
    void setUp() {
        dao = new CreateUserDataDaoImpl(mapper, repository);
    }

    @Test
    void should_createNewEntity_when_dataUserIsProvided() throws EmailHasWrongPatternError {
        //given
        final Long id = 7L;
        final String name = "Cristiano";
        final String lastname = "Ronaldo";
        final String email = "test@test.com";
        final String password = "secret1";

        final UserData userData = UserData
                .builder()
                .id(id)
                .name(name)
                .lastname(lastname)
                .email(email)
                .password(password)
                .build();

        final UserDataEntity userDataEntity = UserDataEntity
                .builder()
                .id(id)
                .name(name)
                .lastname(lastname)
                .email(email)
                .password(password)
                .build();
        given(mapper.mapToEntity(userData)).willReturn(userDataEntity);
        //when
        dao.create(userData);
        //then
    }
    @Test
    void should_throwWrongEmailPattern_when_emailProvidedIsWrong(){
        //given
        final String email = "wrongemail";

        final UserData userData = UserData
                .builder()
                .email(email)
                .build();

        //when
        final EmailHasWrongPatternError exception = Assertions.assertThrows(EmailHasWrongPatternError.class, ()-> {
            dao.create(userData);
        });

        final String expectedMessage = "The email provided is wrongly formatted";
        final String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));

    }

    @Test
    void should_createEmail_when_emailProvidedHasCorrectFormatting() throws EmailHasWrongPatternError {
        //given
        final String email = "test@test.com";

        final UserData userData = UserData
                .builder()
                .email(email)
                .build();

        //when
        final UserData returnedUserData = dao.create(userData);

        //then

        assertThat(userData.getEmail()).isEqualTo(returnedUserData.getEmail());


    }
}