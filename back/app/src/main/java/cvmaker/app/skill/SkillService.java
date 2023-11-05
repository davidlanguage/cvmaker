package cvmaker.app.skill;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SkillService {

    private GetAllSkillsDAO getAllSkillsDAO;
    private SaveSkillDAO saveSkillDAO;

    public List<Skill> getAllSkills(){
        return getAllSkillsDAO.getAllSkills();
    }

    public void saveSkill(final Skill skill){
        saveSkillDAO.saveSkill(skill);
    }

}
