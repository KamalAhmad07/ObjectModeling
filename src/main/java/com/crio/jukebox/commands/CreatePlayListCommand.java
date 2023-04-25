package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.Services.PlayListService;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.exception.SongNotFoundException;

public class CreatePlayListCommand implements ICommand{

   private final  PlayListService playListService;

   

    public CreatePlayListCommand(PlayListService playListService) {
    this.playListService = playListService;
}

   @Override
  public void execute(List<String> command)  {                      
      try{
         Playlist playlist =  playListService.createPlayList(command);
         System.out.println("Playlist ID - "+playlist.getId());
      }catch(SongNotFoundException s){
         System.out.println(s.getMessage());
      }
    }
    
}
