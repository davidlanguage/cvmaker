package cvmaker.app.skill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@ContextConfiguration()
class UserdataSkillMapperTest {

    private Long id;

    private Long userdataId;

    private Long skillId;

    private UserdataSkillMapper userdataSkillMapper;

    @BeforeEach
    void setUp() {
        userdataSkillMapper = new UserdataSkillMapper();
        id = 1789L;
        userdataId = 1492L;
        skillId = 2077L;
    }

    @Test
    void should_map_when_map(){

        final UserdataSkillEntity userdataSkillEntity = UserdataSkillEntity
                .builder()
                .id(id)
                .skillId(userdataId)
                .userdataId(userdataId)
                .build();
        final UserdataSkill expectedUserData = UserdataSkill
                .builder()
                .id(id)
                .skillId(userdataId)
                .userdataId(userdataId)
                .build();

        final UserdataSkill returnedUserdataSkill = userdataSkillMapper.map(userdataSkillEntity);

        assertThat(expectedUserData).usingRecursiveComparison().ignoringAllOverriddenEquals().isEqualTo(returnedUserdataSkill);
    }

    @Test
    void should_mapToEntity_when_mapToEntity(){

        final UserdataSkill userdataSkill = UserdataSkill
                .builder()
                .id(id)
                .skillId(userdataId)
                .userdataId(userdataId)
                .build();
        final UserdataSkillEntity expectedUserdataSkillEntity = UserdataSkillEntity
                .builder()
                .id(id)
                .skillId(userdataId)
                .userdataId(userdataId)
                .build();

        final UserdataSkillEntity returnedUserdataskillEntity = userdataSkillMapper.mapToEntity(userdataSkill);

        assertThat(userdataSkill).usingRecursiveComparison().ignoringAllOverriddenEquals().isEqualTo(returnedUserdataskillEntity);

    }
}