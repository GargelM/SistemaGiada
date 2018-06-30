package br.com.SistemaGiada.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.SistemaGiada.DAO.FornecedoresDAO;
import br.com.SistemaGiada.DAO.ProdutosDAO;
import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.domain.Produto;

public class ProdutoDAOtest {

	@Test
	@Ignore
	public void salvar() {

		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(5L);

		Produto p1 = new Produto();

		p1.setDescricao("Agua");
		p1.setQuantidade(129);
		p1.setValor(new BigDecimal(10.99D));
		p1.setFornecedor(fornecedor);

		ProdutosDAO pdao = new ProdutosDAO();
		pdao.salvar(p1);
	}

	@Test
	@Ignore
	public void listar() {
		ProdutosDAO pdao = new ProdutosDAO();
		List<Produto> produtos = pdao.listar();

		System.out.println(produtos);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ProdutosDAO pdao = new ProdutosDAO();
		Produto f1 = pdao.buscarPorCodigo(2L);
		Produto f2 = pdao.buscarPorCodigo(3L);
		Produto f3 = pdao.buscarPorCodigo(1L);

		System.out.println(f1);
		System.out.println(f2);
		System.out.println(f3);

	}

	@Test
	@Ignore
	public void excluir() {
		ProdutosDAO pdao = new ProdutosDAO();

		Produto produto = pdao.buscarPorCodigo(2L);

		pdao.excluir(produto);

	}

	@Test
	@Ignore
	public void editar() {

		FornecedoresDAO fdao = new FornecedoresDAO();
		Fornecedor fornecedor = fdao.buscarPorCodigo(5L);

		ProdutosDAO pdao = new ProdutosDAO();
		Produto produto = pdao.buscarPorCodigo(1L);
		produto.setDescricao("teste1");
		produto.setQuantidade(690);
		produto.setValor(new BigDecimal(80.99D));
		produto.setFornecedor(fornecedor);

		pdao.editar(produto);
	}

}
