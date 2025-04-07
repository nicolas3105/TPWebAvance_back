package com.unilasalle.tpwebavance_back.repositories;

import com.unilasalle.tpwebavance_back.models.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends JpaRepository<Piece, Long> {
}
