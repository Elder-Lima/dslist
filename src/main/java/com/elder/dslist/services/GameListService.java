package com.elder.dslist.services;

import com.elder.dslist.dto.GameDTO;
import com.elder.dslist.dto.GameListDTO;
import com.elder.dslist.dto.GameMinDTO;
import com.elder.dslist.entities.Game;
import com.elder.dslist.entities.GameList;
import com.elder.dslist.repositories.GameListRepository;
import com.elder.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
        return dto;
    }
}
