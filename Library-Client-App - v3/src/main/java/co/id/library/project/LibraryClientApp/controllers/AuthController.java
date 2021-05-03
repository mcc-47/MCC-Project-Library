package co.id.library.project.LibraryClientApp.controllers;

import co.id.library.project.LibraryClientApp.models.AuthRequest;
import co.id.library.project.LibraryClientApp.services.AuthService;
import co.id.library.project.LibraryClientApp.services.TraineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    TraineeService traineeService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        Authentication authent = SecurityContextHolder.getContext().getAuthentication();
        if (!(authent instanceof AnonymousAuthenticationToken)) {
            /* The user is logged in :) */
            return "redirect:/dashboard";
        }

        AuthRequest auth = new AuthRequest();
        model.addAttribute("auth", auth);
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute AuthRequest auth) {
        String redirectURL = "";

        if (authService.loginProcess(auth)) {
            redirectURL = "redirect:/dashboard";
        } else {
            redirectURL = "redirect:/login?error";
        }
        return redirectURL;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("trainee", traineeService.getAll());
        return "/dashboard";
    }
}
