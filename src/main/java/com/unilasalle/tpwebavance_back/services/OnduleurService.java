package com.unilasalle.tpwebavance_back.services;

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


@Service
@Slf4j
@RequiredArgsConstructor
public class OnduleurService {

    private final OnduleurRepository onduleurRepository;

    public List<Onduleur> getAllOnduleurs() { return this.onduleurRepository.findAll(); }

    public List<Onduleur> findByPieceId(Long pieceId) {
        return onduleurRepository.findByPieceId(pieceId);
    }

    public Onduleur saveOnduleur(Onduleur onduleur) {
        return onduleurRepository.save(onduleur);
    }

    public void deleteOnduleur(Long id) {
        onduleurRepository.deleteById(id);
    }

    public Onduleur getOnduleurById(Long id) {
        return onduleurRepository.findById(id).orElse(null);
    }

    /*public List<OnduleurDTO> getOnduleurs() {
        List<Onduleur> onduleurs = this.onduleurRepository.findAll();
        return listToDTO(onduleurs);
    }*/

    private OnduleurDTO toDTO(Onduleur onduleur){
        OnduleurDTO dto = new OnduleurDTO();
        BeanUtils.copyProperties(onduleur, dto);
        return dto;
    }

    private List<OnduleurDTO> listToDTO(List<Onduleur> onduleurs){
        List<OnduleurDTO> dto = new ArrayList<>();
        for (Onduleur onduleur : onduleurs){
            BeanUtils.copyProperties(onduleur, dto);
        }
        return dto;
    }
}
