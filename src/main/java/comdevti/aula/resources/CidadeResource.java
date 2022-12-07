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
import comdevti.aula.services.CidadeService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;

	@PostMapping
	@ApiOperation(value = "Incluir uma cidade na base de dados")
	public Cidade inserirCidade(@RequestBody Cidade C) {
		return service.incluir(C);
	}
	
	@GetMapping
	@ApiOperation(value = "Listar as cidades da cadastradas na base da dados")
	public List<Cidade> listarTodas(){
		return service.listarTodas();
	}
	
	@PutMapping
	@ApiOperation(value = "Editar informação da cidade selecionada pelo ID")
	public Cidade alterar(@RequestBody Cidade c, @RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Deleta uma cidade da base da dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}
	
	
	@GetMapping("buscar/{uf}")
	@ApiOperation(value = "Busca uma cidade na base de dados utilizadno o UF")
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf){
		return service.buscarPorUf(uf);
	}
}
