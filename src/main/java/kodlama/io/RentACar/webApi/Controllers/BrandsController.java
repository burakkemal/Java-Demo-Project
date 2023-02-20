package kodlama.io.RentACar.webApi.Controllers;


import kodlama.io.RentACar.business.abstracts.BrandService;
import kodlama.io.RentACar.business.requests.CreateRequestBrand;
import kodlama.io.RentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.RentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll(){
        return this.brandService.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody() CreateRequestBrand createRequestBrand){
        brandService.add(createRequestBrand);
    }

    @DeleteMapping("/deleteById")
    public void delete(@RequestBody() int id){
        brandService.delete(id);
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getByIdBrandResponse(@PathVariable int id){
        return brandService.getById(id);
    }
}
