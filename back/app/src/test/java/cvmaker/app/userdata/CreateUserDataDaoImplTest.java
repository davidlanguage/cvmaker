package cvmaker.app.userdata;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

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
    void should_createNewEntity_when_dataUserIsProvided(){

        //given
        final Long id = 7L;
        final String name = "Cristiano";
        final String lastname = "Ronaldo";
        final String email = "test@test.com";
        final String password = "Password12345!";

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
        final boolean userCreated = dao.create(userData);

        //then
        assertTrue(userCreated);
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
        final boolean createdUserData = dao.create(userData);

        //then
        assertFalse(createdUserData);

    }

    @Test
    void should_createUserData_when_emailAndPasswordProvidedHaveCorrectFormatting(){
        //given
        final String email = "test@test.com";
        final String password = "Password12345!";

        final UserData userData = UserData
                .builder()
                .email(email)
                .password(password)
                .build();

        //when
        final boolean createdUserData = dao.create(userData);

        //then
        assertTrue(createdUserData);

    }

    @Test
    void should_notCreateUserData_when_emailProvidedDoesntHaveCorrectFormatting(){
        //given
        final String email = "wrongformat";
        final String password = "Password12345!";

        final UserData userData = UserData
                .builder()
                .email(email)
                .password(password)
                .build();

        //when
        final boolean createdUserData = dao.create(userData);

        //then
        assertFalse(createdUserData);

    }

    @Test
    void should_notCreateUserData_when_passwordProvidedDoesntHaveCorrectFormatting(){
        //given
        final String email = "test@test.com";
        final String password = "wrongformat!";

        final UserData userData = UserData
                .builder()
                .email(email)
                .password(password)
                .build();

        //when
        final boolean createdUserData = dao.create(userData);

        //then
        assertFalse(createdUserData);

    }
}