package com.sckaya.rentacar.business.abstracts;

import java.util.List;

import com.sckaya.rentacar.business.requests.CreateModelRequest;
import com.sckaya.rentacar.business.responses.GetAllModelsResponse;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
} 
