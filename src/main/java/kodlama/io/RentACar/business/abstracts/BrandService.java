package kodlama.io.RentACar.business.abstracts;

import kodlama.io.RentACar.business.requests.CreateRequestBrand;
import kodlama.io.RentACar.business.requests.UpdateBrandRequest;
import kodlama.io.RentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.RentACar.business.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();
    void add(CreateRequestBrand createRequestBrand);
    GetByIdBrandResponse getById(int id);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
