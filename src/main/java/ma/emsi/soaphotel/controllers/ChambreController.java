package ma.emsi.soaphotel.controllers;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import ma.emsi.soaphotel.dto.ChambreRequestDTO;
import ma.emsi.soaphotel.dto.ChambreResponseDTO;
import ma.emsi.soaphotel.services.ChambreService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@WebService(name = "Chambrews")
@RequiredArgsConstructor
public class ChambreController {
    private final ChambreService chambreService;

    @WebMethod
    public ChambreResponseDTO findChambreById(@WebParam(name = "id") Long id) {
        return chambreService.findById(id).orElseThrow(() -> new RuntimeException("Chambre not found"));
    }

    @WebMethod
    public List<ChambreResponseDTO> findChambresByDisponibilite(@WebParam(name = "disponible") boolean disponible) {
        return chambreService.findByDisponibilite(disponible);
    }

    @WebMethod
    public ChambreResponseDTO createChambre(@WebParam(name = "chambre") ChambreRequestDTO chambre) {
        return chambreService.save(chambre).orElseThrow(() -> new RuntimeException("Error while creating chambre"));
    }

    @WebMethod
    public ChambreResponseDTO updateChambre(@WebParam(name = "id") Long id, @WebParam(name = "chambre") ChambreRequestDTO chambre) {
        return chambreService.update(chambre, id).orElseThrow(() -> new RuntimeException("Error while updating chambre"));
    }

    @WebMethod
    public ChambreResponseDTO deleteChambre(@WebParam(name = "id") Long id) {
        return chambreService.delete(id).orElseThrow(() -> new RuntimeException("Error while deleting chambre"));
    }
    @WebMethod
    public List<ChambreResponseDTO> findAllChambres() {
        return chambreService.findAll();
    }


}
