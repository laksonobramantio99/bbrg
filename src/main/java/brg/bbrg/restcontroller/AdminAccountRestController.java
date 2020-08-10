package brg.bbrg.restcontroller;

import brg.bbrg.model.RoleModel;
import brg.bbrg.model.UserModel;
import brg.bbrg.service.RoleService;
import brg.bbrg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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
    public Map<String, Object> isAvailable(@PathVariable String username){
        UserModel user = userService.getByUsername(username);
        boolean isAvailable = false;
        if (user != null)
            isAvailable = true;

        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("isAvailable", isAvailable);

        return response;
    }

    @GetMapping(value = "/validatePassword")
    public Map<String, Object> validatePassword(@RequestParam Long id, @RequestParam String pw) {
        UserModel user = userService.getById(id);
        boolean matches = userService.validatePassword(pw, user.getPassword());

        HashMap<String, Object> response =  new HashMap<>();
        response.put("isMatches", matches);

        return response;
    }

    @GetMapping(value = "/getUserLoggedIn")
    public Map<String, Object> getUserLoggedIn() {
        UserModel currentUser =  userService.getCurrentUser();

        HashMap<String, Object> response =  new HashMap<>();
        response.put("idUser", currentUser.getId());
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

    @PostMapping("/changePassword")
    public Map<String, Object> changePasswordSubmit(@ModelAttribute UserModel userModel) {
        UserModel currentUserModel = userService.getById(userModel.getId());
        currentUserModel.setPassword(userModel.getPassword());
        userService.addUser(currentUserModel);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }

    @PostMapping("/deleteUser/{id}")
    public Map<String, Object> deleteUser(@PathVariable Long id) {
        UserModel userModel = userService.getById(id);
        userService.deleteUser(userModel);

        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }
}
