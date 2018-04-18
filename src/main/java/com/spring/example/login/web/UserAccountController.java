package com.spring.example.login.web;

import com.spring.example.login.dao.BookInfoRepository;
import com.spring.example.login.dao.UserAccountRepository;
import com.spring.example.login.domain.BookInformation;
import com.spring.example.login.domain.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserAccountController {
    public static final String BOOKS_INFO = "booksInfo";
    @Autowired
    private UserAccountRepository userAccountRepository;
    @Autowired
    private BookInfoRepository bookInfoRepository;

    private UserAccount loginUser = null;

    @RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
    public String registerAccountPage(@PathVariable("pageName") String subPath,Model model)
    {
        if (subPath.equals(BOOKS_INFO))
        {
            model.addAttribute("allBooks", bookInfoRepository.findAllBooksByOwner(loginUser.getName()));
            model.addAttribute("newBook", new BookInformation());
        }
        return subPath;
    }

    @RequestMapping(value = "/booksInfo", method = RequestMethod.POST)
    public String addBook(@ModelAttribute BookInformation newBook)
    {
        newBook.setOwner(loginUser.getName());
        bookInfoRepository.save(newBook);
        return "redirect:/"+BOOKS_INFO;
    }

    @RequestMapping(value = "login", params = "register", method = RequestMethod.POST)
    public String addNewUser(UserAccount newUser)
    {
        List<UserAccount> allUsers = userAccountRepository.findAll();
        for (UserAccount user:allUsers)
        {
            if(user.getName().equals(newUser.getName()))
            {
                return "redirect:/regFailed";
            }
        }
        userAccountRepository.save(newUser);
        return "redirect:/login";
    }

    @RequestMapping(value="login", params = "login", method = RequestMethod.POST)
    public String login(UserAccount loginUser)
    {
        List<UserAccount> allUsers = userAccountRepository.findAll();
        for (UserAccount user:allUsers)
        {
            if(user.getName().equals(loginUser.getName())&&user.getPassword().equals(loginUser.getPassword()))
            {
                this.loginUser = loginUser;
                return "redirect:/"+BOOKS_INFO;
            }
        }
        return "redirect:/loginFailed";
    }




}
