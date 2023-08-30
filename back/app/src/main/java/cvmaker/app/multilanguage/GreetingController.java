package cvmaker.app.multilanguage;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
@AllArgsConstructor
@CrossOrigin
public class GreetingController {

    private MessageSource messageSource;

    private MyLocaleResolver myLocaleResolver;


    @GetMapping
    public String greeting(final HttpServletRequest request){
        return messageSource.getMessage("greeting",
                null, myLocaleResolver.resolveLocale(request));
    }
}
