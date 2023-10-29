package cvmaker.app.skill;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public final class UserdataSkillMapper {

    UserdataSkill map(final UserdataSkillEntity userdataSkillEntity){
        return UserdataSkill
                .builder()
                .id(userdataSkillEntity.getId())
                .skillId(userdataSkillEntity.getSkillId())
                .userdataId(userdataSkillEntity.getUserdataId())
                .build();
    }

    UserdataSkillEntity mapToEntity(final UserdataSkill userdataSkill){
        return UserdataSkillEntity
                .builder()
                .id(userdataSkill.getId())
                .skillId(userdataSkill.getSkillId())
                .userdataId(userdataSkill.getUserdataId())
                .build();
    }

}
