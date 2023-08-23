package cvmaker.app.multilanguage;

import org.springframework.cglib.core.Local;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LanguageConfig {
    public static final List<Locale> LOCALES = Arrays.asList(
            new Locale("en"),
            new Locale("de"),
            new Locale("es")
    );
}
