package ma.emsi.soaphotel.config;

import jakarta.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;

import ma.emsi.soaphotel.controllers.ChambreController;
import ma.emsi.soaphotel.controllers.ClientController;
import ma.emsi.soaphotel.controllers.ReservationController;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SoapConfig {

    private final Bus bus;
    private final ChambreController chambreController;
    private final ClientController clientController;
    private final ReservationController reservationController;
    @Bean
    public Endpoint endpointChambre() {
        EndpointImpl endpoint = new EndpointImpl(bus, chambreController);
        endpoint.publish("/Chambrews");
        return endpoint;
    }

    @Bean
    public Endpoint endpointClient() {
        EndpointImpl endpoint = new EndpointImpl(bus, clientController);
        endpoint.publish("/Clientws");
        return endpoint;
    }
    @Bean
    public Endpoint endpointResevation() {
        EndpointImpl endpoint = new EndpointImpl(bus, reservationController);
        endpoint.publish("/Reservationws");
        return endpoint;
    }
}
