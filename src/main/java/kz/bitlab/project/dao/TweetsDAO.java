package kz.bitlab.project.dao;


import kz.bitlab.project.entities.Tweets;

import java.util.List;

public interface TweetsDAO {

    List<Tweets> getAllTweets();

    Tweets getTweetById(Long id);

    void addTweet(Tweets tweet);

}
