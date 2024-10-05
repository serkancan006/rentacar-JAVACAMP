package com.sckaya.rentacar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelMapperManager implements ModelMapperService{
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest() {
        modelMapper.getConfiguration()
        .setAmbiguityIgnored(true) // belirsizlik(aynı isim durumları yada iç içe yapılarda*) durumlarında ignore et yani hata verme devam et demek
        .setMatchingStrategy(MatchingStrategies.LOOSE); 
        // geşek mapleme entitiy içinde id name quantitiy var ise id olmasada kabul et anlamında, alttakinde ise 3 prop da olmak zorunda yoksa kız demek standard da

        return this.modelMapper;
    }

    @Override
    public ModelMapper forResponse() {
        modelMapper.getConfiguration()
        .setAmbiguityIgnored(true)
        .setMatchingStrategy(MatchingStrategies.STANDARD);

        return this.modelMapper;
    }

}
