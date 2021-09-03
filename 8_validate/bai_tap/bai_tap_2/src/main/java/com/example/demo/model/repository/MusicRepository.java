package com.example.demo.model.repository;

import com.example.demo.model.bean.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer> {
}
