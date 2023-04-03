package kodlama.io.RentACar.business.rules;


import kodlama.io.RentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.RentACar.dataAccess.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRules {
    private BrandRepository brandRepository;
    public void checkIfBrandNameExists(String name){
        if (this.brandRepository.existsByBrandName(name)){
            throw new BusinessException("Brand already exists"); // Java exception types
        }
    }
}
