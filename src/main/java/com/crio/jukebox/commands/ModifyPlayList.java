package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.Services.ISongServie;
import com.crio.jukebox.Services.PlayListService;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.PlayListNotFoundException;
import com.crio.jukebox.exception.SongNotFoundException;

public class ModifyPlayList  implements ICommand{

    
    private final  PlayListService playListService;
    private final  ISongServie songServie;

    public ModifyPlayList(PlayListService playListService, ISongServie songServie){
        this.playListService = playListService;
        this.songServie = songServie; 
    }
    
    @Override
    public void execute(List<String> command) {  
        Playlist playlist = null;
     
    try{
        if(command.get(1).trim().equals("ADD-SONG")){
             playlist =  modifyAdd(command);            
        }
        if(command.get(1).trim().equals("DELETE-SONG")){
            playlist = modifyDelete(command);      
        }
       
        System.out.println("Playlist ID - "+playlist.getId());
        System.out.println("Playlist Name - " +playlist.getName());
        System.out.print("Song IDs -");
        
        for(Song  song : playlist.getSongId()){
             System.out.print(" "+song.getId());
         }
       
        System.out.println();

      }catch (PlayListNotFoundException e) {
         System.out.println(e.getMessage());
      }catch(NullPointerException e){
           System.out.println(e.getLocalizedMessage());
      }catch(SongNotFoundException s){
           System.out.println(s.getMessage());
      }
       
    }
   
    public  Playlist modifyDelete(List<String> command) throws PlayListNotFoundException, SongNotFoundException{
             String  playListId = command.get(3);
             Playlist playlist = null; 
            
               if(playListService.playListExistById(playListId)){

                 playlist = playListService.getPlayListById(playListId);

                 for(int  i=4;i<command.size(); i++){
                    String songid =  command.get(i);
                        Song  song  = songServie.getSongById(songid);
                        if(playlist.getSongId().contains(song)){
                           playlist.getSongId().remove(song);
                        }else{
                             throw new SongNotFoundException("Some Requested Songs for Deletion are not present in the playlist. Please try again.");
                        }
                      }
                 }                           
         return playlist;
    }


    public  Playlist modifyAdd(List<String> command) throws PlayListNotFoundException, SongNotFoundException{
 
        String  playListId = command.get(3);
        Playlist playlist = null; 
      
           if(playListService.playListExistById(playListId)){                            
             playlist = playListService.getPlayListById(playListId);
             for(int  i=4;i<command.size(); i++){
                String songid =  command.get(i);
                 if(songServie.chekSongById(songid)){
                    playlist.getSongId().add(songServie.getSongById( songid ));
                 }
             }
           }
        
        return playlist;
   }
    
}
