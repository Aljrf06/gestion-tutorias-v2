package co.edu.gestiontutoriasmongo.DTO;

import co.edu.gestiontutoriasmongo.model.TipoUsuario;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRespuestaDTO {
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private TipoUsuario tipo;
    private String token;
}
