package pl.mati;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @RequestMapping("/login")
    public void login() {
        try {
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("mati", "mati")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/wrong-login")
    public void wrongLogin() {
        try {
            SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("mati", "notmati")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/secure")
    public String hi(Authentication authentication) {
        return "hello " + authentication;
    }
}
