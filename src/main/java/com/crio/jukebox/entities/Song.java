package com.crio.jukebox.entities;

public class Song  extends BaseEntity{     
    private String name;
    private String genres;
    private String album;
    private String artist;
    private String artistGroup;
    private  SongStatus songStatus;
    
    
    public Song(String id, String name, String genres, String album, String artist, String artistGroup,SongStatus songStatus){
        this.id = id;
        this.name = name;
        this.genres = genres;
        this.album = album;
        this.artist = artist;
        this.artistGroup = artistGroup;
        this.songStatus = songStatus;
    }

    public String getName() {
        return name;
    }

    public String getGenres(){
        return genres;
    }

    public String getAlbum(){
        return album;
    }

    public String getArtist(){
        return artist;
    }

    public String getArtistGroup(){
        return artistGroup;
    }

    
public SongStatus getSongStatus() {
        return songStatus;
    }
    

public void setSongStatus(SongStatus songStatus) {
    this.songStatus = songStatus;
}

@Override
public String toString() {
    //   return "Song [album=" + album + ", artist=" + artist + ", artistGroup=" + artistGroup
    //               + ", genres=" + genres + ", name=" + name + "]";

    return "Song - "+name+"\n"+
    "Album - "+album+"\n"+
    "Artists - "+artistGroup;
}

     
      

      
}
