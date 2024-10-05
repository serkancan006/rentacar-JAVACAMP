package com.sckaya.rentacar.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sckaya.rentacar.Entities.concretes.Model;
import com.sckaya.rentacar.business.abstracts.ModelService;
import com.sckaya.rentacar.business.requests.CreateModelRequest;
import com.sckaya.rentacar.business.responses.GetAllModelsResponse;
import com.sckaya.rentacar.core.utilities.mappers.ModelMapperService;
import com.sckaya.rentacar.dataAccess.abstracts.ModelRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {
    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream()
            .map(model -> modelMapperService.forResponse()
                .map(model, GetAllModelsResponse.class)).toList();

        return modelsResponse;
    }


    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
        // model.setBrand(null);  // complex durumlarda maplemede hata olmasın diye araya girip ihtiyaçlarımızı giderebiliriz.

        this.modelRepository.save(model);
    }

}
