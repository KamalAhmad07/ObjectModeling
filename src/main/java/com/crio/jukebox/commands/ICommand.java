package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exception.SongNotFoundException;

public interface ICommand {
    void execute(List<String> command);
}

