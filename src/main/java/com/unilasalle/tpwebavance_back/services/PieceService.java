package com.unilasalle.tpwebavance_back.services;

import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.Piece;
import com.unilasalle.tpwebavance_back.repositories.PieceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PieceService {
    private final PieceRepository pieceRepository;

    public List<Piece> getAllPieces() { return this.pieceRepository.findAll(); }

    public Piece savePiece(Piece piece) {
        return this.pieceRepository.save(piece);
    }

    public void deletePiece(Long id) {
        this.pieceRepository.deleteById(id);
    }

    public Piece getPieceById(Long id) {
        return this.pieceRepository.findById(id).orElse(null);
    }
}
