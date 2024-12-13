package ma.emsi.soaphotel;

import lombok.RequiredArgsConstructor;
import ma.emsi.soaphotel.dto.ChambreRequestDTO;
import ma.emsi.soaphotel.dto.ClientRequestDTO;
import ma.emsi.soaphotel.dto.ReservationRequestDTO;
import ma.emsi.soaphotel.services.ChambreService;
import ma.emsi.soaphotel.services.ClientService;
import ma.emsi.soaphotel.services.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class SoapHotelMainApp {

    public static void main(String[] args) {
        SpringApplication.run(SoapHotelMainApp.class, args);
    }

    private final ClientService clientService;
    private final ChambreService chambreService;
    private final ReservationService reservationService;
    @Bean
    public CommandLineRunner run() {
        return args -> {
            // Insérer des clients marocains exemples
            clientService.save(new ClientRequestDTO("Fatima Zahra El Mansouri", "fatima.elmansouri@example.ma", "0678451234"));
            clientService.save(new ClientRequestDTO("Ahmed Bakkali", "ahmed.bakkali@example.ma", "0654127890"));
            clientService.save(new ClientRequestDTO("Samir Belkadi", "samir.belkadi@example.ma", "0632174568"));
            System.out.println("Clients  insérés avec succès.");

            // Insérer des chambres exemples
            chambreService.save(new ChambreRequestDTO(1L, "SIMPLE", 250.0, true));
            chambreService.save(new ChambreRequestDTO(2L, "DOUBLE", 150.0, false));
            chambreService.save(new ChambreRequestDTO(3L, "SIMPLE", 100.0, true));
            chambreService.save(new ChambreRequestDTO(4L, "SIMPLE", 300.0, true));
            chambreService.save(new ChambreRequestDTO(5L, "DOUBLE", 180.0, false));
            System.out.println("Chambres  insérées avec succès.");

            // Insérer des réservations exemples
            reservationService.save(new ReservationRequestDTO(1L, 3L, "2024-12-10", "2024-12-15", "Vacances d'hiver"));
            reservationService.save(new ReservationRequestDTO(2L, 1L, "2024-12-20", "2024-12-25", "Réunion d'affaires"));
            reservationService.save(new ReservationRequestDTO(3L, 4L, "2025-01-05", "2025-01-10", "Lune de miel"));
            System.out.println("Réservations insérées avec succès.");
        };
    }

}