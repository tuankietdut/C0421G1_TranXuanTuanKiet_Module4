package com.example.demo.model.service;

import com.example.demo.model.bean.Music;

import java.util.List;

public interface MusicService {
    List<Music> findAll();
    void saveMusic(Music music);
    Music findById(int id);
}
