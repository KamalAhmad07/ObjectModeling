package com.crio.jukebox.commands;

import java.util.List;

import com.crio.jukebox.Services.PlayListService;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.SongStatus;
import com.crio.jukebox.exception.SongNotFoundException;

public class PlaySong implements ICommand {

    private final PlayListService playListService;
    Song currentPlayingSong = null;
    public  PlaySong(PlayListService playListService){
         this.playListService = playListService;
    }

    @Override
    public void execute(List<String> command) {
        String  commandId = command.get(2);
        try { 
        if(commandId.trim().equals("NEXT")) playSongForNext(commandId); 
        else if(commandId.trim().equals("BACK")) playSongForBack(commandId);
        else playSongforSongId(commandId);          
       } catch (SongNotFoundException e) {
              System.out.println(e.getMessage());
          }     
    }


    ///-----------------main logic .............

    public void  playSongForBack(String command) throws SongNotFoundException{
     List<Playlist> playlists =  playListService.getAllPlaylists();

     Playlist playlist =  playlists.stream().findFirst().get() ;
   
     List<Song> songList = playlist.getSongId();
              
     if(songList != null){        
           for(int  i=songList.size()-1;i>=0; i--){
             Song song  = songList.get(i);
               if(song.getSongStatus().equals(SongStatus.PLAY)){
                  song.setSongStatus(SongStatus.PAUSE);                                                                                                      
                   if(i==0){
                     i= songList.size()-1;
                     song = songList.get(i);                    
                     System.out.println("Current Song Playing"); 
                     System.out.println(song);  
                     song.setSongStatus(SongStatus.PLAY);
                     return;
                   }
                   --i;
                  song = songList.get(i);
                   System.out.println("Current Song Playing"); 
                   System.out.println(song);  
                   song.setSongStatus(SongStatus.PLAY);
                   
                  }
               //  System.out.println("-----------iiiii= ------"+i);  
               }
           }
       else{
            throw new  SongNotFoundException("Given song id is not a part of the active playlist");
      }
    }
   
  public  void  playSongForNext(String  command) throws SongNotFoundException{
    
     List<Playlist> playlists =  playListService.getAllPlaylists();

       Playlist playlist =  playlists.stream().findFirst().get() ;
     
       List<Song> songList = playlist.getSongId();
                
       if(songList != null){
          
             for(int  i=0;i<songList.size(); i++){
               Song song  = songList.get(i);
                 if(song.getSongStatus().equals(SongStatus.PLAY)){
                    song.setSongStatus(SongStatus.PAUSE);
                       if(i==songList.size()-1){                    
                         System.out.println("Current Song Playing"); 
                           song  = songList.get(0);
                           System.out.println(song);
                           song.setSongStatus(SongStatus.PLAY);
                         //   break;
                         return;
                       }
                    ++i;
                   song  = songList.get(i);
                   System.out.println("Current Song Playing"); 
                   System.out.println(song);  
                   song.setSongStatus(SongStatus.PLAY);
                 }
             }
        }else{
         throw new  SongNotFoundException("Given song id is not a part of the active playlist");
        }


  }
    
   
    public  void  playSongforSongId(String  songId) throws SongNotFoundException{
          List<Playlist> playlists =  playListService.getAllPlaylists();
         Playlist playlist =  playlists.stream().findFirst().get() ;
         List<Song> songList = playlist.getSongId();
           for(Song  song : songList){
               // if(song.getSongStatus().equals(SongStatus.PLAY)){
               //        song.setSongStatus(SongStatus.PAUSE);
               // }
               if(song.getId().equals(songId)){
                    System.out.println("Current Song Playing");                   
                    System.out.println(song);
                    song.setSongStatus(SongStatus.PLAY);
                              
                    return;
               }
           }
         throw new  SongNotFoundException("Given song id is not a part of the active playlist");  
    }             
}
