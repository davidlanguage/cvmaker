package cvmaker.app.multilanguage;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Configuration
public class MyLocaleResolver implements LocaleResolver {

    private static final String DEFAULT_LANGUAGE = "en";

    @Override
    public Locale resolveLocale(final HttpServletRequest request) {

        final String language = fixLanguageRequestValue(request.getHeader("Accept-language"));

        if (language == null || language.isEmpty()){
            return Locale.forLanguageTag(DEFAULT_LANGUAGE);
        }

        final Locale locale = Locale.forLanguageTag(language);

        if (LanguageConfig.LOCALES.contains(locale)){
            return locale;
        }

        return Locale.forLanguageTag(DEFAULT_LANGUAGE);
    }

    @Override
    public void setLocale(final HttpServletRequest request, final HttpServletResponse response, final Locale locale) {
        //for now it is not necessary creating this method, but its implementation is required
    }

    private String fixLanguageRequestValue(final String language){

        if (language == null){
            return null;
        }

        return !language.isEmpty()?language.trim().toUpperCase():language;
    }

}
