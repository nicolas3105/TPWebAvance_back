package com.unilasalle.tpwebavance_back.Mapper;

import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.OnduleurDTO;
import com.unilasalle.tpwebavance_back.models.Piece;
import com.unilasalle.tpwebavance_back.repositories.PieceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class OnduleurMapper {

    private final PieceRepository pieceRepository;

    public OnduleurDTO toDTO(Onduleur onduleur){
        OnduleurDTO dto = new OnduleurDTO();
        BeanUtils.copyProperties(onduleur, dto);

        if (onduleur.getPiece() != null) {
            dto.setPieceId(onduleur.getPiece().getId());
        }

        return dto;
    }

    public List<OnduleurDTO> listToDTO(List<Onduleur> onduleurs) {
        return onduleurs.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Onduleur toEntity(OnduleurDTO dto) {
        Onduleur entity = new Onduleur();
        BeanUtils.copyProperties(dto, entity);

        if (dto.getPieceId() != null) {
            Piece piece = pieceRepository.findById(dto.getPieceId())
                    .orElseThrow(() -> new RuntimeException("Piece not found"));
            entity.setPiece(piece);
        }

        return entity;
    }

    public List<Onduleur> listToEntity(List<OnduleurDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }


}
