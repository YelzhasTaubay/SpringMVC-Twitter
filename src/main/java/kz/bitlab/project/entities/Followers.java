package kz.bitlab.project.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="followers")
public class Followers {
   // followers (id, user_id, follower_id)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="from_user_fk")
    private Users from;

    @ManyToOne
    @JoinColumn(name="to_user_fk")
    private Users to;

    public Followers() {
    }
    public Followers(Long id, Users from, Users to) {
        this.id = id;
        this.from = from;
        this.to = to;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getFrom() {
        return from;
    }

    public void setFrom(Users from) {
        this.from = from;
    }

    public Users getTo() {
        return to;
    }

    public void setTo(Users to) {
        this.to = to;
    }
}
