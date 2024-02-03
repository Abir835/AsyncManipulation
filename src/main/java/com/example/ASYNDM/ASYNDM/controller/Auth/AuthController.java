package com.example.ASYNDM.ASYNDM.controller.Auth;

import com.example.ASYNDM.ASYNDM.dto.UserListDto;
import com.example.ASYNDM.ASYNDM.dto.UserRegistrationDto;
import com.example.ASYNDM.ASYNDM.entity.User;
import com.example.ASYNDM.ASYNDM.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Builder
@AllArgsConstructor
@Controller
public class AuthController {

    private final UserService userService;


    @GetMapping("/signin")
    public String  login(){
        return "auth/login";
    }
    @GetMapping("/registration")
    public String registration() {
        return "auth/registration";
    }

    @GetMapping("/users")
    public String users(Model model, Principal principal) {
        List<UserListDto> users = userService.findAll();
        model.addAttribute("users", users);
        boolean loggedIn = (principal != null);
        model.addAttribute("loggedIn", loggedIn);
        return "auth/user";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user, HttpSession session){
        boolean emailCheck = userService.checkedEmail(user.getEmail());
        if(emailCheck){
            session.setAttribute("registrationMessage", "Email already exists. Please choose a different email.");
            return "redirect:/registration";
        }
        else{
            User userDetails =  userService.createUser(user);
            if(userDetails != null){
                session.setAttribute("registrationMessage", "Registration successful. You can now sign in.");
            }
            else{
                session.setAttribute("registrationMessage", "Registration failed. Please try again.");
            }
        }

        return "redirect:/signin";
    }


}
