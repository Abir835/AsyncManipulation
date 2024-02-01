package com.example.ASYNDM.ASYNDM.controller.Auth;

import com.example.ASYNDM.ASYNDM.dto.UserRegistrationDto;
import com.example.ASYNDM.ASYNDM.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Builder
@AllArgsConstructor
@Controller
public class AuthController {

    private final UserService userService;

    @GetMapping("login")
    public ModelAndView loadLoginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("auth/login");
        return modelAndView;
    }
    @GetMapping("/registration")
    public String registration() {
        return "auth/registration";
    }
    @GetMapping("/users")
    public String users() {
        return "auth/user";
    }

    @PostMapping("user/register")
    public ModelAndView registerUser(HttpServletRequest request) {

        UserRegistrationDto userRegistrationDto = new UserRegistrationDto();
        userRegistrationDto.setName(request.getParameter("name"));
        userRegistrationDto.setEmail(request.getParameter("email"));
        userRegistrationDto.setContact(request.getParameter("contact"));
        userRegistrationDto.setPassword(request.getParameter("pwd"));

        String result = userService.userRegistration(userRegistrationDto);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("message", result);
        return modelAndView;
    }

    @PostMapping("/loginCheck")
    public ModelAndView validateUser(HttpServletRequest request) {
        String result = userService.validateUser(request.getParameter("email"), request.getParameter("pwd"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("result");
        modelAndView.addObject("message", result);
        return modelAndView;
    }
}
