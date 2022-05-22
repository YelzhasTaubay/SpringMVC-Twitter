package kz.bitlab.project.controllers;

import kz.bitlab.project.dao.CommentsDAO;
import kz.bitlab.project.dao.RoleDAO;
import kz.bitlab.project.dao.TweetsDAO;
import kz.bitlab.project.dao.UserDAO;
import kz.bitlab.project.entities.Comments;
import kz.bitlab.project.entities.Tweets;
import kz.bitlab.project.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    CommentsDAO commentsDAO;

    @Autowired
    TweetsDAO tweetsDAO;


    public Users getUserData(){
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User ud = (User)authentication.getPrincipal();
            user = userDAO.getUser(ud.getUsername());
        }
        return user;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mw = new ModelAndView("index");

        List<Tweets> allTweets= tweetsDAO.getAllTweets();
        List<Comments> allComments= commentsDAO.getAllComments();

//        boolean userOnline;
//        if (getUserData()!=null){
//            userOnline=true;
//        }else {
//            userOnline=false;
//        }
//
//        mw.addObject("userOnline",userOnline);

        mw.addObject("allTweets",allTweets);
        mw.addObject("allComments",allComments);
        return mw;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView mw = new ModelAndView("login");
        return mw;
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView mw=new ModelAndView("profile/registration");
        return  mw;
    }





}
