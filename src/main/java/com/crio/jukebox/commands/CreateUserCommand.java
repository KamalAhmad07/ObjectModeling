package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.Services.UserService;
import com.crio.jukebox.entities.User;

public class CreateUserCommand  implements ICommand{

     private final UserService userService;
     public  CreateUserCommand(UserService userService){        
        this.userService = userService;
     }


    @Override
    public void execute(List<String> command) {
        String userName = command.get(1);
        User user =  userService.createUser(userName);
        System.out.println(user.getId()+" "+user.getName());
    }
    
}
