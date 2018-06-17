package br.com.SistemaGiada.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.SistemaGiada.DAO.FornecedoresDAO;
import br.com.SistemaGiada.DAO.FuncionariosDAO;
import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.domain.Funcionario;

public class FuncionarioDAOtest {
	@Test
	public void salvar() {
		Funcionario f1 = new Funcionario();
	
		f1.setNome("MGARGEL");
		f1.setCpf("111.111.111.10");
		f1.setSenha("123454");
		f1.setFuncao("SUBGERENTE");
		
		FuncionariosDAO fdao = new FuncionariosDAO();
		fdao.salvar(f1);
	}

	@Test
	@Ignore
	public void listar() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		List<Fornecedor> fornecedores = fdao.listar();

		for (Fornecedor fornecedor : fornecedores) {
			System.out.println(fornecedor);
		}
	}
	
	//nome,cpf,senha,funcao
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor f1 = fdao.buscarPorCodigo(2L);
		Fornecedor f2 = fdao.buscarPorCodigo(3L);
		Fornecedor f3 = fdao.buscarPorCodigo(5L);

		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);

	}

	@Test
	@Ignore
	public void excluir() {
		FornecedoresDAO fdao = new FornecedoresDAO();

		Fornecedor fornecedor = fdao.buscarPorCodigo(7L);

		fdao.excluir(fornecedor);

	}

	/*
	 * @Test
	 * 
	 * @Ignore public void excluirPorCodigo() { FornecedoresDAO fdao = new
	 * FornecedoresDAO(); fdao.excluir(4L); }
	 * 
	 */

	@Test
	@Ignore
	public void editar() {

		FornecedoresDAO fdao = new FornecedoresDAO();

		Fornecedor fornecedor = fdao.buscarPorCodigo(7L);
		fornecedor.setDescricao("TESTE");

		fdao.editar(fornecedor);
	}

}
