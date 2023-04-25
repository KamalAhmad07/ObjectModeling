package com.crio.jukebox.Services;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.PlayListEmptyException;
import com.crio.jukebox.exception.PlayListNotFoundException;
import com.crio.jukebox.exception.SongNotFoundException;
import com.crio.jukebox.repositories.PlaylistRepository;

public class PlayListServiceImpl implements PlayListService {

         private  final  PlaylistRepository playlistRepository;
         private final   ISongServie songsService; 


    public PlaylistRepository getPlaylistRepository() {
            return playlistRepository;
        }

        public ISongServie getSongsService() {
            return songsService;
        }

    public PlayListServiceImpl(PlaylistRepository playlistRepository,
                ISongServie songsService) {
            this.playlistRepository = playlistRepository;
            this.songsService = songsService;
        }

    @Override
    public Playlist createPlayList(List<String> playlist) throws SongNotFoundException {
        
        List<Song> songId = new ArrayList<>();
        
        for(int  i=3;i<playlist.size(); i++){

            if(songsService.chekSongById(playlist.get(i))){
                     songId.add(songsService.getSongById( playlist.get(i)));       
            }else{
                 throw new SongNotFoundException("Some Requested Songs Not Available. Please try again");
            }
        }

        Playlist entity = new Playlist(playlist.get(2),songId);
    
         return playlistRepository.createPlaylist(entity);    
     }




    @Override
    public boolean playListExistById(String id) throws PlayListNotFoundException {
        if(!playlistRepository.playListExistById(id)){
            throw new  PlayListNotFoundException("Playlist Not Found");
        }
      return true;  
    }

    @Override
    public boolean deletePlaylist(String id) throws PlayListNotFoundException {
        if(playListExistById(id)){
        return playlistRepository.deletePlaylist(id);
      }
       return false;

    }

    @Override
    public List<Playlist>  getAllPlaylists(){
          return playlistRepository.getAllPlaylists();
    }
   
    @Override
    public  Playlist getPlayListById(String id){
         return playlistRepository.getPlaylistById(id);
    }
 
     @Override
     public boolean isPlayListEmpty() throws PlayListEmptyException{
         return playlistRepository.isPlayListEmpty();
     }

   

    
}
