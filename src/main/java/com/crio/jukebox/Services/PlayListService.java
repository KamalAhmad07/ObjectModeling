package com.crio.jukebox.Services;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.PlayListEmptyException;
import com.crio.jukebox.exception.PlayListNotFoundException;
import com.crio.jukebox.exception.SongNotFoundException;

public interface PlayListService {
     public Playlist createPlayList(List<String> playlist) throws SongNotFoundException;
     public boolean playListExistById(String id) throws PlayListNotFoundException;
     public boolean deletePlaylist(String id) throws PlayListNotFoundException;
     public  Playlist getPlayListById(String id);
     public List<Playlist>  getAllPlaylists();
     public boolean isPlayListEmpty() throws PlayListEmptyException;
    
}
