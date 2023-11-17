package com.oliveiradevsuperior.dslist.controllers;

import com.oliveiradevsuperior.dslist.dto.GameListDto;
import com.oliveiradevsuperior.dslist.dto.GameMinDto;
import com.oliveiradevsuperior.dslist.dto.ReplacementDto;
import com.oliveiradevsuperior.dslist.services.GameListService;
import com.oliveiradevsuperior.dslist.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<GameListDto> findAll() {
        List<GameListDto> result = gameListService.findAll();

        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId) {
        List<GameMinDto> result = gameServices.findByList(listId);

        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDto body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
