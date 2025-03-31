package com.unilasalle.tpwebavance_back.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Onduleur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String status;
    private Double power;

    @ManyToOne
    @JoinColumn(name = "piece_id", nullable = false)
    private Piece piece; // Association à la pièce

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
