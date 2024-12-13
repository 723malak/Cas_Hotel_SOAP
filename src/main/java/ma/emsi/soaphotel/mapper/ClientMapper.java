package ma.emsi.soaphotel.mapper;

import ma.emsi.soaphotel.dto.ClientRequestDTO;
import ma.emsi.soaphotel.dto.ClientResponseDTO;
import ma.emsi.soaphotel.entities.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public static ClientResponseDTO toResponseDTO(Client client) {
        return ClientResponseDTO.builder()
                .id(client.getId())
                .nom(client.getNom())
                .email(client.getEmail())
                .tel(client.getTel())
                .build();
    }

    public static Client toEntity(ClientRequestDTO dto) {
        return Client.builder()
                .nom(dto.getNom())
                .email(dto.getEmail())
                .tel(dto.getTel())
                .build();
    }
}
