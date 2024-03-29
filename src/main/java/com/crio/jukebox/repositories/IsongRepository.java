package com.crio.jukebox.repositories;

import java.util.List;
import com.crio.jukebox.entities.Song;

public interface IsongRepository extends CRUDRepository<Song,String>  {
    public List<Song> findAllSongs();
}
