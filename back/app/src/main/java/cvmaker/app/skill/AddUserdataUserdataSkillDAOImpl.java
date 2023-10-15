package cvmaker.app.skill;

import cvmaker.app.userdata.UserData;
import cvmaker.app.userdata.UserDataEntity;
import cvmaker.app.userdata.UserdataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AddUserdataUserdataSkillDAOImpl implements AddUserdataSkillDAO {

    private final UserdataSkillRepository userdataSkillRepository;
    
    private final SkillMapper skillMapper;
    
    private final UserdataMapper userdataMapper;

    @Override
    public void addSkill(final Skill skill, final UserData userdata) {

        final List<SkillEntity> skills = getSkillEntities(skill);

        final UserDataEntity userDataEntity = userdataMapper.mapToEntity(userdata);

        final UserdataSkillEntity userdataSkill = UserdataSkillEntity
                .builder()
                .userdataId(userDataEntity)
                .skillId(skills)
                .build();
        
        userdataSkillRepository.save(userdataSkill);
    }

    private List<SkillEntity> getSkillEntities(final Skill skill) {
        final List<SkillEntity> skills = new ArrayList<>();

        skills.add(skillMapper.mapToEntity(skill));
        return skills;
    }
}
