package com.crio.jukebox.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.SongNotFoundException;

public class PlayListRepositoryImpl  implements PlaylistRepository{

    private final Map<String,Playlist> playlists ;
    private   long  autoIncerement=0;

    public  PlayListRepositoryImpl(){
         this.playlists = new HashMap<>();
         this.autoIncerement = playlists.size();
    }

    @Override
    public Playlist createPlaylist(Playlist entity) {

         if(entity.getId() == null){
             Playlist playlist  = new Playlist(String.valueOf(count()), entity.getName(), entity.getSongId());
             entity = playlist;
         }    
        playlists.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public long count() {
        return ++this.autoIncerement;
    }

    @Override
    public boolean deletePlaylist(String id) {
        return playlists.remove(id,getPlaylistById(id));
    }

    @Override
    public boolean playListExistById(String id) {
        return playlists.containsKey(id);        
    }

    @Override
    public Playlist getPlaylistById(String id) {
        return playlists.get(id);
    }
    
    @Override
    public List<Playlist>  getAllPlaylists(){
          return playlists.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    @Override
    public Playlist addSongsInPlayList(String  playListId,List<Song> songs) {
        Playlist playlist = getPlaylistById(playListId);        
        for(Song song : songs){            
             if (!playlist.getSongId().contains(song.getId()) ){
                  playlist.getSongId().add(song);
             }
        }
        return playlist;
    }

    @Override
    public boolean isPlayListEmpty(){
        return  playlists.isEmpty();
    }
}
