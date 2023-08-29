package br.sc.senac.dw.testespringbootgabriela.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.sc.senac.dw.testespringbootgabriela.model.entidade.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
