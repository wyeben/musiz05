package com.wyeben.musiz05.service;

import com.wyeben.musiz05.dto.Request;
import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Song;
import com.wyeben.musiz05.repository.SongRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements SongServices{
    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository){
        this.songRepository = songRepository;
    };


    public List<Song> getSongs(){
        return songRepository.findAll();
    }


    @Override
    public Response registerArtiste(Request request) {
        Song song = new Song();
        song.setSongTitle(request.getSongTitle());
        song.setArtistName(request.getArtistName());
        song.setLastUpdate(request.getLastUpdate());
        songRepository.save(song);
        Response response = new Response();
        response.setMessage("uploaded successfully");
        return response;
    }


    public List<Song> getBySongTitleAndArtistName(String songTitle, String artistName) {
        return songRepository.findBySongTitleAndArtistName(songTitle, artistName);
    }

    @Transactional
    public boolean updateSongByArtistNameAndSongTitle(String artistName, String songTitle, String newValue) {
         int updatedCount = songRepository.updateByArtistNameAndSongTitle(artistName, songTitle, newValue);
         return updatedCount > 0;
    }

    @Transactional
    public ResponseEntity<String> deleteSong(String artistName, String songTitle) {
        int successful = songRepository.deleteByArtistNameAndSongTitle(artistName, songTitle);

        if(successful > 0) {
            return ResponseEntity.ok("Song deleted successfully");
        }else {
            return ResponseEntity.ok("Song not found");
        }
    }
}
