package cvmaker.app.logger;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class LoggerMapperTest {

    private LoggerMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new LoggerMapper();
    }

    @Test
    void should_mapToPOJO_when_map(){

        //given
        final Long id = 7L;
        final String message = "My Message";
        final LocalDateTime dateTime = LocalDateTime.now();

        final LoggerEntity loggerEntity = LoggerEntity
                .builder()
                .id(id)
                .message(message)
                .timestamp(dateTime)
                .build();

        final Logger expectedLogger = Logger
                .builder()
                .id(id)
                .message(message)
                .timestamp(dateTime)
                .build();

        //when
        final Logger returnedLogger = mapper.map(loggerEntity);

        //then
        Assertions.assertThat(returnedLogger).usingRecursiveComparison()
                .ignoringAllOverriddenEquals().isEqualTo(expectedLogger);

    }

    @Test
    void should_mapToEntity_when_mapToEntity(){

        //given
        final Long id = 7L;
        final String message = "My Message";
        final LocalDateTime dateTime = LocalDateTime.now();

        final Logger logger = Logger
                .builder()
                .id(id)
                .message(message)
                .timestamp(dateTime)
                .build();

        final LoggerEntity expectedLoggerEntity = LoggerEntity
                .builder()
                .id(id)
                .message(message)
                .timestamp(dateTime)
                .build();

        //when
        final LoggerEntity returnedLoggerEntity = mapper.mapToEntity(logger);

        //then
        Assertions.assertThat(returnedLoggerEntity).usingRecursiveComparison()
                .ignoringAllOverriddenEquals().isEqualTo(expectedLoggerEntity);

    }
}