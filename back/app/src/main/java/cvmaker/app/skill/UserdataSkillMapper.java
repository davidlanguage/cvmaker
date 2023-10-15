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
public final class UserdataSkillMapper {

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

    UserdataSkillEntity mapToEntity(final UserdataSkill userdataSkill) {

        final List<SkillEntity> skills = getSkillsToEntity(userdataSkill);

        return UserdataSkillEntity
                .builder()
                .id(userdataSkill.getId())
                .skillId(skills)
                .userdataId(userdataMapper.mapToEntity(userdataSkill.getUserdataId()))
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

    private List<SkillEntity> getSkillsToEntity(UserdataSkill userdataSkill) {
        final List<SkillEntity> skills = new ArrayList<>();
        for (Skill skillG : userdataSkill.getSkillId()) {
            final SkillEntity skill = skillMapper.mapToEntity(skillG);
            skills.add(skill);
        }
        return skills;
    }
}
