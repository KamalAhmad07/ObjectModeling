package com.crio.jukebox.entities;

import java.util.List;

public class Playlist  extends BaseEntity {

      private String name;
      private List<Song> songId;

      public Playlist(String name,List<Song> song){
                this.name = name;
                this.songId = song;
      }
      public Playlist(String id,String name,List<Song> songs){
            this.id = id;
            this.name = name;
            this.songId = songs;

      }

      public String getName() {
            return name;
      }

      public List<Song> getSongId() {
            return songId;
      }

      @Override
      public String toString() {
            return "Playlist [name=" + name + ", songId=" + songId + "]";
      }
  

}
