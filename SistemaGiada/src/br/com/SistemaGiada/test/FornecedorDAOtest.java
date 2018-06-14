package br.com.SistemaGiada.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.SistemaGiada.DAO.FornecedoresDAO;
import br.com.SistemaGiada.domain.Fornecedor;

public class FornecedorDAOtest {
	
	@Test
	@Ignore
	public void salvar() {
		Fornecedor f1 = new Fornecedor();
		f1.setDescricao("Descricao A");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.salvar(f1);
	}
	
	@Test
	public void listar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = fdao.listar();
		
		for(Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}
	
	
}
