package com.wyeben.musiz05.controller;

import com.wyeben.musiz05.dto.Request;
import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Song;
import com.wyeben.musiz05.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("23vibes")
public class SongController {

    @Autowired
    SongService songService;


    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

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

    @PutMapping("update/{artistName}/{songTitle}/{newValue}")
    public ResponseEntity<String> updateSongByArtistNameAndSongTitle(@PathVariable String artistName,
                                                             @PathVariable String songTitle, @PathVariable
                                                                         String newValue){
        boolean success = songService.updateSongByArtistNameAndSongTitle(artistName, songTitle, newValue);

        if(success){
            return ResponseEntity.ok("song updated successfully");
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
