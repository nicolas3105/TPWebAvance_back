package com.unilasalle.tpwebavance_back.controllers;

import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.OnduleurDTO;
import com.unilasalle.tpwebavance_back.services.OnduleurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onduleur")
@RequiredArgsConstructor
public class OnduleurController {

    private final OnduleurService onduleurService;

    @GetMapping
    public List<OnduleurDTO> getAll() {
        return onduleurService.findAll();
    }

    @GetMapping("/{id}")
    public OnduleurDTO getById(@PathVariable Long id) {
        return onduleurService.findById(id);
    }

    @PostMapping
    public OnduleurDTO create(@RequestBody OnduleurDTO dto) {
        return onduleurService.save(dto);
    }

    @PutMapping("/{id}")
    public OnduleurDTO update(@PathVariable Long id, @RequestBody OnduleurDTO dto) {
        dto.setId(id);
        return onduleurService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        onduleurService.delete(id);
    }

    @GetMapping("/piece/{pieceId}")
    public List<OnduleurDTO> getByPiece(@PathVariable Long pieceId) {
        return onduleurService.findByPieceId(pieceId);
    }
}