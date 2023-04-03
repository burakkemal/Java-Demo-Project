package kodlama.io.RentACar.business.responses;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GetAllModelsResponse {
    private int id;
    private String modelName;
    private String brandName;
}
