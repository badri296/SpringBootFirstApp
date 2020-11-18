package edu.javainreal.SpringBootFirstApp.controllers;

import edu.javainreal.SpringBootFirstApp.model.Session;
import edu.javainreal.SpringBootFirstApp.model.Speaker;
import edu.javainreal.SpringBootFirstApp.repositories.SessionRepository;
import edu.javainreal.SpringBootFirstApp.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    @Autowired
    SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {

        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return speakerRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker create(@RequestBody final Speaker session) {
        return speakerRepository.saveAndFlush(session);
    }
    @RequestMapping(value="{id}",method=RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value="{id}",method=RequestMethod.PUT)
    public Speaker update(@PathVariable Long id,@RequestBody Speaker session){

        Speaker existingSpeaker = speakerRepository.getOne(id);
        BeanUtils.copyProperties(session,existingSpeaker,"speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }

}
