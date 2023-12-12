package cvmaker.app.skill;

import cvmaker.app.logger.LoggerService;
import cvmaker.app.utils.MyJsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SkillControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SkillService skillService;

    @MockBean
    private LoggerService loggerService;

    private static final String URL_BASE_TEMPLATE = "/skill";

    private static final String URL_ALL_TEMPLATE = "/all";

    private static final String URL_CREATE_TEMPLATE = "/create";

    @Test
    void should_getListOfSkills_when_getAllSkillsIsCalled() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get(URL_BASE_TEMPLATE+URL_ALL_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void should_createASkill_when_createIsCalled() throws Exception {

        final Skill skill = Skill
                .builder()
                .id(99L)
                .skillName("Test")
                .build();

        when(skillService.getAllSkills()).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders.post(URL_BASE_TEMPLATE+URL_CREATE_TEMPLATE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(MyJsonUtils.asJsonString(skill)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Skill "+ skill.getSkillName()+" successfully created."));
    }



}