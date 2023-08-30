package cvmaker.app.multilanguage;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LanguageConfig {

    private LanguageConfig(){
        throw new IllegalStateException("Utility class");
    }
    public static final List<Locale> LOCALES = Arrays.asList(
            new Locale(Languages.ENGLISH.getLanguage()),
            new Locale(Languages.SPANISH.getLanguage()),
            new Locale(Languages.GERMAN.getLanguage())
    );
}
