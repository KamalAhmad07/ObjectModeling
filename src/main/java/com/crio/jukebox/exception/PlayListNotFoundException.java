package com.crio.jukebox.exception;


public class PlayListNotFoundException extends Exception {
   
    public PlayListNotFoundException(){
        super();
    }

    public PlayListNotFoundException(String msg){
        super(msg);
    } 
}
