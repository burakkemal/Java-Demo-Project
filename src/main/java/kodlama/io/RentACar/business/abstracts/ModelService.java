package kodlama.io.RentACar.business.abstracts;


import kodlama.io.RentACar.business.requests.CreateModelRequest;
import kodlama.io.RentACar.business.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
