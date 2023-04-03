package kodlama.io.RentACar.business.requests;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateRequestBrand {
    @Size(min = 3, max = 20)
    private String brandName;
}
