package com.sckaya.rentacar.business.responses;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandResponse {
    private int id;
    private String name;
}
