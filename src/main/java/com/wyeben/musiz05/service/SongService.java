package com.wyeben.musiz05.service;

import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Song;
import com.wyeben.musiz05.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;


    Song song = new Song();



    public List<Song> getSongs(){
        return songRepository.findAll();
    }


    public Response saveSong(){
        Response response = new Response();
        songRepository.save(song);
        response.setMessage("saved successfuly");
        return response;
    }

}
