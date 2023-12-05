package cvmaker.app.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
//TODO: Create Unit Test
public class SaveSkillDAOImpl implements SaveSkillDAO{

    private final SkillRepository skillRepository;

    private final SkillMapper skillMapper;

    @Override
    public void saveSkill(final Skill skill) {
        skillRepository.save(skillMapper.mapToEntity(skill));
    }
}
