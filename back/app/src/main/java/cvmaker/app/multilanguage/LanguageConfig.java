package cvmaker.app.multilanguage;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LanguageConfig {

    private LanguageConfig(){
        throw new IllegalStateException("Utility class");
    }

    /***
     * 0 = English;
     * 1 = Spanish;
     * 2 = German;
     */
    public static final List<Locale> LOCALES = Arrays.asList(
            new Locale(Languages.ENGLISH.getLanguage()),
            new Locale(Languages.SPANISH.getLanguage()),
            new Locale(Languages.GERMAN.getLanguage())
    );
}
