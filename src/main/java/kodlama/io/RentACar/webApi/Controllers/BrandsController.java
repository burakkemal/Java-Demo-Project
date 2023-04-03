package kodlama.io.RentACar.webApi.Controllers;


import jakarta.validation.Valid;
import kodlama.io.RentACar.business.abstracts.BrandService;
import kodlama.io.RentACar.business.requests.CreateRequestBrand;
import kodlama.io.RentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.RentACar.business.responses.GetByIdBrandResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/brands")
public class BrandsController {

    private final BrandService brandService;

    @GetMapping("/getAll")
    public List<GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateRequestBrand createRequestBrand){
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
