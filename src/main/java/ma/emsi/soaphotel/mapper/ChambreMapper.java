package ma.emsi.soaphotel.mapper;
import ma.emsi.soaphotel.dto.ChambreRequestDTO;
import ma.emsi.soaphotel.dto.ChambreResponseDTO;
import ma.emsi.soaphotel.entities.Chambre;
import ma.emsi.soaphotel.entities.TypeChambre;
import org.springframework.stereotype.Component;

@Component
public class ChambreMapper {

    public static ChambreResponseDTO toResponseDTO(Chambre chambre) {
        return ChambreResponseDTO.builder()
                .id(chambre.getId())
                .type(chambre.getType().toString())
                .prix(chambre.getPrix())
                .disponible(chambre.getDisponible())
                .build();
    }

    public static Chambre toEntity(ChambreRequestDTO dto) {
        return Chambre.builder()
                .id(dto.getId())
                .type(TypeChambre.valueOf(dto.getType()))
                .prix(dto.getPrix())
                .disponible(dto.getDisponible())
                .build();
    }
}

