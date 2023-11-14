package com.oliveiradevsuperior.dslist.controllers;

import com.oliveiradevsuperior.dslist.dto.GameMinDto;
import com.oliveiradevsuperior.dslist.entities.Game;
import com.oliveiradevsuperior.dslist.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameServices gameServices;

    @GetMapping()
    public List<GameMinDto> findAll() {
        List<GameMinDto> result = gameServices.findAll();

        return result;
    }
}
