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

    /*@GetMapping
    public List<OnduleurDTO> getAllOnduleurs(){
        return this.onduleurService.getOnduleurs();
    }*/

    @GetMapping
    public List<Onduleur> getAllOnduleurs() {
        return onduleurService.getAllOnduleurs();
    }

    @GetMapping("/piece/{pieceId}")
    public List<Onduleur> getByPiece(@PathVariable Long pieceId) {
        return onduleurService.findByPieceId(pieceId);
    }

    @PostMapping
    public Onduleur createOnduleur(@RequestBody Onduleur onduleur) {
        return onduleurService.saveOnduleur(onduleur);
    }

    @DeleteMapping("/{id}")
    public void deleteOnduleur(@PathVariable Long id) {
        onduleurService.deleteOnduleur(id);
    }

    @GetMapping("/{id}")
    public Onduleur getOnduleurById(@PathVariable Long id) {
        return onduleurService.getOnduleurById(id);
    }
}