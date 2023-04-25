package com.crio.jukebox.commands;

import java.util.List;
import java.util.Optional;

import com.crio.jukebox.Services.PlayListService;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.SongStatus;
import com.crio.jukebox.exception.PlayListEmptyException;

public class PlayPlaylist implements ICommand {

  
    private  final PlayListService playListService;   
    private SongStatus songStatus;
    public  PlayPlaylist (PlayListService playListService){
         this.playListService =playListService;
    }

    @Override
    public void execute(List<String> command) {
        String playListCommand =  command.get(2);
        try {            

            if(!playListService.isPlayListEmpty()){
                Playlist playlist =  playListService.getPlayListById(playListCommand);
                // Optional<Song>  song =  playlist.getSongId().stream().filter(s->s.getSongStatus().equals(songStatus.PLAY)).findFirst();
                // song.get().setSongStatus(songStatus.PAUSE);
                // playlist.getSongId().get(0).setSongStatus(songStatus.PLAY);
                System.out.println("Current Song Playing"); 
                System.out.println(playlist.getSongId().get(0));
                // playlist.getSongId().get(0).setSongStatus(SongStatus.PLAY);
            }else{
                throw new PlayListEmptyException("Playlist is empty");
            }

        } catch (PlayListEmptyException e) {
             System.out.println(e.getMessage());
        }
        
    }
    
}
