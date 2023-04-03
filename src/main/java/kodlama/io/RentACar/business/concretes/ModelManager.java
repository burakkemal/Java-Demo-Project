package kodlama.io.RentACar.business.concretes;

import kodlama.io.RentACar.business.abstracts.ModelService;
import kodlama.io.RentACar.business.requests.CreateModelRequest;
import kodlama.io.RentACar.business.responses.GetAllModelsResponse;
import kodlama.io.RentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.RentACar.dataAccess.ModelRepository;
import kodlama.io.RentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models=modelRepository.findAll();
        List<GetAllModelsResponse>  modelsResponses= models.stream().map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelsResponses;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model=this.modelMapperService.forRequest().map(createModelRequest ,Model.class);
        this.modelRepository.save(model);
    }
}
