package com.oliveiradevsuperior.dslist.services;

import com.oliveiradevsuperior.dslist.dto.GameMinDto;
import com.oliveiradevsuperior.dslist.entities.Game;
import com.oliveiradevsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServices {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();

        return dto;
    }
}
