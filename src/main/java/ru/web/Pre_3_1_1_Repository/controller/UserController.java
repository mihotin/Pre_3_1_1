package ru.web.Pre_3_1_1_Repository.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.web.Pre_3_1_1_Repository.model.User;
import ru.web.Pre_3_1_1_Repository.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String printUsers(Model model) {
            model.addAttribute("allusers", userService.getAll());
        return "/index";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "new";
        userService.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getOne(id));
        return "/update";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                             @PathVariable("id") Long id) {
        if (bindingResult.hasErrors())
            return "update";
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }

}
