package cvmaker.app.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
//TODO: Create Unit Test
class SaveLogDAOImpl implements SaveLogDAO {

    private final LoggerRepository repository;

    private final LoggerMapper mapper;

    @Override
    public void create(final Logger logger) {

        repository.save(mapper.mapToEntity(logger));
    }
}
