package cvmaker.app.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveSkillDAOImpl implements SaveSkillDAO{

    private final SkillRepository skillRepository;

    private final SkillMapper skillMapper;

    @Override
    public void saveSkill(Skill skill) {
        skillRepository.save(skillMapper.mapToEntity(skill));
    }
}
