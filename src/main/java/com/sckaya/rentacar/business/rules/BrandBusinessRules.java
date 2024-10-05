package com.sckaya.rentacar.business.rules;

import org.springframework.stereotype.Service;

import com.sckaya.rentacar.core.utilities.exceptions.BusinessException;
import com.sckaya.rentacar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    
    public void checkIfBrandNameExists(String name){
        if(this.brandRepository.existsByName(name)) {
            //throw new RuntimeException("Brand already exists"); // java expection types araştır. Runtime ve Compilertime hataları mevcut ve ayrılır.
            throw new BusinessException("Brand name already exists");
        }
    }
}
