package cvmaker.app.userdata;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration()
class UserDataMapperTest {

    private UserdataMapper userdataMapper;
    @BeforeEach
    void setUp() {
        userdataMapper = new UserdataMapper();
    }

    @Test
    void should_returnNullForNullableFields_when_userdataEntityContainsNullFields(){
        //given
        final String email = "testemail@test.com";
        final UserDataEntity userDataEntity = UserDataEntity.builder().email(email).build();

        //when
        final UserData returnedUserData = userdataMapper.map(userDataEntity);

        //then
        assertThat(returnedUserData.getId()).isNull();
        assertThat(returnedUserData.getFirstname()).isNull();
        assertThat(returnedUserData.getLastname()).isNull();
        assertThat(returnedUserData.getEmail()).isNotNull();
        assertThat(returnedUserData.getPassword()).isNull();
    }

    @Test
    void should_map_when_userDataEntity(){
        //given
        final Long id = 1L;
        final String name = "Name";
        final String lastname = "Lastname";
        final String email = "email";
        final String password = "password";

        final UserDataEntity userDataEntity =
                UserDataEntity
                        .builder()
                        .id(id)
                        .firstname(name)
                        .lastname(lastname)
                        .email(email)
                        .password(password)
                        .build();

        final UserData expectedUserData =
                UserData
                        .builder()
                        .id(id)
                        .firstname(name)
                        .lastname(lastname)
                        .email(email)
                        .password(password)
                        .build();

        //when
        final UserData returnedUserData = userdataMapper.map(userDataEntity);

        //then
        assertThat(expectedUserData).usingRecursiveComparison().isEqualTo(returnedUserData);
    }

    @Test
    void should_map_when_DataEntity(){
        //given
        final Long id = 1L;
        final String name = "Name";
        final String lastname = "Lastname";
        final String email = "email";
        final String password = "password";

        final UserDataEntity expectedUserDataEntity =
                UserDataEntity
                        .builder()
                        .id(id)
                        .firstname(name)
                        .lastname(lastname)
                        .email(email)
                        .password(password)
                        .build();

        final UserData userData =
                UserData
                        .builder()
                        .id(id)
                        .firstname(name)
                        .lastname(lastname)
                        .email(email)
                        .password(password)
                        .build();

        //when
        final UserDataEntity returnedUserDataEntity = userdataMapper.mapToEntity(userData);

        //then
        assertThat(expectedUserDataEntity).usingRecursiveComparison().isEqualTo(returnedUserDataEntity);
    }
}