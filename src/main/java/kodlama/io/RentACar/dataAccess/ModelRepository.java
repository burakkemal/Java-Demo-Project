package kodlama.io.RentACar.dataAccess;

import kodlama.io.RentACar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {

}
