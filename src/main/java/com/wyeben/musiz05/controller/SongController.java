package com.wyeben.musiz05.controller;

import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Song;
import com.wyeben.musiz05.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("artiste")
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("songs")
    public List<Song> getAllSongs(){
        return songService.getSongs();
    }

    @PostMapping("upload")
    public Response saveSong(){
        return songService.saveSong();
    }

}
