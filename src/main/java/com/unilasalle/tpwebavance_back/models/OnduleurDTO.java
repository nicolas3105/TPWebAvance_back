package com.unilasalle.tpwebavance_back.models;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OnduleurDTO {
    private Long id;
    private String model;
    private String status;
    private Double power;
    private Long pieceId;
}
