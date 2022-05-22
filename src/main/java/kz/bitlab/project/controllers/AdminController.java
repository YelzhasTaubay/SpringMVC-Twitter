package kz.bitlab.project.controllers;

import kz.bitlab.project.dao.UserDAO;
import kz.bitlab.project.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mw = new ModelAndView("admin/index");
        mw.addObject("user", getUserData());
        return mw;
    }

    public Users getUserData(){
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User ud = (User)authentication.getPrincipal();
            user = userDAO.getUser(ud.getUsername());
        }
        return user;
    }

}