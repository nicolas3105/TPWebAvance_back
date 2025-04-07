package com.unilasalle.tpwebavance_back.controllers;

import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.Piece;
import com.unilasalle.tpwebavance_back.models.PieceDTO;
import com.unilasalle.tpwebavance_back.services.PieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piece")
@RequiredArgsConstructor
public class PieceController {

    private final PieceService pieceService;

    @GetMapping
    public List<PieceDTO> getAll() {
        return pieceService.getAll();
    }

    @GetMapping("/{id}")
    public PieceDTO getById(@PathVariable Long id) {
        return pieceService.getById(id);
    }

    @PostMapping
    public PieceDTO create(@RequestBody PieceDTO dto) {
        return pieceService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pieceService.delete(id);
    }
}
