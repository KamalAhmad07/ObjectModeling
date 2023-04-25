package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.Services.PlayListService;
import com.crio.jukebox.exception.PlayListNotFoundException;

public class DeletePlayList  implements ICommand{

      private final PlayListService playListService;

      public DeletePlayList(PlayListService playListService){
          this.playListService = playListService;
      }

    @Override
    public void execute(List<String> command) {
        String  playListId =  command.get(2);    
        try{
           if(playListService.deletePlaylist(playListId)){
              System.out.println("Delete Successful");
            }         
       
        }catch(PlayListNotFoundException p){
               System.out.println(p.getMessage());
        }

    }
    
}
