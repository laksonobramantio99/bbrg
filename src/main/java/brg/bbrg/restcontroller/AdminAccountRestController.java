package brg.bbrg.restcontroller;

import brg.bbrg.model.RoleModel;
import brg.bbrg.model.UserModel;
import brg.bbrg.service.RoleService;
import brg.bbrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AdminAccountRestController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/isAvailable/{username}")
    private Map<String, Object> isAvailable(@PathVariable String username){
        UserModel user = userService.getByUsername(username);
        boolean isAvailable = false;
        if (user != null)
            isAvailable = true;

        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("isAvailable", isAvailable);

        return response;
    }

    @PostMapping("/add")
    public Map<String, Object> addAccountSubmit(@ModelAttribute UserModel userModel) {
        RoleModel roleAdmin = roleService.getByName("Admin");
        userModel.setRole(roleAdmin);
        userService.addUser(userModel);

        Map<String, Object> response = new HashMap<>();
        response.put("username", userModel.getUsername());
        response.put("status", "success");
        return response;
    }

    @PostMapping("/changeUsername")
    public Map<String, Object> changeUsernameSubmit(@ModelAttribute UserModel userModel) {
        UserModel currentUserModel = userService.getById(userModel.getId());
        currentUserModel.setUsername(userModel.getUsername());
        userService.changeUsername(currentUserModel);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }
}
