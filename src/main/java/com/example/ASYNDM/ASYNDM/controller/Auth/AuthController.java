package com.example.ASYNDM.ASYNDM.controller.Auth;

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
import org.springframework.web.servlet.ModelAndView;

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
    public String users(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "auth/user";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user){
        boolean emailCheck = userService.checkedEmail(user.getEmail());
        if(emailCheck){
            System.out.println("Email Already Exits");
            return "redirect:/registration";
        }
        else{
            User userDetails =  userService.createUser(user);
            if(userDetails != null){
                System.out.println("Register Successfully");
            }
            else{
                System.out.println("Something error in server");
            }
        }

        return "redirect:/signin";
    }


}
