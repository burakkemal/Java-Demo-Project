package kodlama.io.RentACar.business.concretes;

import kodlama.io.RentACar.business.abstracts.BrandService;
import kodlama.io.RentACar.business.requests.CreateRequestBrand;
import kodlama.io.RentACar.business.requests.UpdateBrandRequest;
import kodlama.io.RentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.RentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.RentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.RentACar.dataAccess.BrandRepository;
import kodlama.io.RentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands=brandRepository.findAll();


        //List<GetAllBrandsResponse> brandsResponses=new ArrayList<GetAllBrandsResponse>();
        //for (Brand brand: brands) {
           // GetAllBrandsResponse resposeItem=new GetAllBrandsResponse();
          //  resposeItem.setName(brand.getName());
          //  resposeItem.setId(brand.getId());
          //  brandsResponses.add(resposeItem);
       //  }

        List<GetAllBrandsResponse> brandsResponses=brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                        .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());

        return brandsResponses;
    }

    @Override
    public void add(CreateRequestBrand createRequestBrand) {
        //Brand brand=new Brand();
        //brand.setName(createRequestBrand.getName());

        Brand brand=this.modelMapperService.forRequest().map(createRequestBrand,Brand.class);
        this.brandRepository.save(brand);

    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow(); //bulamazsan hata fırlat
        GetByIdBrandResponse response=this.modelMapperService.forResponse()
                .map(brand,GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand=this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
