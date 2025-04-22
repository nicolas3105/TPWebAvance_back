package com.unilasalle.tpwebavance_back.models;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OnduleurDTO extends Onduleur {
    private Long id;
    private String model;
    private Boolean status;
    private Double power;
    private Long pieceId;
}
