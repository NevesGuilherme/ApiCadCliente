package comdevti.aula.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import comdevti.aula.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
	
	public List<Cidade> findByUf(String uf);

}
