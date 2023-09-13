package cvmaker.app.skill;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
class GetAllSkillsDAOImpl implements GetAllSkillsDAO{

    private final SkillRepository skillRepository;

    private final SkillMapper skillMapper;

    @Override
    public List<Skill> getAllSkills() {
        final List<SkillEntity> skillEntities = skillRepository.findAll();
        final List<Skill> skills = new ArrayList<>();
        skillEntities.forEach(skillEntity -> skills.add(skillMapper.map(skillEntity)));
        return skills;
    }
}
