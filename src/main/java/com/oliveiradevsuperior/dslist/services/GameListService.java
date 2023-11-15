package com.oliveiradevsuperior.dslist.services;

import com.oliveiradevsuperior.dslist.dto.GameListDto;
import com.oliveiradevsuperior.dslist.entities.GameList;
import com.oliveiradevsuperior.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDto(x)).toList();
    }
}
