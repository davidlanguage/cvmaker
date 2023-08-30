package cvmaker.app.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static cvmaker.app.multilanguage.LanguageConfig.LOCALES;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String URL_TEMPLATE = "/api/v1/demo";

    @Test
    void should_getEnglishMessage_when_demoURLIsProvidedAndNoLanguageIsSpecified() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                        .contentType(MediaType.ALL))
                .andExpect(content().string("Welcome message from secure endpoint"));
    }

    @Test
    void should_getEnglishMessage_when_englishLanguageIsSpecified() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                        .locale(LOCALES.get(0))
                        .contentType(MediaType.ALL))
                .andExpect(content().string("Welcome message from secure endpoint"));
    }

    @Test
    void should_getSpanishMessage_when_spanishLanguageIsSpecified() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                        .locale(LOCALES.get(1))
                        .contentType(MediaType.ALL))
                .andExpect(content().string("Mensaje de bienvenida desde un endpoint seguro"));
    }

    @Test
    void should_getGermanhMessage_when_germanLanguageIsSpecified() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(URL_TEMPLATE)
                        .locale(LOCALES.get(2))
                        .contentType(MediaType.ALL))
                .andExpect(content().string("Willkommensnachricht aus einem gesicherten Endpunkt"));
    }



}