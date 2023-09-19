package cvmaker.app.skill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration()
class SkillMapperTest {

    private SkillMapper skillMapper;
    private Long id;
    private String skillName;


    @BeforeEach
    void setUp(){
        skillMapper = new SkillMapper();
        id = 76L;
        skillName = "Godly Creation";
    }

    @Test
    void should_mapToPOJO_when_map() {

        //given
        final SkillEntity skillEntity = SkillEntity
                .builder()
                .id(id)
                .skillName(skillName)
                .build();

        final Skill expectedSkill = Skill
                .builder()
                .id(id)
                .skillName(skillName)
                .build();

        //when
        final Skill returnedSkill = skillMapper.map(skillEntity);

        //then
        assertThat(returnedSkill).usingRecursiveComparison().ignoringAllOverriddenEquals().isEqualTo(expectedSkill);
    }

    @Test
    void should_mapToEntity_when_mapToEntity() {
        //given
        final Skill skill = Skill
                .builder()
                .id(id)
                .skillName(skillName)
                .build();

        final SkillEntity expectedSkillEntity = SkillEntity
                .builder()
                .id(id)
                .skillName(skillName)
                .build();

        //when
        final SkillEntity returnedSkillEntity = skillMapper.mapToEntity(skill);

        //then
        assertThat(returnedSkillEntity).usingRecursiveComparison()
                .ignoringAllOverriddenEquals().isEqualTo(expectedSkillEntity);
    }
}