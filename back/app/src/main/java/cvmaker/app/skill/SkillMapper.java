package cvmaker.app.skill;

import org.springframework.stereotype.Component;

@Component
public final class SkillMapper {
    public Skill map(final SkillEntity skillEntity){
        return Skill
                .builder()
                .id(skillEntity.getId())
                .skillName(skillEntity.getSkillName())
                .build();
    }

    public SkillEntity mapToEntity(final Skill skill){
        return SkillEntity
                .builder()
                .id(skill.getId())
                .skillName(skill.getSkillName())
                .build();
    }
}
