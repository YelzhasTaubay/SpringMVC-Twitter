package kz.bitlab.project.dao;


import kz.bitlab.project.entities.Followers;
import kz.bitlab.project.entities.Users;

import java.util.List;

public interface FollowersDAO {

    Followers getFollowById(Long id);

    List<Followers> getFollowersByFromUserId(Long from_user_id);

    List<Followers> getFollowersByToUserId(Long to_user_id);

    Followers getFollowersByToUserId2(Long to_user_id);

    void unFollowOfUser(Followers follower);

    void addFollow(Followers follow);

    List<Followers> getAllFollows();



}
