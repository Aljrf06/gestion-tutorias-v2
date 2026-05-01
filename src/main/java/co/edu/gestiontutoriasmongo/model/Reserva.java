package co.edu.gestiontutoriasmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "reservas")
public class Reserva {

    @Id
    private String id;

    private String estudianteId;
    private String franjaHorariaId;

    private EstadoReserva estado;

    private LocalDateTime fechaReserva;
    private LocalDateTime fechaCancelacion;
    private String motivoCancelacion;
}
