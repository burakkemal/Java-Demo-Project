package kodlama.io.RentACar.business.concretes;

import kodlama.io.RentACar.business.abstracts.BrandService;
import kodlama.io.RentACar.business.requests.CreateRequestBrand;
import kodlama.io.RentACar.business.requests.UpdateBrandRequest;
import kodlama.io.RentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.RentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.RentACar.business.rules.BrandBusinessRules;
import kodlama.io.RentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.RentACar.dataAccess.BrandRepository;
import kodlama.io.RentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service //Bu sinif bir Business nesnesidir.
@AllArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    //@AllArgsConstructor kullaninca bu kisma gerek kalmiyor
//    @Autowired
//    public BrandManager(BrandRepository brandRepository) {
//        this.brandRepository = brandRepository;
//    }

    @Override
    public List<GetAllBrandsResponse> getAll() {

        List<Brand> brands = brandRepository.findAll();

        /** ESKI YÖNTEM

         List<GetAllBrandsResponse> brandResponse = new ArrayList<GetAllBrandsResponse>();
         List<Brand> brands = brandRepository.findAll();
         for (Brand brand : brands) {
         GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
         responseItem.setId(brand.getId());
         responseItem.setName(brand.getName());

         brandResponse.add(responseItem);
         }

         */

        /** YENI YÖNTEM KISA AMA DAHA DA SADELESTIRILEBILIR
         List<GetAllBrandsResponse> brandResponse1 = brands
         .stream()
         .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
         */

        /**YENI YÖNTEM - KISA HALI
         List<GetAllBrandsResponse> brandResponse = brands
         .stream()
         .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
         return brandResponse;
         */

        //YENI YÖNTEM EN KISA HALI
        return brands.stream()
                .map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).toList();
    }

    @Override
    public GetByIdBrandResponse getById(int id) {

        Brand brand = this.brandRepository.findById(id).orElseThrow(); // Bulamazsan hata firlat

        /** Kisaktacagiz
         GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand,GetByIdBrandResponse.class);
         return response;
         */

        return this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
    }

    @Override
    public void add(CreateRequestBrand createRequestBrand) {

        this.brandBusinessRules.checkIfBrandNameExists(createRequestBrand.getBrandName());

        Brand brand = this.modelMapperService.forRequest().map(createRequestBrand, Brand.class); //Gelen kaynagi (source=request) --> Brand'e cevir

        //Model Mapper kullanmadan önce tüm nesneler bu sekilde manuel set ediliyordu. Kac tane field varsa.
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        //this.brandBusinessRules.checkIfBrandNameExists(updateBrandRequest.getName());

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brand.setId(0);
        this.brandRepository.save(brand); //Buradaki save'in add den farki id de oldugu icin insert degil update islemi yapar UpdateBrandRequest sayesinde
    }

    @Override
    public void delete(int id) {

        this.brandRepository.deleteById(id);

    }
}