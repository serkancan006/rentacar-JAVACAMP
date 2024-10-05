package com.sckaya.rentacar.business.concretes;

import org.springframework.stereotype.Service;

import java.util.List;

import com.sckaya.rentacar.business.abstracts.BrandService;
import com.sckaya.rentacar.business.requests.CreateBrandRequest;
import com.sckaya.rentacar.business.requests.UpdateBrandRequest;
import com.sckaya.rentacar.business.responses.GetAllBrandResponse;
import com.sckaya.rentacar.business.responses.GetByIdBrandResponse;
import com.sckaya.rentacar.business.rules.BrandBusinessRules;
import com.sckaya.rentacar.core.utilities.mappers.ModelMapperService;
import com.sckaya.rentacar.dataAccess.abstracts.BrandRepository;

import lombok.AllArgsConstructor;

import com.sckaya.rentacar.Entities.concretes.Brand;

@Service // bu sınıf bir servis nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService {
    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    // @AutoWired eklenebilir default değeri budur
    // @AllArgsConstructor ile oluşturabilirsin
    // public BrandManager(BrandRepository brandRepository) {
    // this.brandRepository = brandRepository;
    // }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

        // List<GetAllBrandResponse> brandsResponse = new
        // ArrayList<GetAllBrandResponse>();

        // for (Brand brand : brands) {
        // GetAllBrandResponse responseItem = new GetAllBrandResponse();
        // responseItem.setId(brand.getId());
        // responseItem.setName(brand.getName());

        // brandsResponse.add(responseItem);
        // }

        List<GetAllBrandResponse> brandsResponse = brands.stream()
            .map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandResponse.class)).toList();

        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        // iş kuralları
        brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());

        // Brand brand = new Brand();
        // brand.setName(createBrandRequest.getName());

        // mapper --> modal mapper (*kullanıcaz), jmapper, dosen
        Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        brandRepository.deleteById(id);
    }

    @Override
    public GetByIdBrandResponse getbyid(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetByIdBrandResponse response = modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);

        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brandRepository.save(brand);
    }

}
