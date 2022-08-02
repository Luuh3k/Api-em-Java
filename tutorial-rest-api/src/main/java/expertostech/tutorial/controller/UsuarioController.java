package expertostech.tutorial.controller;

import expertostech.tutorial.model.UsuarioModel;
import expertostech.tutorial.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping (path = "/api/usuario")
    public ResponseEntity<?> verTodos (){
        return ResponseEntity.ok().body(repository.findAll());
    }

    @GetMapping (path = "/api/usuario/{codigo}")
    public ResponseEntity consultar (@PathVariable ("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/usuario/salvar")
    public UsuarioModel criar (@RequestBody UsuarioModel usuario) {
        return repository.save(usuario);
    }

    @PutMapping(path = "/api/usuario/atualizar/{codigo}")
    public UsuarioModel atualizar (@PathVariable ("codigo") Integer codigo, @RequestBody UsuarioModel usuario) {
        Optional<UsuarioModel> usuarioAtualizado = repository.findById(codigo);
        UsuarioModel novoUsuario = usuarioAtualizado.get();
        novoUsuario.setCodigo(usuario.getCodigo());
        novoUsuario.setNome(usuario.getNome());
        novoUsuario.setSenha(usuario.getSenha());
        novoUsuario.setLogin(usuario.getLogin());
        return repository.save(novoUsuario);
    }

    @DeleteMapping (path = "/api/usuario/{codigo}")
    public ResponseEntity<?> deletar (@PathVariable ("codigo") Integer codigo) {
        repository.deleteById(codigo);
        return ResponseEntity.ok().body("Sumiu");
    }
}
