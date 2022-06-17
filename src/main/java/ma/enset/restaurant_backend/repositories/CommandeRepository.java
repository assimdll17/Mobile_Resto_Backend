package ma.enset.restaurant_backend.repositories;

import ma.enset.restaurant_backend.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande,Long> {
}
