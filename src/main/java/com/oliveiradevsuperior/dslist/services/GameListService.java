package com.oliveiradevsuperior.dslist.services;

import com.oliveiradevsuperior.dslist.dto.GameListDto;
import com.oliveiradevsuperior.dslist.entities.GameList;
import com.oliveiradevsuperior.dslist.projections.GameMinProjection;
import com.oliveiradevsuperior.dslist.repositories.GameListRepository;
import com.oliveiradevsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        List<GameList> result = gameListRepository.findAll();

        return result.stream().map(x -> new GameListDto(x)).toList();
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);

        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
