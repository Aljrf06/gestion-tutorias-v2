package co.edu.gestiontutoriasmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(collection = "franjas_horarias")
public class FranjaHoraria {

    @Id
    private String id;
    private String tutorId;
    private String materiaId;

    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String descripcion;
    private EstadoFranja estado;
}