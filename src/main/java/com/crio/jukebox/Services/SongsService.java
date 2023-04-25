package com.crio.jukebox.Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.SongStatus;
import com.crio.jukebox.exception.SongNotFoundException;
import com.crio.jukebox.repositories.IsongRepository;

public class SongsService implements ISongServie{


    private final IsongRepository songsRepository;

    public SongsService(IsongRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    @Override
    public List<Song> getAllSongs() {
       return songsRepository.findAll();
    }

    @Override
    public Song create(String name) {
         try {                      
          BufferedReader  reader = new BufferedReader(new FileReader(name));
            String line = reader.readLine();
            while (line != null) {                
                 List<String> songs  =  Arrays.asList(line.split(","));   
                 String artistGrp = songs.get(5).replace("#",",");
                 Song  song  = new Song(songs.get(0), songs.get(1), songs.get(2) , songs.get(3) , songs.get(4) , artistGrp,SongStatus.PAUSE);                
                 songsRepository.save(song);
                line = reader.readLine();
            }
            reader.close();

        } catch (Exception e ) {

            e.printStackTrace();
        }
        return null;
    }
    
    
    @Override
    public boolean chekSongById(String id) throws SongNotFoundException {
        if (!songsRepository.existsById(id)){        
                throw new SongNotFoundException("Some Requested Songs Not Available. Please try again.");            
        }
       return true; 
    }
    
    @Override
    public  Song getSongById(String id){
          return  songsRepository.findById(id);
    }
   
}
