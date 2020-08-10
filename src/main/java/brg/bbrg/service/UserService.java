package brg.bbrg.service;

import brg.bbrg.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserModel addUser(UserModel user);
    List<UserModel> getAllUser();
    UserModel getByUsername(String username);
    UserModel getById(Long id);
    UserModel changeUsername(UserModel newUserModel);
    boolean validatePassword(String rawPassword, String encodedPassword);
    void deleteUser(UserModel userModel);
    UserModel getCurrentUser();
}
