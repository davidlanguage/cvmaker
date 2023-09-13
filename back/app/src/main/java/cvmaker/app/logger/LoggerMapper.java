package cvmaker.app.logger;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoggerMapper {

    public Logger map(final LoggerEntity logger) {
        return Logger
                .builder()
                .id(logger.getId())
                .message(logger.getMessage())
                .timestamp(logger.getTimestamp())
                .build();
    }

    public LoggerEntity mapToEntity(final Logger logger) {
        return LoggerEntity
                .builder()
                .id(logger.getId())
                .message(logger.getMessage())
                .timestamp(logger.getTimestamp())
                .build();
    }
}
