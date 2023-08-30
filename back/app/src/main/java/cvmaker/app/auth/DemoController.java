package cvmaker.app.auth;

import cvmaker.app.multilanguage.MyLocaleResolver;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@CrossOrigin
public class DemoController {

    private MessageSource messageSource;

    private MyLocaleResolver myLocaleResolver;

    @PostMapping(value = "demo")
    public String welcome(final HttpServletRequest request){
        return messageSource.getMessage("demo",
                null, myLocaleResolver.resolveLocale(request));
    }
}
