package com.unilasalle.tpwebavance_back.Mapper;

import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.OnduleurDTO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OnduleurMapper {
    private OnduleurDTO toDTO(Onduleur onduleur){
        OnduleurDTO dto = new OnduleurDTO();
        BeanUtils.copyProperties(onduleur, dto);
        return dto;
    }

    private List<OnduleurDTO> listToDTO(List<Onduleur> onduleurs) {
        return onduleurs.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}
