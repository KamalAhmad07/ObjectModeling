package com.crio.jukebox.repositories;

import java.util.List;
import com.crio.jukebox.entities.Playlist;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.SongNotFoundException;

public interface PlaylistRepository {
    public Playlist createPlaylist(Playlist entity);
    public boolean deletePlaylist(String id);
    public boolean playListExistById(String id);
    public Playlist getPlaylistById(String id);
    public List<Playlist>  getAllPlaylists();
    
    public Playlist addSongsInPlayList(String  playListId,List<Song> songs) throws SongNotFoundException ;

    public boolean isPlayListEmpty();

    public long  count();
}
