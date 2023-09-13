package cvmaker.app.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CreateLogDAOImpl implements CreateLogDAO{

    private final LoggerRepository repository;

    private final LoggerMapper mapper;

    @Override
    public void create(final Logger logger) {

        final LoggerEntity loggerEntity = mapper.mapToEntity(logger);

        repository.save(loggerEntity);
    }
}
