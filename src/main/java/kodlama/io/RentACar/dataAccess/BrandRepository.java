package kodlama.io.RentACar.dataAccess;

import kodlama.io.RentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {

}
