package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDb userDB;

//    @Override
//    public UserModel addUser(UserModel user) {
//        String pass = encrypt(user.getPassword());
//        user.setPassword(pass);
//        return userDB.save(user);
//    }

    @Override
    public String changePassword(UserModel user, String password) {
        if(validatePassword(password)){
            String pass = encrypt(password);
            user.setPassword(pass);
            userDB.save(user);
            return "password berhasil diubah";
        }
        return "password tidak sesuai dengan ketentuan";
    }

    @Override
    public boolean validatePassword(String pass){
        boolean numberFound = false;
        boolean alphabetFound = false;
        if (pass.length() >= 8){
            for (char c : pass.toCharArray()) {
                if(Character.isDigit(c)){
                    numberFound = true;
                }
                if(Character.isAlphabetic(c)){
                    alphabetFound = true;
                }
            }
            if(numberFound && alphabetFound){
                return true;
            }
        }
        return false;
    }

    @Override
    public String addUser(UserModel user) {
        String pass = user.getPassword();
        boolean numberFound = false;
        boolean alphabetFound = false;
        if (pass.length() >= 8){
            for (char c : pass.toCharArray()) {
                if(Character.isDigit(c)){
                    numberFound = true;
                }
                if(Character.isAlphabetic(c)){
                    alphabetFound = true;
                }
            }
            if(numberFound && alphabetFound){
                String password = encrypt(user.getPassword());
                user.setPassword(password);
                userDB.save(user);
                return "User berhasil ditambahkan";
            }
        }
        return "Password tidak sesuai ketentuan";
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

//    @Override
//    public void changePassword(UserModel user, String password) {
//        String pass = encrypt(password);
//        user.setPassword(pass);
//        userDB.save(user);
//    }

    @Override
    public UserModel findUser(String user) {
        return userDB.findByUsername(user);
    }
}
