package com.unilasalle.tpwebavance_back.controllers;

import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.Piece;
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
    public List<Piece> getAllPieces() {
        return pieceService.getAllPieces();
    }

    @PostMapping
    public Piece createPiece(@RequestBody Piece piece) {
        return pieceService.savePiece(piece);
    }

    @DeleteMapping("/{id}")
    public void deletePiece(@PathVariable Long id) {
        pieceService.deletePiece(id);
    }

    @GetMapping("/{id}")
    public Piece getPieceById(@PathVariable Long id) {
        return pieceService.getPieceById(id);
    }
}
