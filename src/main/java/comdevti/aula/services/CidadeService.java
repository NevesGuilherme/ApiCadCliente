package comdevti.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comdevti.aula.model.Cidade;
import comdevti.aula.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	CidadeRepository rep;
	
	public Cidade incluir(Cidade c) {
		// Comando de insert que inclui a cidade no banco
		return rep.save(c);
	}
	
	public List<Cidade> listarTodas(){
	// Comando de SLECT que retorna as cidade do banco
	return rep.findAll();
	}
	
	public Cidade alterar(Cidade c) {
		return rep.save(c);
	}
	
	public void excluir(Integer id) {
		Cidade excluirCidade = rep.findById(id).get();
		if(excluirCidade !=null) {
			rep.delete(excluirCidade);
		}
	}
	
	public List<Cidade> buscarPorUf(String uf){
		return rep.findByUf(uf);
	}
	

}