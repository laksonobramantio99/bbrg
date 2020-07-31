package brg.bbrg.controller;

import brg.bbrg.model.UserModel;
import brg.bbrg.service.RoleService;
import brg.bbrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/account")
public class AdminAccountController {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping(value = "/add")
    public String addUserForm(Model model) {
        UserModel userModel = new UserModel();
        model.addAttribute("userModel", userModel);
        return "account-addform";
    }

    @PostMapping(value = "/add")
    public String addUserSubmit(@ModelAttribute UserModel userModel) {
        userModel.setRole(roleService.getById(1));
        userService.addUser(userModel);
        return "redirect:/";
    }
}
