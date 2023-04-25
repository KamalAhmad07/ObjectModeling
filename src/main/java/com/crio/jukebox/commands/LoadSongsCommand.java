package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.Services.ISongServie;
import com.crio.jukebox.entities.Song;

public class LoadSongsCommand  implements ICommand{

    private final ISongServie songServie;

    public LoadSongsCommand(ISongServie songServie){
          this.songServie = songServie;
    }

    @Override
    public void execute(List<String> songs) {
        String  songFileName = songs.get(1);
         songServie.create(songFileName);
          if(!songServie.getAllSongs().isEmpty()){
             System.out.println("Songs Loaded successfully");
          }
          return;
    }

  
}
