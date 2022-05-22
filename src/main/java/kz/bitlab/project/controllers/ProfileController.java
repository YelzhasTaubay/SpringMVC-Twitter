package kz.bitlab.project.controllers;

import kz.bitlab.project.dao.CommentsDAO;
import kz.bitlab.project.dao.RoleDAO;
import kz.bitlab.project.dao.TweetsDAO;
import kz.bitlab.project.dao.UserDAO;
import kz.bitlab.project.entities.Comments;
import kz.bitlab.project.entities.Roles;
import kz.bitlab.project.entities.Tweets;
import kz.bitlab.project.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
//@RequestMapping(value = "/profile")
public class ProfileController {

    @Autowired
    UserDAO userDAO;

    @Autowired
    RoleDAO roleDAO;

    @Autowired
    TweetsDAO tweetsDAO;

    @Autowired
    CommentsDAO commentsDAO;

    @RequestMapping(value = "/profile/index", method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView mw = new ModelAndView("profile/index");
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


    @RequestMapping(value = "/profile/registration1",method = RequestMethod.POST)
    public String registration(@RequestParam(name = "user_email") String email,
                               @RequestParam(name = "user_password")String password,
                               @RequestParam(name = "full_name") String fullname,
                               @RequestParam(name = "gender")String gender,
                               @RequestParam(name = "country")String country,
                               @RequestParam(name = "city")String city,
                               @RequestParam(name = "role") String role1){

        Roles role=roleDAO.getRole(role1);
        System.out.println("Роль получили по requestparam role :"+role1+"    с RoleDAO getRole: "+role.getId()+" "+role.getRole());
        Set<Roles> rolesSet=new HashSet<>();
        rolesSet.add(role);
        userDAO.addUser(new Users(email,password,fullname,gender,country,city,rolesSet));

        return "redirect:/";
    }

    @RequestMapping(value = "/profile/delete",method = RequestMethod.POST)
    public String deleteUser(@RequestParam(name = "email")String email){
        System.out.println("deleting");
        Users user=userDAO.getUser(email);
        userDAO.deleteUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/profile/update",method = RequestMethod.GET)
    public ModelAndView update(){
        ModelAndView mw=new ModelAndView("profile/update");
        mw.addObject("user",getUserData());

        List<Roles> allRoles=roleDAO.getAllRoles();
        mw.addObject("allRoles",allRoles);
        return mw;
    }

    @RequestMapping(value = "profile/updating",method = RequestMethod.POST)
    public String update(@RequestParam(name = "user_email")String email,
                         @RequestParam(name = "user_password")String password,
                         @RequestParam(name = "full_name")String fullname,
                         @RequestParam(name = "gender")String gender,
                         @RequestParam(name = "country")String country,
                         @RequestParam(name = "city")String city,
                         @RequestParam(name = "role")List<String> roleList){

        Set<Roles> rolesSet=new HashSet<>();
        for (int i=0;i<roleList.size();i++){
            Roles role=roleDAO.getRole(roleList.get(i));
            rolesSet.add(role);
        }

        Users user=userDAO.getUser(email);
        user.setEmail(email);
        user.setPassword(password);
        user.setFullname(fullname);
        user.setGender(gender);
        user.setCountry(country);
        user.setCity(city);
        user.setRoles(rolesSet);

        userDAO.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/profile/addtwit",method = RequestMethod.GET)
    public ModelAndView addtwit(){
        ModelAndView mw=new ModelAndView("profile/addtwit");
        return mw;
    }

    @RequestMapping(value = "/profile/addtwitting",method = RequestMethod.POST)
    public ModelAndView qwerty(@RequestParam(name = "title")String title,
                               @RequestParam(name = "short_content")String short_content,
                               @RequestParam(name = "content")String content){
        ModelAndView mw=new ModelAndView("/index");

        tweetsDAO.addTweet(new Tweets(null,content,new Date(),short_content,title,getUserData()));
        List<Tweets> allTweets= tweetsDAO.getAllTweets();
        List<Comments> allComments= commentsDAO.getAllComments();

        mw.addObject("allTweets",allTweets);
        mw.addObject("allComments",allComments);
        return  mw;
    }


    @RequestMapping(value = "/readmore/{id}",method = RequestMethod.GET)
    public ModelAndView readmore(@PathVariable(name = "id")Long id){
        ModelAndView mw=new ModelAndView("readmore/index");

        Tweets tweet=tweetsDAO.getTweetById(id);
        List<Comments> allComments= commentsDAO.getAllComments();

        List<Comments> thisComments=new ArrayList<>();
        for (int i = 0; i < allComments.size(); i++) {
            if (allComments.get(i).getTweet().getId()==tweet.getId()){
                thisComments.add(allComments.get(i));
            }
        }

//        boolean online=false;
//        if (getUserData().getId()==tweet.getAuthor().getId() || getUserData().getId()!=tweet.getAuthor().getId()){
//            online=true;
//        }else {
//            online=false;
//        }

        //mw.addObject("online",online);
        mw.addObject("thisComments",thisComments);
        mw.addObject("tweet",tweet);
        return  mw;
    }

    @RequestMapping(value = "/profile/comment",method = RequestMethod.POST)
    public ModelAndView addcom(@RequestParam(name = "area")String area,
                               @RequestParam(name = "tweet_id")Tweets id){

        ModelAndView mw=new ModelAndView("/index");
        Users user=getUserData();

        System.out.println(area+"    +++"+new Date()+"    ++"+getUserData().getId()+"      ++"+id.getAuthor());


        commentsDAO.addComment(new Comments(null,area,new Date(),getUserData(),id));


        return  mw;
    }









}

