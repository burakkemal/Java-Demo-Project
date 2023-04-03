package kodlama.io.RentACar.webApi.Controllers;


import kodlama.io.RentACar.business.abstracts.ModelService;
import kodlama.io.RentACar.business.requests.CreateModelRequest;
import kodlama.io.RentACar.business.requests.CreateRequestBrand;
import kodlama.io.RentACar.business.responses.GetAllModelsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/models")
public class ModelsController {
    private final ModelService modelService;


    @GetMapping()
    public List<GetAllModelsResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody() CreateModelRequest createModelRequest){
        modelService.add(createModelRequest);
    }
}
