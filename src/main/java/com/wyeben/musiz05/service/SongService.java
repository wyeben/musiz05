package com.wyeben.musiz05.service;

import com.wyeben.musiz05.dto.Request;
import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Song;
import com.wyeben.musiz05.repository.SongRepository;
import net.eunjae.android.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;



ModelMapper modelMapper = new ModelMapper();

    public List<Song> getSongs(){
        return songRepository.findAll();
    }


    public Response saveSong(Request request){
        Song song =
        Response response = new Response();
        songRepository.save(song);
        response.setMessage("saved successfuly");
        return response;
    }

}
