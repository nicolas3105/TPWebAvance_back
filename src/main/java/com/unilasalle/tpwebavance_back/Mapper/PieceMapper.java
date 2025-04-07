package com.unilasalle.tpwebavance_back.Mapper;

import com.unilasalle.tpwebavance_back.models.Piece;
import com.unilasalle.tpwebavance_back.models.PieceDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PieceMapper {
    public PieceDTO toDTO(Piece piece) {
        PieceDTO dto = new PieceDTO();
        BeanUtils.copyProperties(piece, dto);
        return dto;
    }

    public Piece toEntity(PieceDTO dto) {
        Piece entity = new Piece();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public List<PieceDTO> listToDTO(List<Piece> pieces) {
        return pieces.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<Piece> listToEntity(List<PieceDTO> dtos) {
        return dtos.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }
}
