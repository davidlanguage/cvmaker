package cvmaker.app.skill;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
class SkillServiceTest {

    @Autowired
    private MockMvc mockMvc;

    private SkillService skillService;

    @MockBean
    private GetAllSkillsDAO getAllSkillsDAO;
    @MockBean
    private SaveSkillDAO saveSkillDAO;

    @BeforeEach
    void setup(){
        skillService = new SkillService(getAllSkillsDAO, saveSkillDAO);
    }

    @Test
    void should_returnFalse_when_skillNameIsLongerThan30Characters(){
        //given
        final String tooLongString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        //when
        final Boolean skillNotTooLong = SkillService.skillNotTooLong(tooLongString);
        //then
        Assertions.assertThat(skillNotTooLong).isFalse();
    }

    @Test
    void should_returnTrue_when_skillNameIsShorterThan30CharactersAndLogerThan2(){
        //given
        final String goodString = "ABCDE";

        //when
        final Boolean assertedString = SkillService.skillNotTooLong(goodString);
        //then
        Assertions.assertThat(assertedString).isTrue();
    }

    @Test
    void should_returnFalse_when_skillNameIsShorterThanTwoCharacters(){
        //given
        final String tooShortString = "A";

        //when
        final Boolean assertedTooShortString = SkillService.skillNotTooLong(tooShortString);
        //then
        Assertions.assertThat(assertedTooShortString).isFalse();
    }

    @Test
    void should_returnTrue_when_getSkillAlreadyExistsFoundsSkillName(){
        //given
        final List<Skill> allSkills = new ArrayList<>();
        final String skillNameOne = "AAA";
        final String skillNameTwo = "BBB";

        allSkills.add(Skill
                .builder()
                .id(1L)
                .skillName(skillNameOne)
                .build());
        allSkills.add(Skill
                .builder()
                .id(2L)
                .skillName(skillNameTwo)
                .build());

        final Skill newSkill = Skill
                .builder()
                .id(133L)
                .skillName(skillNameOne)
                .build();
        //when
        final Boolean isSkill = SkillService.getSkillAlreadyExists(newSkill, allSkills);
        //then
        Assertions.assertThat(isSkill).isTrue();
    }

    @Test
    void should_returnFalse_when_getSkillAlreadyExistsDoesNotFindSkillName(){
        //given
        final List<Skill> allSkills = new ArrayList<>();
        final String skillNameOne = "AAA";
        final String skillNameTwo = "BBB";
        final String skillNameThree = "CCC";

        allSkills.add(Skill
                .builder()
                .id(1L)
                .skillName(skillNameOne)
                .build());
        allSkills.add(Skill
                .builder()
                .id(2L)
                .skillName(skillNameTwo)
                .build());

        final Skill newSkill = Skill
                .builder()
                .id(133L)
                .skillName(skillNameThree)
                .build();
        //when
        final Boolean isNewSkill = SkillService.getSkillAlreadyExists(newSkill, allSkills);
        //then
        Assertions.assertThat(isNewSkill).isFalse();
    }
}