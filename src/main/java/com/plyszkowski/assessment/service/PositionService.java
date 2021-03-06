package com.plyszkowski.assessment.service;

import com.plyszkowski.assessment.model.Position;
import com.plyszkowski.assessment.repository.PositionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService {

    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    public Position create(Position position) {
        return positionRepository.save(position);
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }

    public Position editPosition(Position position) {
        Position editPosition = positionRepository.getById(position.getId());
        editPosition.setName(position.getName());
        Position save = positionRepository.save(editPosition);
        return save;
    }
}
