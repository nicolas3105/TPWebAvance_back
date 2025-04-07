package com.unilasalle.tpwebavance_back.services;

import com.unilasalle.tpwebavance_back.Mapper.PieceMapper;
import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.Piece;
import com.unilasalle.tpwebavance_back.models.PieceDTO;
import com.unilasalle.tpwebavance_back.repositories.PieceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class PieceService {
    private final PieceRepository pieceRepository;
    private final PieceMapper pieceMapper;

    public List<PieceDTO> getAll() {
        return pieceMapper.listToDTO(pieceRepository.findAll());
    }

    public PieceDTO getById(Long id) {
        return pieceRepository.findById(id)
                .map(pieceMapper::toDTO)
                .orElse(null);
    }

    public PieceDTO create(PieceDTO dto) {
        Piece piece = pieceMapper.toEntity(dto);
        Piece saved = pieceRepository.save(piece);
        return pieceMapper.toDTO(saved);
    }

    public void delete(Long id) {
        pieceRepository.deleteById(id);
    }

    public Optional<Piece> findEntityById(Long id) {
        return pieceRepository.findById(id);
    }
}
