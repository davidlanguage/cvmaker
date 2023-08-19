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
    void should_returnNullForAllFields_when_userdataEntityContainsNullFields(){
        //given
        final UserDataEntity userDataEntity = UserDataEntity.builder().build();

        //when
        final UserData returnedUserData = userdataMapper.map(userDataEntity);

        //then
        assertThat(returnedUserData).hasAllNullFieldsOrProperties();

    }

    @Test
    void should_map_when_userDataEntity(){
        //given
        final Long id = 1L;
        final String name = "Name";
        final String lastname = "Lastname";
        final String email = "email";
        final String password = "password";
        final String country = "Spain";
        final Role role = Role.USER;

        final UserDataEntity userDataEntity =
                UserDataEntity
                        .builder()
                        .id(id)
                        .firstname(name)
                        .lastname(lastname)
                        .username(email)
                        .password(password)
                        .country(country)
                        .role(role)
                        .build();

        final UserData expectedUserData =
                UserData
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
        final String country = "country";
        final Role role = Role.USER;

        final UserDataEntity expectedUserDataEntity =
                UserDataEntity
                        .builder()
                        .id(id)
                        .firstname(name)
                        .lastname(lastname)
                        .username(email)
                        .password(password)
                        .country(country)
                        .role(role)
                        .build();

        final UserData userData =
                UserData
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
        final UserDataEntity returnedUserDataEntity = userdataMapper.mapToEntity(userData);

        //then
        assertThat(expectedUserDataEntity).usingRecursiveComparison().isEqualTo(returnedUserDataEntity);
    }
}