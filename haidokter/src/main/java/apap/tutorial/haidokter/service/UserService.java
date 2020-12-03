package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;

public interface UserService {
    String addUser(UserModel user);
    public String encrypt(String password);
    String changePassword(UserModel user, String password);
    UserModel findUser(String user);
    boolean validatePassword(String pass);
}
