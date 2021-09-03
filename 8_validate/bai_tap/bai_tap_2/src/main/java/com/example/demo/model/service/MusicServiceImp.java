package com.example.demo.model.service;

import com.example.demo.model.bean.Music;
import com.example.demo.model.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImp implements MusicService {
    @Autowired
    private MusicRepository musicRepository;
    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void saveMusic(Music music) {
        this.musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return this.musicRepository.findById(id).get();
    }
}
