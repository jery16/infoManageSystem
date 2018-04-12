package com.spring.example.login.web;

import com.spring.example.login.dao.UserAccountRepository;
import com.spring.example.login.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/userAccount")
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
    public String registerAccountPage(@PathVariable("pageName") String subPath)
    {
        return subPath;
    }

    @RequestMapping(value = "login", params = "register", method = RequestMethod.POST)
    public String addNewUser(UserAccount newUser)
    {
        List<UserAccount> allUsers = userAccountRepository.findAll();
        for (UserAccount user:allUsers)
        {
            if(user.getName().equals(newUser.getName()))
            {
                return "redirect:/userAccount/regFailed";
            }
        }
        userAccountRepository.save(newUser);
        return "redirect:/userAccount/regSuccess";
    }

    @RequestMapping(value="login", params = "login", method = RequestMethod.POST)
    public String login(UserAccount loginUser)
    {
        List<UserAccount> allUsers = userAccountRepository.findAll();
        for (UserAccount user:allUsers)
        {
            if(user.getName().equals(loginUser.getName())&&user.getPassword().equals(loginUser.getPassword()))
            {
                return "redirect:/userAccount/welcome";
            }
        }
        return "redirect:/userAccount/loginFailed";
    }




}
