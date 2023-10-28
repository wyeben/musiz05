package com.wyeben.musiz05.repository;

import com.wyeben.musiz05.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    List<Song> findBySongTitleAndArtistName(String songTitle, String artistName);
}





