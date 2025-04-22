package com.unilasalle.tpwebavance_back.controllers;

import com.unilasalle.tpwebavance_back.exceptions.NotFoundException;
import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.OnduleurDTO;
import com.unilasalle.tpwebavance_back.models.Piece;
import com.unilasalle.tpwebavance_back.models.PieceDTO;
import com.unilasalle.tpwebavance_back.services.PieceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody PieceDTO pieceDTO) {
        try {
            this.pieceService.delete(pieceDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
