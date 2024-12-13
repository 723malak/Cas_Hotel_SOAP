package ma.emsi.soaphotel.repositories;

import ma.emsi.soaphotel.entities.Chambre;
import ma.emsi.soaphotel.entities.Client;
import ma.emsi.soaphotel.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByChambre(Chambre chambre);
    List<Reservation> findByClient(Client chambre);

}
