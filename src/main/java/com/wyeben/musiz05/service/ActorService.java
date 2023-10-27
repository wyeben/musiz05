package com.wyeben.musiz05.service;

import com.wyeben.musiz05.dto.Response;
import com.wyeben.musiz05.model.Actor;
import com.wyeben.musiz05.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;


    Actor actor = new Actor();



    public List<Actor> getDetail(){
        return actorRepository.findAll();
    }

    public Response saveActor(){
        Response response = new Response();
        actorRepository.save(actor);
        response.setMessage("saved successfuly");
        return response;
    }

}
