package ma.emsi.soaphotel.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreRequestDTO {
    private  Long id;          // ID de la chambre (facultatif pour la création)
    private String type;      // Type de la chambre (exemple : DELUXE)
    private Double prix;      // Prix de la chambre
    private Boolean disponible; // Disponibilité
}


