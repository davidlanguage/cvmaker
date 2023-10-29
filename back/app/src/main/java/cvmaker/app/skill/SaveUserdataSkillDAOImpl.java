package cvmaker.app.skill;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class SaveUserdataSkillDAOImpl implements SaveUserdataSkillDAO {

    private UserdataSkillRepository userdataSkillRepository;

    private UserdataSkillMapper userdataSkillMapper;
    @Override
    public void addSkill(final UserdataSkill userdataSkill) {
        userdataSkillRepository.save(userdataSkillMapper.mapToEntity(userdataSkill));
    }
}
