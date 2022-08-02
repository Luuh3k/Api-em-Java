package expertostech.tutorial.repository;

import expertostech.tutorial.model.UsuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository <UsuarioModel, Integer> {

}
