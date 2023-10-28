package com.wyeben.musiz05.service;

import com.wyeben.musiz05.dto.Request;
import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Song;
import com.wyeben.musiz05.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements SongServices{

    @Autowired
    SongRepository songRepository;


    public List<Song> getSongs(){
        return songRepository.findAll();
    }


    public void saveSong(Request request){

    }

    @Override
    public Response registerArtiste(Request request) {
        Song song = new Song();
        song.setSongTitle(request.getSongTitle());
        song.setArtistName(request.getArtistName());
        song.setLastUpdate(request.getLastUpdate());
        songRepository.save(song);
        Response response = new Response();
        response.setMessage("saved successfully");
        return response;
    }

    public Song downloadSongBySongTitleAndArtistName(Request request){
        return null;
    }

    public List<Song> getBySongTitleAndArtistName(String songTitle, String artistName) {
        return songRepository.findBySongTitleAndArtistName(songTitle, artistName);
    }
}
