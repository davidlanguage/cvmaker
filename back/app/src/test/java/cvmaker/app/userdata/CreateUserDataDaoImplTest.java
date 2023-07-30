package cvmaker.app.userdata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.BDDMockito.given;

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
}