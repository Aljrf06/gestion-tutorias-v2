package co.edu.gestiontutoriasmongo.controller;

import co.edu.gestiontutoriasmongo.DTO.LoginDTO;
import co.edu.gestiontutoriasmongo.DTO.RegistroUsuarioDTO;
import co.edu.gestiontutoriasmongo.DTO.UsuarioRespuestaDTO;
import co.edu.gestiontutoriasmongo.config.JwtUtil;
import co.edu.gestiontutoriasmongo.model.Usuario;
import co.edu.gestiontutoriasmongo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping("/registrar")
    public ResponseEntity<UsuarioRespuestaDTO> registrarUsuario(@RequestBody RegistroUsuarioDTO request) {
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPasswordHash(request.getPassword());
        usuario.setTipo(request.getTipo());

        Usuario nuevo = usuarioService.registrarUsuario(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(
                new UsuarioRespuestaDTO(
                        nuevo.getId(),
                        nuevo.getNombre(),
                        nuevo.getApellido(),
                        nuevo.getEmail(),
                        nuevo.getTipo(),
                        null
                )
        );
    }


    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioRespuestaDTO>> listarUsuario() {
        List<UsuarioRespuestaDTO> respuesta = usuarioService.listarUsuario().stream()
                .map(u -> new UsuarioRespuestaDTO(
                        u.getId(),
                        u.getNombre(),
                        u.getApellido(),
                        u.getEmail(),
                        u.getTipo(),
                        null
                ))
                .toList();
        return ResponseEntity.ok(respuesta);
    }


    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioRespuestaDTO> actualizar(
            @PathVariable String id,
            @RequestBody RegistroUsuarioDTO request) {

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setEmail(request.getEmail());
        usuario.setPasswordHash(request.getPassword());
        usuario.setTipo(request.getTipo());

        Usuario actualizado = usuarioService.actualizar(id, usuario);

        return ResponseEntity.ok(
                new UsuarioRespuestaDTO(
                        actualizado.getId(),
                        actualizado.getNombre(),
                        actualizado.getApellido(),
                        actualizado.getEmail(),
                        actualizado.getTipo(),
                        null
                )
        );
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/login")
    public ResponseEntity<UsuarioRespuestaDTO> login(@RequestBody LoginDTO request) {
        Usuario usuario = usuarioService.ingresar(request.getEmail(), request.getPassword());

        String token = jwtUtil.generarToken(
                usuario.getEmail(),
                usuario.getTipo().name(),
                usuario.getId()
        );

        return ResponseEntity.ok(
                new UsuarioRespuestaDTO(
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getApellido(),
                        usuario.getEmail(),
                        usuario.getTipo(),
                        token
                )
        );
    }
}
