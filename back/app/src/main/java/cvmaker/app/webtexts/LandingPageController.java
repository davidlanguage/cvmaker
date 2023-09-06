package cvmaker.app.webtexts;

import cvmaker.app.multilanguage.MyLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/landingpage")
@AllArgsConstructor
@CrossOrigin
public class LandingPageController {

    private MessageSource messageSource;

    private MyLocaleResolver myLocaleResolver;

    @GetMapping("/title")
    public String landingPageTitle(final HttpServletRequest request){
        return messageSource.getMessage("landingPageTitle",
                null, myLocaleResolver.resolveLocale(request));
    }

    @GetMapping("/firstparagraph")
    public String firstParagraph(final HttpServletRequest request){
        return messageSource.getMessage("firstParagraph",
                null, myLocaleResolver.resolveLocale(request));
    }

    @GetMapping("/secondparagraph")
    public String secondParagraph(final HttpServletRequest request){
        return messageSource.getMessage("secondParagraph",
                null, myLocaleResolver.resolveLocale(request));
    }
}
