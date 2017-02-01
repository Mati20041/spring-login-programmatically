package pl.mati;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @RequestMapping("/secure")
    public String hi(Authentication authentication) {
        return "hello " + authentication;
    }
}
