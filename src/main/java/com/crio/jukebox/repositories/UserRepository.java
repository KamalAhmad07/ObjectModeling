package com.crio.jukebox.repositories;

import com.crio.jukebox.entities.User;

public interface UserRepository {
    public  User createUser(User user);
    public long  count();
}
