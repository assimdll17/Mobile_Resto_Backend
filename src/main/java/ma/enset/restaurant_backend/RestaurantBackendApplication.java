package ma.enset.restaurant_backend;

import ma.enset.restaurant_backend.entities.Categorie;
import ma.enset.restaurant_backend.entities.Commande;
import ma.enset.restaurant_backend.entities.Plat;
import ma.enset.restaurant_backend.repositories.CategoryRepository;
import ma.enset.restaurant_backend.repositories.CommandeRepository;
import ma.enset.restaurant_backend.repositories.PlatRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class RestaurantBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestaurantBackendApplication.class, args);
    }

    //@Bean
    CommandLineRunner commandLineRunner(PlatRepository platRepository, CommandeRepository commandeRepository, CategoryRepository categoryRepository){
            return  args -> {
                Stream.of("Tacos","Burger","Pizza").forEach(
                        cat->{
                            Categorie categorie=new Categorie();
                            categorie.setName(cat);
                            categoryRepository.save(categorie);
                        }
                );

                categoryRepository.findAll().forEach(
                        (categorie -> {
                            for(int i=0;i<5;i++){
                                Plat plat=new Plat();
                                plat.setPrice(Math.random()*50);
                                plat.setName(Math.random()>0.5? "beef "+ categorie.getName():"chicken "+categorie.getName());
                                plat.setTime("5-10Min");
                                plat.setCategorie(categorie);
                                plat.setDescription(categorie.getName());
                                platRepository.save(plat);
                            }
                        })
                );
                Categorie categorie=new Categorie();
                categorie.setName("Boisson");
                categoryRepository.save(categorie);
                for(int i=0;i<5;i++){
                    Plat plat=new Plat();
                    plat.setPrice(Math.random()*30);
                    plat.setName(Math.random()>0.5? "coca-cola":"hawai");
                    plat.setTime("5-10Min");
                    plat.setCategorie(categorie);
                    plat.setDescription("Boisson");
                    platRepository.save(plat);
                }

                Commande commande=new Commande();
                commande.setQuantity(2);
                commande.setCustomerName("Hassan");
                commande.setCustomerAddress("Ryad Salam Bloc C R129");
                commandeRepository.save(commande);

                Commande commande1=new Commande();
                commande1.setQuantity(5);
                commande1.setCustomerName("Kamal");
                commande1.setCustomerAddress("Ryad Salam Bloc C R129");
                commandeRepository.save(commande1);


            };
    }

}
