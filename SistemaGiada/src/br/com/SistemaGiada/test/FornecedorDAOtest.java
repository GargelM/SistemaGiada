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
		f1.setDescricao("Gargel");

		FornecedoresDAO fdao = new FornecedoresDAO();
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

		Fornecedor fornecedor = fdao.buscarPorCodigo(2L);

		if (fornecedor != null) {
			fdao.excluir(fornecedor);
		}
	}

	@Test
	public void excluirPorCodigo() {
		FornecedoresDAO fdao = new FornecedoresDAO();
		fdao.excluir(4L);
	}
}
