package ma.enset.restaurant_backend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Plat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_plat;
    private String name;
    private String description;
    private String time;
    private double price;
    private  String image;
    private double rate;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne()
    Categorie categorie;
}
