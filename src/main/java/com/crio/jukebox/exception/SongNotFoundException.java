package com.crio.jukebox.exception;

public class SongNotFoundException  extends Exception{
    public SongNotFoundException(){
         super();
    }
    public  SongNotFoundException(String msg) {
         super(msg);
    }
}
