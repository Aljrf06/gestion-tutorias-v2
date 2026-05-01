package co.edu.gestiontutoriasmongo.repository;

import co.edu.gestiontutoriasmongo.model.TipoUsuario;
import co.edu.gestiontutoriasmongo.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Usuario> findByTipo(TipoUsuario tipo);
}