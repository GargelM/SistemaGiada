package br.com.SistemaGiada.test;

import org.junit.Test;

import br.com.SistemaGiada.DAO.FornecedoresDAO;
import br.com.SistemaGiada.domain.Fornecedor;

public class FornecedorDAOtest {
	
	@Test
	public void salvar() {
		Fornecedor f1 = new Fornecedor();
		f1.setDescricao("Descricao A");
		
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.salvar(f1);
	}
	
}
