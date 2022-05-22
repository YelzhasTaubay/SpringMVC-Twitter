package kz.bitlab.project.services;

import kz.bitlab.project.dao.UserDAO;
import kz.bitlab.project.entities.Roles;
import kz.bitlab.project.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users user = userDAO.getUser(s);
        Set<GrantedAuthority> roles = new HashSet<>();
        for(Roles r : user.getRoles()){
            roles.add(new SimpleGrantedAuthority(r.getRole()));
        }
        return new User(user.getEmail(), user.getPassword(), roles);
    }




}
