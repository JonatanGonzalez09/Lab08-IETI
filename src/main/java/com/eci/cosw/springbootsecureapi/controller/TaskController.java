package com.eci.cosw.springbootsecureapi.controller;

import java.util.List;

import com.eci.cosw.springbootsecureapi.model.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping( "/api/tasks" )
public class TaskController {

    @Autowired
    ObjectMapper mapper;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllTasks() {
        String tasks = null;
        try{
            tasks = Unirest.get("https://functiontaskplanner.azurewebsites.net/api/list-tasks?code=j1Bq2S5GXsuhzlaE1s10AaJN5aWQg5x5GaEMKLpMEw8X7KFf/qeaAg==")
                    .asString().getBody();
        }catch (UnirestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tasks, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task) {
        try {
            Unirest.post("https://functiontaskplanner.azurewebsites.net/api/add-task?code=K4MbO8/CHs3aJlTBrGEgFsqMePIa0lvAB7/tGCGgceLOAnvWNNViSw==")
                    .header("Content-Type", "application/json")
                    .body(mapper.writeValueAsString(task)).asString().getStatus();
        } catch (JsonProcessingException | UnirestException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

   

}