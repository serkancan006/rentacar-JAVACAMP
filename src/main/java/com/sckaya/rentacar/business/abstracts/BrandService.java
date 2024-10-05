package com.sckaya.rentacar.business.abstracts;

import java.util.List;

import com.sckaya.rentacar.business.requests.CreateBrandRequest;
import com.sckaya.rentacar.business.requests.UpdateBrandRequest;
import com.sckaya.rentacar.business.responses.GetAllBrandResponse;
import com.sckaya.rentacar.business.responses.GetByIdBrandResponse;

public interface BrandService {
    public List<GetAllBrandResponse> getAll();
    public GetByIdBrandResponse getbyid(int id);
    
    public void add(CreateBrandRequest createBrandRequest);
    public void update(UpdateBrandRequest updateBrandRequest);
    public void delete(int id);
}
