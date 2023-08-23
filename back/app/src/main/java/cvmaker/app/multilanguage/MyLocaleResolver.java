package cvmaker.app.multilanguage;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

@Configuration
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(final HttpServletRequest request) {
        final String language = request.getHeader("Accept-language");
        if (language == null || language.isEmpty()){
            return Locale.forLanguageTag("en");
        }

        final Locale locale = Locale.forLanguageTag(language);

        if (LanguageConfig.LOCALES.contains(locale)){
            return locale;
        }

        return Locale.forLanguageTag("en");
    }

    @Override
    public void setLocale(final HttpServletRequest request, final HttpServletResponse response, final Locale locale) {
        //for now it is not necessary creating this method, but its implementation is required
    }
}
