package brg.bbrg.service;

import brg.bbrg.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    List<UserModel> getAllUser();
}
