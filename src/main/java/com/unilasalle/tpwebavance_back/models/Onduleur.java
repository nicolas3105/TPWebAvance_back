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
    @Column(nullable = false)
    private Long id;

    private String model;
    private Boolean status;
    private Double power;

    @ManyToOne
    @JoinColumn(name = "piece_id", nullable = false)
    private Piece piece;
}
