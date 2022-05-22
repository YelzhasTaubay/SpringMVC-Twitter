package kz.bitlab.project.config;

import kz.bitlab.project.dao.*;
import kz.bitlab.project.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Scope("singleton")
public class BeansConfig {

    @Bean
    public UserDAO userDAO(){
        return new UserDAOImpl();
    }

    @Bean
    public RoleDAO roleDAO(){
        return new RoleDAOImpl();
    }

    @Bean
    public BCryptPasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FollowersDAO followersDAO(){
        return new FollowersDAOImpl();
    }

    @Bean
    public CommentsDAO commentsDAO(){
        return new CommentsDAOImpl();
    }

    @Bean
    public TweetsDAO tweetsDAO(){
        return new TweetsDAOImpl();
    }


}
