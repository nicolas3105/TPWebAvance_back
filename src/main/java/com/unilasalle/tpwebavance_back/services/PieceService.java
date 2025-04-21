package com.unilasalle.tpwebavance_back.services;

import com.unilasalle.tpwebavance_back.Mapper.PieceMapper;
import com.unilasalle.tpwebavance_back.exceptions.NotFoundException;
import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.OnduleurDTO;
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

    public void delete(PieceDTO pieceDTO) throws NotFoundException {
        if (pieceDTO.getId() == null) {
            log.error("Onduleur with id null not found");
            throw new NotFoundException("Can't delete UPS", "Can't delete UPS with id null");
        }

        Piece entity = this.pieceRepository.findById(pieceDTO.getId())
                .orElseThrow(() -> {
                    log.error("UPS with id {} not found", pieceDTO.getId());
                    return new NotFoundException("Can't delete UPS", "Can't find UPS with id : " + pieceDTO.getId());
                });

        this.pieceRepository.delete(entity);
    }

    public Optional<Piece> findEntityById(Long id) {
        return pieceRepository.findById(id);
    }
}
