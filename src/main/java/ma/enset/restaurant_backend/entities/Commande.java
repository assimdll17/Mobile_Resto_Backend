package ma.enset.restaurant_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Commande {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cmd;
    private int quantity;
    private String customerName;
    private String customerAddress;
    private double TotalPrice;
    private  String nomplat;
    private  double prixplat;



}
