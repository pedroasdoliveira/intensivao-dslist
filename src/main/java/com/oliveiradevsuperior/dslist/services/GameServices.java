package com.oliveiradevsuperior.dslist.services;

import com.oliveiradevsuperior.dslist.dto.GameDto;
import com.oliveiradevsuperior.dslist.dto.GameMinDto;
import com.oliveiradevsuperior.dslist.entities.Game;
import com.oliveiradevsuperior.dslist.projections.GameMinProjection;
import com.oliveiradevsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServices {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();

        return dto;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id) {
        Game result = gameRepository.findById(id).get();
        GameDto dto = new GameDto(result);

        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        List<GameMinDto> dto = result.stream().map(x -> new GameMinDto(x)).toList();

        return dto;
    }
}
