package cvmaker.app.userdata;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
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
        final String country = "Portugal";
        final Role role = Role.USER;

        final UserData expectedUserData = UserData
                .builder()
                .id(id)
                .firstname(name)
                .lastname(lastname)
                .username(email)
                .password(password)
                .country(country)
                .role(role)
                .build();

        final UserDataEntity userDataEntity = UserDataEntity
                .builder()
                .id(id)
                .firstname(name)
                .lastname(lastname)
                .username(email)
                .password(password)
                .country(country)
                .role(role)
                .build();

        given(mapper.mapToEntity(expectedUserData)).willReturn(userDataEntity);

        //when
        dao.create(userDataEntity);
        final UserDataEntity userUserDataEntity = mapper.mapToEntity(expectedUserData);

        //then
        assertThat(userUserDataEntity).usingRecursiveComparison().isEqualTo(userDataEntity);

    }

    @Test
    void should_createNewUserData_when_create(){
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

        //when
        dao.create(expectedUserDataEntity);

        //then
        final ArgumentCaptor<UserDataEntity> userDataArgumentCaptor =
                ArgumentCaptor.forClass(UserDataEntity.class);

        verify(repository)
                .save(userDataArgumentCaptor.capture());

        final UserDataEntity capturedUserDataEntity = userDataArgumentCaptor.getValue();

        assertThat(capturedUserDataEntity).usingRecursiveComparison().isEqualTo(expectedUserDataEntity);

    }

}