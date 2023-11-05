package cvmaker.app.skill;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillService {

    private GetAllSkillsDAO getAllSkillsDAO;
    private SaveSkillDAO saveSkillDAO;

}
