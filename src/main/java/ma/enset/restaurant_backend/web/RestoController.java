package ma.enset.restaurant_backend.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import ma.enset.restaurant_backend.entities.Commande;
import ma.enset.restaurant_backend.entities.Plat;
import ma.enset.restaurant_backend.repositories.CategoryRepository;
import ma.enset.restaurant_backend.repositories.CommandeRepository;
import ma.enset.restaurant_backend.repositories.PlatRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data @AllArgsConstructor
public class RestoController {
    private PlatRepository platRepository;
    private CategoryRepository categoryRepository;
    private CommandeRepository commandeRepository;

    @GetMapping("/plats")
    public List<Plat> plats(){
        return platRepository.findAll();
    }
    @GetMapping("/commandes")
    public  List<Commande> commandes(){
        return commandeRepository.findAll();
    }
    @GetMapping("/plats/{categorie}")
    public List<Plat> platsList(@PathVariable String categorie){
        return platRepository.findPlatByCategorieName(categorie);
    }

    @PostMapping("/plat/new")
    public Plat newplat (@RequestBody Plat plat){
       Plat saveDplat =platRepository.save(plat);
        return  saveDplat;
    }

    @PostMapping("commande/new")
    public Commande newCommande(@RequestBody Commande commande){
        System.out.println(commande.getTotalPrice());
        Commande savcmd=commandeRepository.save(commande);
        return  savcmd;
    }
    @GetMapping("/commande/{id}")
    public boolean deleteCommande(@PathVariable Long id){
        commandeRepository.deleteById(id);
        return  true;
    }

}
