package brg.bbrg.controller;

import brg.bbrg.model.UserModel;
import brg.bbrg.service.RoleService;
import brg.bbrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/account")
public class AdminAccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public String manageAccount(Model model) {
        List<UserModel> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "account-manage";
    }

    @GetMapping(value = "/add")
    public String addUserForm(Model model) {
        UserModel userModel = new UserModel();
        model.addAttribute("userModel", userModel);
        return "account-addform";
    }

    @GetMapping(value = "/changeUsername")
    public String changeUsername(@RequestParam Long id, Model model) {
        UserModel userModel = userService.getById(id);
        model.addAttribute("userModel", userModel);
        return "account-change-username";
    }
}
