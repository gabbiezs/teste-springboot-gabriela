package br.sc.senac.dw.testespringbootgabriela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sc.senac.dw.testespringbootgabriela.exception.CampoInvalidoException;
import br.sc.senac.dw.testespringbootgabriela.model.entidade.Endereco;
import br.sc.senac.dw.testespringbootgabriela.model.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
    private EnderecoRepository enderecoRepository;
	//Repository serve como o antigo DAO do semestre passado

	@Transactional
	public List<Endereco> listarTodos() {
		return enderecoRepository.findAll();
	}

	public Endereco consultarPorId(Long id) {
		return enderecoRepository.findById(id.longValue()).get();
	}

	public Endereco inserir(Endereco novoEndereco) throws CampoInvalidoException {
		return enderecoRepository.save(novoEndereco);
	}
	
	public Endereco atualizar(Endereco enderecoParaAtualizar) throws CampoInvalidoException {
		return enderecoRepository.save(enderecoParaAtualizar);
	}
	
	public boolean excluir(Integer id) {
		enderecoRepository.deleteById(id.longValue());
		return true;
	}
}
