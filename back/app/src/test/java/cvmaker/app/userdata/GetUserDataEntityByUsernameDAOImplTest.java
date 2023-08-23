package cvmaker.app.userdata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Objects;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class GetUserDataEntityByUsernameDAOImplTest {

    @Mock
    private UserDataRepository userDataRepository;

    private AutoCloseable autoCloseable;
    private GetUserDataEntityByUsernameDAOImpl getUserDataEntityByUsernameDAO;

    @BeforeEach
    void setUp() {
        //the keyword "this" is for all the @Mock in this class
        autoCloseable = MockitoAnnotations.openMocks(this);
        getUserDataEntityByUsernameDAO = new GetUserDataEntityByUsernameDAOImpl(userDataRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void should_findByUsernameIsCalled_when_daoIsCalled(){
        //given
        final String email = "email@email.com";

        //when
        getUserDataEntityByUsernameDAO.findByUsername(email);

        //then
        verify(userDataRepository).findByUsername(email);
    }

    @Test
    void should_returnExpectedEntity_when_usernameIsFound(){
        //given
        final Long id = 7L;
        final String name = "Cristiano";
        final String lastname = "Ronaldo";
        final String email = "test@test.com";
        final String password = "Password12345!";
        final String country = "Portugal";
        final Role role = Role.USER;

        final UserDataEntity expectedUserDataEntity = UserDataEntity
                .builder()
                .id(id)
                .firstname(name)
                .lastname(lastname)
                .username(email)
                .password(password)
                .country(country)
                .role(role)
                .build();

        given(userDataRepository.findByUsername(email)).willReturn(Optional.ofNullable(expectedUserDataEntity));
        //when
        final UserDataEntity returnedUserDataEntity = getUserDataEntityByUsernameDAO
                .findByUsername(Objects.requireNonNull(expectedUserDataEntity).getUsername());

        //then
        assertThat(expectedUserDataEntity).usingRecursiveComparison().isEqualTo(returnedUserDataEntity);
    }

    @Test
    void should_returnNullValues_when_usernameEmpty(){
        //given
        final String email = "";
        final String fieldToIgnoreForNullValue = "username";

        final UserDataEntity expectedUserDataEntity = UserDataEntity
                .builder()
                .username(email)
                .build();

        given(userDataRepository.findByUsername(email)).willReturn(Optional.ofNullable(expectedUserDataEntity));
        //when
        final UserDataEntity returnedUserDataEntity = getUserDataEntityByUsernameDAO
                .findByUsername(Objects.requireNonNull(expectedUserDataEntity).getUsername());

        //then
        assertThat(expectedUserDataEntity).hasAllNullFieldsOrPropertiesExcept(fieldToIgnoreForNullValue);
        assertThat(expectedUserDataEntity.getUsername()).isEmpty();
    }

}