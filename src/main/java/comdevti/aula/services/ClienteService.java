package comdevti.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comdevti.aula.model.Cidade;
import comdevti.aula.model.Cliente;
import comdevti.aula.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository rep;
	
	public List<Cliente> listar(){
		return rep.findAll();
	}
	
	public List<Cliente> BuscarPorCidade(Cidade c){
		return rep.findByCidade(c);
	}
	
	public void excluirCliente(Integer id) {
		Cliente excluirCliente = rep.findById(id).get();
		if(excluirCliente != null) {
			rep.delete(excluirCliente);
		}
	}
	
	public Cliente incluir(Cliente c) {
		return rep.save(c);
	}
	
	public Cliente alterar(Cliente c) {
		return rep.save(c);
	}
	
	
}
