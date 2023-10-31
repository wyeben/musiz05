package com.wyeben.musiz05.repository;

import com.wyeben.musiz05.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Integer> {

    List<Song> findBySongTitleAndArtistName(String songTitle, String artistName);

    @Modifying
    @Query("UPDATE Song s SET s.songTitle = :newValue WHERE s.artistName = " +
            ":artistName AND s.songTitle = :songTitle")
    int updateByArtistNameAndSongTitle(@Param("artistName") String artistName,
                                        @Param("songTitle") String songTitle,
                                        @Param("newValue") String newValue);

    int deleteByArtistNameAndSongTitle(String artistName, String songTitle);
}





