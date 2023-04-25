package com.crio.jukebox.Services;

import com.crio.jukebox.entities.User;
import com.crio.jukebox.repositories.UserRepository;

public class UserServiceImpl  implements UserService{

   private final UserRepository userRepository;
   public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
   }



    @Override
    public User createUser(String name) {
        User user = new User(name);
        return userRepository.createUser(user);    
    }
    
}
