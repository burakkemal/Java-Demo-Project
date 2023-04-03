package kodlama.io.RentACar.business.requests;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CreateModelRequest {
    @NotNull
    @NotBlank
    @Size(min = 3,max = 20)
    private String modelName;

    @NotNull
    @NotBlank
    private int brandId;
}
