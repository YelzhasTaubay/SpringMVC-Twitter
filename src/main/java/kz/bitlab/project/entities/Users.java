package kz.bitlab.project.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String fullname;

    private String gender;

    private String country;

    private String city;

//    @ManyToMany
//    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<Roles> rolesSet;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Roles> roles;

    //Here is to make changes

    @OneToMany(mappedBy="to")
    private List<Followers> followers;

    @OneToMany(mappedBy="from")
    private List<Followers> following;

    public Users() {
    }
    public Users( String email, String password, String fullname, String gender, String country, String city,Set<Roles> roles) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.gender = gender;
        this.country = country;
        this.city = city;
        this.roles=roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
