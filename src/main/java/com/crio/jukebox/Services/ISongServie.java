package com.crio.jukebox.Services;

import java.util.List;
import java.util.Optional;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.SongNotFoundException;

public interface ISongServie {
 
    public Song create(String name);
    public List<Song> getAllSongs();
    public boolean chekSongById(String id) throws SongNotFoundException;
    public  Song getSongById(String id);
}
