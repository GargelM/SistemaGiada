package br.com.SistemaGiada.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.SistemaGiada.DAO.ItensDAO;
import br.com.SistemaGiada.DAO.ProdutosDAO;
import br.com.SistemaGiada.DAO.VendasDAO;
import br.com.SistemaGiada.domain.Item;
import br.com.SistemaGiada.domain.Produto;
import br.com.SistemaGiada.domain.Venda;

public class ItemDAOtest {
	@Test
	@Ignore
	public void salvar() {

		ProdutosDAO pdao = new ProdutosDAO();
		Produto produto = pdao.buscarPorCodigo(1L);

		VendasDAO vdao = new VendasDAO();
		Venda venda = vdao.buscarPorCodigo(3L);

		Item i1 = new Item();

		i1.setQuantidade(19);
		i1.setValor_parcial(new BigDecimal(12.99D));
		i1.setProduto(produto);
		i1.setVenda(venda);

		ItensDAO idao = new ItensDAO();
		idao.salvar(i1);
	}

	@Test
	@Ignore
	public void listar() {
		ItensDAO idao = new ItensDAO();
		List<Item> items = idao.listar();

		System.out.println(items);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		ItensDAO idao = new ItensDAO();
		Item i1 = idao.buscarPorCodigo(1L);
		Item i2 = idao.buscarPorCodigo(3L);
		Item i3 = idao.buscarPorCodigo(4L);

		System.out.println(i1);
		System.out.println(i2);
		System.out.println(i3);

	}

	@Test
	@Ignore
	public void excluir() {
		ItensDAO idao = new ItensDAO();

		Item item = idao.buscarPorCodigo(2L);

		idao.excluir(item);

	}

	@Test
	@Ignore
	public void editar() {

		ProdutosDAO pdao = new ProdutosDAO();
		Produto produto = pdao.buscarPorCodigo(4L);

		VendasDAO vdao = new VendasDAO();
		Venda venda = vdao.buscarPorCodigo(2L);

		ItensDAO idao = new ItensDAO();
		Item item = idao.buscarPorCodigo(4L);
		item.setQuantidade(90);
		item.setValor_parcial(new BigDecimal(80.99D));
		item.setProduto(produto);
		item.setVenda(venda);

		idao.editar(item);
	}
}
