package com.sckaya.rentacar.webApi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sckaya.rentacar.business.abstracts.ModelService;
import com.sckaya.rentacar.business.requests.CreateModelRequest;
import com.sckaya.rentacar.business.responses.GetAllModelsResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void postMethodName(@Valid @RequestBody CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }


    
    
}
