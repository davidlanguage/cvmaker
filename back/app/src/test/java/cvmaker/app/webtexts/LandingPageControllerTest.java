package cvmaker.app.webtexts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static cvmaker.app.multilanguage.LanguageConfig.LOCALES;

@SpringBootTest
@AutoConfigureMockMvc
class LandingPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String URL_TEMPLATE = "/landingpage";

    private static final String TITLE = "/title";

    private static final String FIRST_PARAGRAPH = "/firstparagraph";

    private static final String SECOND_PARAGRAPH = "/secondparagraph";

    /* Title */

    @Test
    void should_getEnglishMessage_when_noLanguageIsSpecifiedForTitle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+TITLE)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Welcome to CV Maker"));
    }

    @Test
    void should_getEnglishMessage_when_englishLanguageIsSpecifiedForTitle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+TITLE)
                        .contentType(MediaType.APPLICATION_JSON)
                        .locale(LOCALES.get(0)))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Welcome to CV Maker"));
    }

    @Test
    void should_getSpanishMessage_when_spanishLanguageIsSpecifiedForTitle() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+TITLE)
                .locale(LOCALES.get(1))
                .header("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Bienvenido a CV Maker"));

    }

    @Test
    void should_getGermanMessage_when_germanLanguageIsSpecifiedForTitle() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+TITLE)
                        .locale(LOCALES.get(2))
                        .header("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Wilkommen bei CV Maker"));

    }

    /* First Paragraph */

    @Test
    void should_getEnglishMessage_when_noLanguageIsSpecifiedForFirstParagraph() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+FIRST_PARAGRAPH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("This is the first paragraph of the landing page"));
    }

    @Test
    void should_getEnglishMessage_when_englishLanguageIsSpecifiedFirstParagraph() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+FIRST_PARAGRAPH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .locale(LOCALES.get(0)))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("This is the first paragraph of the landing page"));
    }

    @Test
    void should_getSpanishMessage_when_spanishLanguageIsSpecifiedFirstParagraph() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+FIRST_PARAGRAPH)
                        .locale(LOCALES.get(1))
                        .header("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Este es el primer párrafo de la landing page"));

    }

    @Test
    void should_getGermanMessage_when_germanLanguageIsSpecifiedForFirstParagraph() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+FIRST_PARAGRAPH)
                        .locale(LOCALES.get(2)))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Das ist der esrte Absatz der Landingpage"));

    }

    /* Second Paragraph */

    @Test
    void should_getEnglishMessage_when_noLanguageIsSpecifiedForSecondParagraph() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+SECOND_PARAGRAPH)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("This is the second paragraph of the landing page"));
    }

    @Test
    void should_getEnglishMessage_when_englishLanguageIsSpecifiedSecondParagraph() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+SECOND_PARAGRAPH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .locale(LOCALES.get(0)))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("This is the second paragraph of the landing page"));
    }

    @Test
    void should_getSpanishMessage_when_spanishLanguageIsSpecifiedSecondParagraph() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+SECOND_PARAGRAPH)
                        .locale(LOCALES.get(1))
                        .header("Content-Type", "application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Este es el segundo párrafo de la landing page"));

    }

    @Test
    void should_getGermanMessage_when_germanLanguageIsSpecifiedForSecondParagraph() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get(URL_TEMPLATE+SECOND_PARAGRAPH)
                        .locale(LOCALES.get(2)))
                .andExpect(MockMvcResultMatchers
                        .content()
                        .string("Das ist der zweite Absatz der Landingpage"));

    }


}