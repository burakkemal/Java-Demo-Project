package kodlama.io.RentACar.dataAccess;

import kodlama.io.RentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByBrandName(String name);
}
