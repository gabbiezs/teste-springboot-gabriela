package br.sc.senac.dw.testespringbootgabriela.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sc.senac.dw.testespringbootgabriela.exception.CampoInvalidoException;
import br.sc.senac.dw.testespringbootgabriela.model.entidade.Endereco;
import br.sc.senac.dw.testespringbootgabriela.service.EnderecoService;

@RestController
@RequestMapping(path = "/api/enderecos")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
//  anteriormente esse era o BO
	
	@GetMapping(path = "/todos")
	public List<Endereco> listarTodos() {
		
		return enderecoService.listarTodos();
		
	}
	@GetMapping("/detalhe/{id}")
	public Endereco pesquisarPorId (@PathVariable Integer id) {
		return enderecoService.consultarPorId(id.longValue());
		
	}
	@PostMapping
	public Endereco salvar(@RequestBody Endereco novoEndereco) throws CampoInvalidoException{
		return enderecoService.inserir(novoEndereco);
	}
	
	@PutMapping()
	public boolean atualizar(@RequestBody Endereco enderecoParaAtualizar) throws CampoInvalidoException{
		return enderecoService.atualizar(enderecoParaAtualizar) != null;
	}
	
	@DeleteMapping("/{id}")
	public boolean excluir(@PathVariable Integer id) {
		return enderecoService.excluir(id);
	}
	
}
