package ma.emsi.soaphotel.controllers;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import ma.emsi.soaphotel.dto.ClientRequestDTO;
import ma.emsi.soaphotel.dto.ClientResponseDTO;
import ma.emsi.soaphotel.services.ClientService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@WebService(name = "Clientws")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    // Query to fetch all clients
    @WebMethod
    public List<ClientResponseDTO> findAllClients() {
        return clientService.findAll();
    }

    // Query to fetch a client by ID
    @WebMethod
    public ClientResponseDTO findClientById(@WebParam(name = "id") Long id) {  // Added name for clarity
        return clientService.findById(id)
                .orElseThrow(() -> new RuntimeException("Client with ID " + id + " not found"));
    }

    // Query to search clients by a keyword in name or email
    @WebMethod
    public List<ClientResponseDTO> findClientsByKeyword(@WebParam(name = "keyword") String keyword) {  // Added name for clarity
        return clientService.findByEmailOrName(keyword);
    }

    // Mutation to create a new client
    @WebMethod
    public ClientResponseDTO createClient(@WebParam(name = "client") ClientRequestDTO client) {  // Added name for clarity
        return clientService.save(client)
                .orElseThrow(() -> new RuntimeException("Error while creating client"));
    }

    // Mutation to update an existing client
    @WebMethod
    public ClientResponseDTO updateClient(@WebParam(name = "id") Long id, @WebParam(name = "client") ClientRequestDTO client) {  // Added name for clarity
        return clientService.update(client, id)
                .orElseThrow(() -> new RuntimeException("Error while updating client"));
    }

    // Mutation to delete a client
    @WebMethod
    public ClientResponseDTO deleteClient(@WebParam(name = "id") Long id) {  // Added name for clarity
        return clientService.delete(id)
                .orElseThrow(() -> new RuntimeException("Error while deleting client"));
    }
}
