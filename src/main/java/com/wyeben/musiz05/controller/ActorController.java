package com.wyeben.musiz05.controller;

import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Actor;
import com.wyeben.musiz05.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("record")
    public List<Actor> getAllFiled(){
        return actorService.getDetail();
    }

    @PostMapping("save")
    public Response saveActor(){
        return actorService.saveActor();
    }

}
