package cvmaker.app.userdata;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserDataRepositoryTest {

    @Autowired
    private UserDataRepository repository;

    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

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

    @Test
    void should_notFindByUsername_when_usernameProvidedIsWrong(){
        //given
        final String notSuchElementExceptionMessage = "No value present";
        final String fakeEmail = "fake_email";
        //when
        final Throwable exception = assertThrows(NoSuchElementException.class,
                ()-> repository.findByUsername(fakeEmail).orElseThrow());

        //then
        assertEquals(notSuchElementExceptionMessage, exception.getMessage());

    }
}