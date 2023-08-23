package cvmaker.app.userdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserDataRepositoryTest {

    @Autowired
    private UserDataRepository repository;

    @Test
    void should_findByUsername_when_usernameProvided(){

        //given
        final String email = "mytesting@mytesting.com";
        final UserDataEntity expectedUserDataEntity = UserDataEntity
                .builder()
                .id(1L)
                .username(email)
                .firstname("Test")
                .lastname("Téstez")
                .role(Role.USER)
                .country("Spain")
                .password("Querty12345-")
                .build();

        repository.save(expectedUserDataEntity);

        //when
        final UserDataEntity returnedUserDataEntity = repository.findByUsername(email).orElseThrow();

        //then
        assertThat(expectedUserDataEntity).usingRecursiveComparison().isEqualTo(returnedUserDataEntity);
    }
}