package kodlama.io.RentACar.business.responses;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class GetAllBrandsResponse {
    private int id;
    private String brandName;
}
