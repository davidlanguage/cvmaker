package cvmaker.app.skill;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
//TODO: Create unit test
public class SkillService {

    private GetAllSkillsDAO getAllSkillsDAO;
    private SaveSkillDAO saveSkillDAO;

    public List<Skill> getAllSkills(){
        return getAllSkillsDAO.getAllSkills();
    }

    public void saveSkill(final Skill skill){
        saveSkillDAO.saveSkill(skill);
    }

    public static Boolean getSkillAlreadyExists(final Skill createdSkill, final List<Skill> allSkills) {
        return allSkills.stream().anyMatch(skill -> skill.getSkillName().equalsIgnoreCase(createdSkill.getSkillName()));
    }

}
