package cvmaker.app.multilanguage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static cvmaker.app.multilanguage.LanguageConfig.LOCALES;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_getOkay_when_greetingUrlIsProvided() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void should_getAStringValue_when_greetingUrlIsProvided() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
    }

    @Test
    void should_getEnglishText_when_languageIsNotSpecified() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("hello"));
    }

    @Test
    void should_getEnglishText_when_languageSpecifiedIsEnglish() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                        .locale(LOCALES.get(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("hello"));
    }

    @Test
    void should_getSpanishText_when_languageSpecifiedIsSpanish() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                        .locale(LOCALES.get(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("hello"));
    }

    @Test
    void should_getGermanText_when_languageSpecifiedIsGerman() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/greeting")
                        .locale(LOCALES.get(0))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("hello"));
    }

}