package com.unilasalle.tpwebavance_back.services;

import com.unilasalle.tpwebavance_back.Mapper.OnduleurMapper;
import com.unilasalle.tpwebavance_back.exceptions.NotFoundException;
import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.OnduleurDTO;
import com.unilasalle.tpwebavance_back.repositories.OnduleurRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class OnduleurService {

    private final OnduleurRepository onduleurRepository;
    private final OnduleurMapper onduleurMapper;
    private final PieceService pieceService;

    public List<OnduleurDTO> findAll() {
        return onduleurMapper.listToDTO(onduleurRepository.findAll());
    }

    public OnduleurDTO findById(Long id) {
        return onduleurRepository.findById(id).map(onduleurMapper::toDTO).orElse(null);
    }

    public OnduleurDTO save(OnduleurDTO dto) {
        Onduleur entity = onduleurMapper.toEntity(dto);
        Onduleur saved = onduleurRepository.save(entity);
        return onduleurMapper.toDTO(saved);
    }

    public void delete(OnduleurDTO onduleurDTO) throws NotFoundException {
        if (onduleurDTO.getId() == null) {
            log.error("Onduleur with id null not found");
            throw new NotFoundException("Can't delete UPS", "Can't delete UPS with id null");
        }

        Onduleur entity = this.onduleurRepository.findById(onduleurDTO.getId())
                .orElseThrow(() -> {
                    log.error("UPS with id {} not found", onduleurDTO.getId());
                    return new NotFoundException("Can't delete UPS", "Can't find UPS with id : " + onduleurDTO.getId());
                });

        this.onduleurRepository.delete(entity);
    }

    public List<OnduleurDTO> findByPieceId(Long pieceId) {
        return onduleurMapper.listToDTO(onduleurRepository.findByPieceId(pieceId));
    }
}
