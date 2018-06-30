package br.com.SistemaGiada.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.SistemaGiada.DAO.FuncionariosDAO;
import br.com.SistemaGiada.DAO.VendasDAO;
import br.com.SistemaGiada.domain.Funcionario;
import br.com.SistemaGiada.domain.Venda;

public class VendaDAOtest {
	@Test
	@Ignore
	public void salvar() {

		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(1L);

		Venda v1 = new Venda();

		v1.setHorario(new Date());
		v1.setValor_total(new BigDecimal(930.99D));
		v1.setFuncionario(funcionario);

		VendasDAO vdao = new VendasDAO();
		vdao.salvar(v1);
	}

	@Test
	@Ignore
	public void listar() {
		VendasDAO vdao = new VendasDAO();
		List<Venda> venda = vdao.listar();

		System.out.println(venda);

	}

	@Test
	@Ignore
	public void buscarPorCodigo() {
		VendasDAO vdao = new VendasDAO();
		Venda v1 = vdao.buscarPorCodigo(1L);
		Venda v2 = vdao.buscarPorCodigo(2L);
		Venda v3 = vdao.buscarPorCodigo(3L);

		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);

	}

	@Test
	@Ignore
	public void excluir() {
		VendasDAO vdao = new VendasDAO();

		Venda venda = vdao.buscarPorCodigo(4L);

		vdao.excluir(venda);

	}

	@Test
	@Ignore
	public void editar() {

		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario funcionario = fdao.buscarPorCodigo(3L);

		VendasDAO vdao = new VendasDAO();
		Venda venda = vdao.buscarPorCodigo(2L);
		venda.setHorario(new Date());
		;
		venda.setValor_total(new BigDecimal(1.99D));
		venda.setFuncionario(funcionario);
		;

		vdao.editar(venda);
	}

}
