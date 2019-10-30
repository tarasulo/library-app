package library.app.spring.controller;

import javax.validation.Valid;

import library.app.spring.dto.DtoUtil;
import library.app.spring.dto.UserDto;
import library.app.spring.entity.User;
import library.app.spring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;
    private final DtoUtil dtoUtil;

    public RegistrationController(UserService userService, DtoUtil dtoUtil) {
        this.userService = userService;
        this.dtoUtil = dtoUtil;
    }

    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute @Valid UserDto userDto,
                               BindingResult result, Model model) {
        User newUser = dtoUtil.parse(userDto);
        if (result.hasErrors()) {
            model.addAttribute("message", "User creating error");
            return "errorPage";
        }

        userService.add(newUser);
        return "login";
    }
}
