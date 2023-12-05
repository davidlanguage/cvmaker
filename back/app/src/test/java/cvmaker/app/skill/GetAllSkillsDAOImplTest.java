package cvmaker.app.skill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllSkillsDAOImplTest {

    @Mock
    private SkillRepository skillRepository;

    @Mock
    private SkillMapper skillMapper;

    private GetAllSkillsDAOImpl getAllSkillsDAO;

    @BeforeEach
    void setUp(){
        getAllSkillsDAO = new GetAllSkillsDAOImpl(skillRepository, skillMapper);
    }

    @Test
    void should_getallEmployees_when_getAllEmployees(){

        final Long firstSkillId = 1448L;

        final Long secondSkillId = 264L;

        final String firstSkillname = "Laziness";

        final String secondSkillname = "Bravery";

        final SkillEntity skillEntityToSave = SkillEntity
                .builder()
                .id(firstSkillId)
                .skillName(firstSkillname)
                .build();

        final SkillEntity skillEntityToSaveTwo = SkillEntity
                .builder()
                .id(secondSkillId)
                .skillName(secondSkillname)
                .build();

        final Skill skillToSave = Skill
                .builder()
                .id(firstSkillId)
                .skillName(firstSkillname)
                .build();

        final Skill skillToSaveTwo = Skill
                .builder()
                .id(secondSkillId)
                .skillName(secondSkillname)
                .build();

        final List<Skill> skills = new ArrayList<>();

        skills.add(skillToSave);
        skills.add(skillToSaveTwo);

        when(skillRepository.findAll()).thenReturn(Arrays.asList(skillEntityToSave, skillEntityToSaveTwo));

        when(skillMapper.map(skillEntityToSave))
                .thenReturn(skillToSave);
        when(skillMapper.map(skillEntityToSaveTwo))
                .thenReturn(skillToSaveTwo);

        final List<Skill> returnedSkills = getAllSkillsDAO.getAllSkills();

        assertEquals(2, returnedSkills.size());
        assertThat(returnedSkills).usingRecursiveComparison().isEqualTo(skills);
    }

    @Test
    void should_getAnEmptyList_when_getAllEmployees(){

        final SkillEntity emptySkillEntity = SkillEntity.builder().build();

        final Skill emptySkill = Skill.builder().build();

        final List<Skill> skills = new ArrayList<>();

        when(skillRepository.findAll()).thenReturn(Collections.singletonList(emptySkillEntity));

        skills.add(emptySkill);

        when(skillMapper.map(emptySkillEntity)).thenReturn(emptySkill);

        final List<Skill> returnedSkills = getAllSkillsDAO.getAllSkills();

        assertEquals(1, returnedSkills.size());
        assertThat(returnedSkills).usingRecursiveComparison().isEqualTo(skills);

    }

    @Test
    void should_beSizeZero_when_getAllEmployeesHasNoValue(){

        final List<Skill> returnedSkills = getAllSkillsDAO.getAllSkills();

        assertEquals(0, returnedSkills.size());

    }

}