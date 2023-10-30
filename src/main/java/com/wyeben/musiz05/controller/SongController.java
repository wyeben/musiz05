package com.wyeben.musiz05.controller;

import com.wyeben.musiz05.dto.Request;
import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Song;
import com.wyeben.musiz05.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("23vibes")
public class SongController {

    @Autowired
    SongService songService;

    @GetMapping("show-all-songs")
    public List<Song> getAllSongs(){
        return songService.getSongs();
    }

    @PostMapping("upload")
    public Response saveSong(@RequestBody Request request){
       return songService.registerArtiste(request);
    }

    @GetMapping("download/{songTitle}/{artistName}")
    public List<Song> getBySongTitleAndArtistName(@PathVariable String songTitle,
                                                  @PathVariable String artistName){
        return songService.getBySongTitleAndArtistName(songTitle, artistName);
    }

    @PutMapping("update/{artistName}/{songTitle}")
    public List<Song> updateSongByArtistNameAndSongTitle(@PathVariable String artistName,
                                                         @PathVariable String songTitle){
        return songService.updateSongByArtistNameAndSongTitle(artistName, songTitle);
    }

}
