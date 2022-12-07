package comdevti.aula.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import comdevti.aula.model.Cidade;
import comdevti.aula.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	public List<Cliente> findByCidade(Cidade cidade);
	
}
