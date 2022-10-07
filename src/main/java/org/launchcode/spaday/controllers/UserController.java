package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")      // http://localhost:8080/user/add
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        // add form submission handling code here
        model.addAttribute("user", user);   // unnecessary??
        model.addAttribute("verify", verify);   // unnecessary??
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("password", user.getPassword());     // unnecessary??

        if (user.getPassword().equals(verify)) {
            return "user/index";    // skip everything after this line...
        } else {
            model.addAttribute("error", "Passwords do not match!!");
            return "user/add";  // skip everything after this line...
        }
    }
    // ...until you exit the method.

}
