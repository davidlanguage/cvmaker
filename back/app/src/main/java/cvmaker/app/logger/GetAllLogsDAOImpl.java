package cvmaker.app.logger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllLogsDAOImpl implements  GetAllLogsDAO {

    private final LoggerRepository repository;
    private final LoggerMapper mapper;


    @Override
    public List<Logger> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::map)
                .toList();
    }
}
