package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
//
//    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
//    private String addUserSubmit(@ModelAttribute UserModel user, Model model){
//        String message = userService.addUser(user);
//        model.addAttribute("message", message);
//        return "redirect:/";
//    }

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, RedirectAttributes attributes) {
        attributes.addFlashAttribute("message", userService.addUser(user));
        return "redirect:/";
    }

    @GetMapping(value = "/change-password")
    private String changePasswordForm(Model model){
        return "change-password";
    }

    @PostMapping(value = "/change-password")
    private String changePasswordSubmit(
            @RequestParam(value = "oldPassword") String oldPassword,
            @RequestParam(value = "newPassword") String newPassword,
            @RequestParam(value = "confirmNewPassword") String confirmNewPassword,
            HttpServletRequest request,
            Model model
    ) {
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.findUser(principal.getName());
        if(!newPassword.equals(confirmNewPassword)){
            model.addAttribute("warning", "Password baru Anda tidak sama!");
            return "change-password";
        }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(oldPassword, user.getPassword())){
            userService.changePassword(user, newPassword);
        }
        else{
            model.addAttribute("warning", "Password lama anda salah!");
            return "change-password";
        }
        model.addAttribute("warning", "Password berhasil diupdate!");
        return "change-password";
    }
}
