package kz.bitlab.project.controllers;

import kz.bitlab.project.dao.FollowersDAO;
import kz.bitlab.project.dao.RoleDAO;
import kz.bitlab.project.dao.UserDAO;
import kz.bitlab.project.entities.Followers;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.jar.Attributes;

@Controller
public class UserController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    FollowersDAO followersDAO;


    public Users getUserData(){
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            User ud = (User)authentication.getPrincipal();
            user = userDAO.getUser(ud.getUsername());
        }
        return user;
    }


    @RequestMapping(value = "/users/search",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mw=new ModelAndView("users/search");
        mw.addObject("user",getUserData());
        List<Users> allUsers1= userDAO.getAllUsers();

        List<Followers> allFollows=followersDAO.getAllFollows();
        List<Users> allUsers=new ArrayList<>();
        for (int i=0;i< allUsers1.size();i++){
            if (getUserData().getId()!=allUsers1.get(i).getId()){
                allUsers.add(allUsers1.get(i));
            }
        }

        ArrayList<Users> alreadyFollowed=new ArrayList<>();
        ArrayList<Users> notFollowed=new ArrayList<>();
        for (int i = 0; i <allUsers.size(); i++) {
            for (int j = 0; j < allFollows.size(); j++) {
                    if (allUsers.get(i).getId()==allFollows.get(j).getTo().getId() && getUserData().getId()==allFollows.get(j).getFrom().getId()){
                        alreadyFollowed.add(allUsers.get(i));
                    }
            }
        }

        for (int i = 0; i <allUsers.size(); i++) {
            for (int j = 0; j < alreadyFollowed.size(); j++) {
                //if (allUsers.get(i).getId()!=alreadyFollowed.get(j).getId())
                    notFollowed.add(allUsers.get(i));
            }
        }

        Set<Users> usersSet=new HashSet<>(notFollowed);
        notFollowed.clear();
        notFollowed.addAll(usersSet);

        for (int i = 0; i < notFollowed.size(); i++) {
            System.out.println(notFollowed.get(i).getEmail()+"    ----");
        }

        mw.addObject("alreadyFollowed",alreadyFollowed);
        mw.addObject("notFollowed",notFollowed);
        mw.addObject("user",getUserData());
        return mw;
    }


    @RequestMapping(value = "/users/follow/{id}",method = RequestMethod.GET)
    public ModelAndView index5(@PathVariable(name = "id")Long id){
        ModelAndView mw=new ModelAndView("users/profile");
        Users user=userDAO.getUserById(id);




        return mw;
    }


    @RequestMapping(value = "/users/searching",method = RequestMethod.POST)
    public ModelAndView index1(@RequestParam(name = "name")String fullname){
        ModelAndView mw=new ModelAndView("users/search");
        mw.addObject("user",getUserData());
        List<Users> allUsers= userDAO.getUserByFullName(fullname);

        for (Users u : allUsers) {
            System.out.println("FullName: " + allUsers);
        }
        mw.addObject("allUsers",allUsers);
        return mw;
    }

    @RequestMapping(value = "/users/profile/{id}",method = RequestMethod.GET)
    public ModelAndView index3(@PathVariable(name = "id")Long id){
        Users user=userDAO.getUserById(id);
        ModelAndView mw=new ModelAndView("users/profile");

        List<Followers> follows= followersDAO.getFollowersByFromUserId(id);
        List<Followers> followers=followersDAO.getFollowersByToUserId(id);
        List<Users> follows1=new ArrayList<>();
        List<Users> followers1=new ArrayList<>();
        List<Long> idOfFollows=new ArrayList<>();

        for (int i=0;i<follows.size();i++){
            follows1.add(follows.get(i).getTo());
            idOfFollows.add(follows.get(i).getId());
        }
        for (int i=0;i<followers.size();i++){
            followers1.add(followers.get(i).getFrom());
        }

        mw.addObject("user",user);
        mw.addObject("allUsers",follows1);
        mw.addObject("idOfFollows",idOfFollows);
        mw.addObject("allUsersFrom",followers1);
        return mw;
    }

    @RequestMapping(value = "/users/delete/{id}",method = RequestMethod.GET)
    public ModelAndView index4(@PathVariable(name = "id")Long id){
        ModelAndView mw=new ModelAndView("users/search");


            Followers follower = followersDAO.getFollowById(id);
            followersDAO.unFollowOfUser(follower);

        mw.addObject("user",getUserData());
        List<Users> allUsers=userDAO.getAllUsers();
        mw.addObject("allUsers",allUsers);

        return mw;
    }







}
