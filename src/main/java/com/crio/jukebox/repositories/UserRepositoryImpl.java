package com.crio.jukebox.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.crio.jukebox.entities.User;

public class UserRepositoryImpl  implements UserRepository{


    private final Map<String,User> users;
    private long  autoIncrement =0;
    public UserRepositoryImpl(){
         this.users = new HashMap<>();
         this.autoIncrement = users.size();
    }


    @Override
    public User createUser(User user) {   
          
        if(user.getId() == null){
              User user2 = new User( String.valueOf(count()), user.getName());
              user = user2; 
        }
        users.put(user.getId(), user);
         return user;
    }

    @Override
    public long count() {
        return ++this.autoIncrement;
    }
    
}
