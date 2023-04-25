package com.crio.jukebox.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CommandInvoker {
    
    private static final Map<String, ICommand> songsCollection = new HashMap<>();
    

    // Register the command into the HashMap
    public void register(String commandName, ICommand song){
        songsCollection.put(commandName, song);
    }

    // Get the registered Command
    public  ICommand get(String songName){
        return songsCollection.get(songName);
    }

     
    public void executeCommand(String commandName, List<String> commands) {
        ICommand command = get(commandName);
        if(command == null){          
            return;
        }
        command.execute(commands);
    }  

}

