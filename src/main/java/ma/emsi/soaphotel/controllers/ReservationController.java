package ma.emsi.soaphotel.controllers;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.RequiredArgsConstructor;
import ma.emsi.soaphotel.dto.ReservationRequestDTO;
import ma.emsi.soaphotel.dto.ReservationResponseDTO;
import ma.emsi.soaphotel.services.ReservationService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@WebService(name = "Reservationws")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    // Query to fetch all reservations
    @WebMethod
    public List<ReservationResponseDTO> findAllReservations() {
        return reservationService.findAll();
    }

    // Query to fetch a reservation by ID
    @WebMethod
    public ReservationResponseDTO findReservationById(@WebParam(name = "id") Long id) {
        return reservationService.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation with ID " + id + " not found"));
    }

    // Mutation to create a new reservation
    @WebMethod
    public ReservationResponseDTO createReservation(@WebParam(name = "reservation") ReservationRequestDTO reservation) {
        return reservationService.save(reservation)
                .orElseThrow(() -> new RuntimeException("Error while creating reservation"));
    }

    // Mutation to update an existing reservation
    @WebMethod
    public ReservationResponseDTO updateReservation(@WebParam(name = "id") Long id, @WebParam(name = "reservation") ReservationRequestDTO reservation) {
        return reservationService.update(reservation, id)
                .orElseThrow(() -> new RuntimeException("Error while updating reservation"));
    }

    // Mutation to delete a reservation
    @WebMethod
    public ReservationResponseDTO deleteReservation(@WebParam(name = "id") Long id) {
        return reservationService.delete(id)
                .orElseThrow(() -> new RuntimeException("Error while deleting reservation"));
    }
}
