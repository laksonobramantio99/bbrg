package brg.bbrg.service;

import brg.bbrg.model.RoleModel;
import brg.bbrg.model.UserModel;
import brg.bbrg.repository.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDB userDB;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDB.save(user);
    }

    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getAllUser() {
        return userDB.findAll();
    }

    @Override
    public UserModel getByUsername(String username) {
        Optional<UserModel> userModel = userDB.findByUsername(username);
        if (userModel.isPresent())
            return userModel.get();
        else
            return null;
    }

    @Override
    public UserModel getById(Long id) {
        Optional<UserModel> userModel = userDB.findById(id);
        if (userModel.isPresent())
            return userModel.get();
        else
            return null;
    }

    @Override
    public UserModel changeUsername(UserModel newUserModel) {
        return userDB.save(newUserModel);
    }

    @Override
    public boolean validatePassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if (passwordEncoder.matches(rawPassword, encodedPassword)) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void deleteUser(UserModel userModel) {
        userDB.delete(userModel);
    }

    @Override
    public UserModel getCurrentUser() {
        String currentUsername = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUsername = authentication.getName();
        }
        return getByUsername(currentUsername);
    }
}
