package cvmaker.app.userdata;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        assertThat(returnedUserData.getName()).isNull();
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
                        .name(name)
                        .lastname(lastname)
                        .email(email)
                        .password(password)
                        .build();

        final UserData expectedUserData =
                UserData
                        .builder()
                        .id(id)
                        .name(name)
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
                        .name(name)
                        .lastname(lastname)
                        .email(email)
                        .password(password)
                        .build();

        final UserData userData =
                UserData
                        .builder()
                        .id(id)
                        .name(name)
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