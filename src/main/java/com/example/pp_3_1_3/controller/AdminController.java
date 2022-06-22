package com.example.pp_3_1_3.controller;

import com.example.pp_3_1_3.model.Role;
import com.example.pp_3_1_3.model.User;
import com.example.pp_3_1_3.service.RoleService;
import com.example.pp_3_1_3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleService roleService;


    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @GetMapping
    public String show(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("userMain", user);
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("newUser", new User());
        return "users";
    }

//    @GetMapping("/admin")
//    public String newUser(@ModelAttribute("user") User user, Model model) {
//        model.addAttribute("allRoles", roleService.getAllRoles());
//        return "users";
//    }

    @PostMapping
    public String create(@ModelAttribute("newUser") User user, @RequestParam(value = "role") String[] roles) {
        user.setRoles(getRoles(roles));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
    model.addAttribute("user", userService.getUserById(id));
    return "redirect:/admin";
    }

    @PatchMapping("/edit")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "role") String[] roles) {
        user.setRoles(getRoles(roles));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
    public Set<Role> getRoles(String[] roles) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : roles) {
            roleSet.add(roleService.findByName(role));
        }
        return roleSet;
    }
}
