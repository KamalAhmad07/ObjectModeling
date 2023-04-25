package com.crio.jukebox.exception;

public class PlayListEmptyException  extends Exception{
    
    public PlayListEmptyException(){
         super();
    }
    public  PlayListEmptyException(String msg){
         super(msg);
    }
}

