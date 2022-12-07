package comdevti.aula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import comdevti.aula.model.Cidade;
import comdevti.aula.model.Cliente;
import comdevti.aula.services.ClienteService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	
	@Autowired
	ClienteService service;
	
	@GetMapping
	@ApiOperation(value = "Lista os clientes cadastrados na base de dados")
	public List<Cliente> listar(){
		return service.listar();
	}
	
	@GetMapping("/buscarPorCidade/{cidade}")
	@ApiOperation(value = "Busca cliente por cidade")
	public List<Cliente> buscarPorCidade(@PathVariable("cidade") Cidade C){
		return service.BuscarPorCidade(C);
	}
	
	@PostMapping
	@ApiOperation(value = "Incluir cliente na base de dados")
	public Cliente inserirCliente(@RequestBody Cliente C) {
		return service.incluir(C);
	}
	
	@PutMapping
	@ApiOperation(value = "Altera dados do cliente utilizando o ID para selecionar")
	public Cliente alterar(@RequestBody Cliente c, @RequestParam("id")int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Deleta o cliente da base de dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluirCliente(id);
	}

}
