package com.sckaya.rentacar.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sckaya.rentacar.business.abstracts.BrandService;
import com.sckaya.rentacar.business.requests.CreateBrandRequest;
import com.sckaya.rentacar.business.requests.UpdateBrandRequest;
import com.sckaya.rentacar.business.responses.GetAllBrandResponse;
import com.sckaya.rentacar.business.responses.GetByIdBrandResponse;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
    private BrandService brandService;

    // @GetMapping("/getallBrand")
    @GetMapping()
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getbyid(id);
    }

    // @PostMapping("/addBrand")
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        brandService.add(createBrandRequest);        
    }
    
    @PutMapping()
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }

}
