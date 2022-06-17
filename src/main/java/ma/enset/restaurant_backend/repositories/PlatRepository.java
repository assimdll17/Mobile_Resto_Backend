package ma.enset.restaurant_backend.repositories;

import ma.enset.restaurant_backend.entities.Plat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlatRepository extends JpaRepository<Plat,Long> {
    List<Plat> findPlatByCategorieName(String categorie);
}
