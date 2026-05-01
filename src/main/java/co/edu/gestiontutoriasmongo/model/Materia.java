package co.edu.gestiontutoriasmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Document(collection= "materias")
public class Materia {

    @Id
    private String id;
    private String nombre;
    private String descripcion;

}
