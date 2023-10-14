package cvmaker.app.skill;

import cvmaker.app.userdata.UserData;
import cvmaker.app.userdata.UserDataEntity;
import cvmaker.app.userdata.UserdataMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class UserdataSkillMapper {

    private SkillMapper skillMapper;

    private UserdataMapper userdataMapper;

    UserdataSkill map(final UserdataSkillEntity userdataSkillEntity){

        final List<Skill> skills = getSkills(userdataSkillEntity);

        return UserdataSkill
                .builder()
                .id(userdataSkillEntity.getId())
                .skillId(skills)
                .userdataId(userdataMapper.map(userdataSkillEntity.getUserdataId()))
                .build();
    }

    private List<Skill> getSkills(UserdataSkillEntity userdataSkillEntity) {
        final List<Skill> skills = new ArrayList<>();
        for (SkillEntity skillEntity : userdataSkillEntity.getSkillId()) {
            Skill skill = skillMapper.map(skillEntity);
            skills.add(skill);
        }
        return skills;
    }

}
