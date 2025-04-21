package com.unilasalle.tpwebavance_back.repositories;

import com.unilasalle.tpwebavance_back.models.Onduleur;
import com.unilasalle.tpwebavance_back.models.OnduleurDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OnduleurRepository extends JpaRepository<Onduleur, Long> {
    List<Onduleur> findByPieceId(Long pieceId);

}
