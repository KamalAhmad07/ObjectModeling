package com.crio.jukebox.repositories;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import com.crio.jukebox.entities.Song; 


public class SongsRepository implements IsongRepository{
    
    private final Map<String,Song> songs;
    // private long autoIncrement = 0;

    public SongsRepository(){
         songs = new HashMap<>();
        //  autoIncrement = songs.size();
    } 

    @Override
    public Song save(Song entity) {        
        
      songs.put(entity.getId(), entity);
      return entity;
    }

  @Override
   public List<Song> findAll() {
          return songs.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    @Override
     public Song findById(String id) {    
         return songs.get(id);
    }

    @Override
    public boolean existsById(String id) {      
        return songs.containsKey(id);
    }

    @Override
     public void delete(Song entity) {
       // TODO Auto-generated method stub    
     }

     @Override
      public void deleteById(String id) {
       // TODO Auto-generated method stub    
     }

     @Override
     public long count() {
        //  return ++this.autoIncrement;
        return 0;
     }

     @Override
     public List<Song> findAllSongs() {
       // TODO Auto-generated method stub
       return null;
     }
}
