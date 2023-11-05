package cvmaker.app.logger;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LoggerService {

    private final SaveLogDAO saveLogDAO;

    private final GetAllLogsDAO getAllLogsDAO;

    public void create(final Logger logger){
        saveLogDAO.create(logger);
    }

    public List<Logger> getAllLogs(){
        return getAllLogsDAO.getAll();
    }
}
