package cvmaker.app.multilanguage;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
@AllArgsConstructor
public class HomePageTextProviderController {


    private MessageSource messageSource;

    private MyLocaleResolver myLocaleResolver;


    @GetMapping
    public String button(final HttpServletRequest request){
        //TODO implement
        return "";
    }
}
