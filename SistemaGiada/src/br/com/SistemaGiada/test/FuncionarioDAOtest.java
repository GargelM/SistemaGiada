package br.com.SistemaGiada.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.SistemaGiada.DAO.FuncionariosDAO;
import br.com.SistemaGiada.domain.Funcionario;

public class FuncionarioDAOtest {
	@Test
	@Ignore
	public void salvar() {
		Funcionario f1 = new Funcionario();
	
		f1.setNome("MGARGEL");
		f1.setCpf("111.111.111.00");
		f1.setSenha("123454");
		f1.setFuncao("SUBGERENTE");
		
		FuncionariosDAO fdao = new FuncionariosDAO();
		fdao.salvar(f1);
	}

	@Test
	@Ignore
	public void listar() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		List<Funcionario> funcionarios = fdao.listar();

		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}
	
	//nome,cpf,senha,funcao
	
	@Test
	@Ignore
	public void buscarPorCodigo() {
		FuncionariosDAO fdao = new FuncionariosDAO();
		Funcionario f1 = fdao.buscarPorCodigo(1L);
		//Funcionario f2 = fdao.buscarPorCodigo(3L);
		//Funcionario f3 = fdao.buscarPorCodigo(5L);

		System.out.println(f1);
		//System.out.println(f2);
		//System.out.println(f3);

	}

	@Test
	@Ignore
	public void excluir() {
		FuncionariosDAO fdao = new FuncionariosDAO();

		Funcionario funcionario = fdao.buscarPorCodigo(4L);

		fdao.excluir(funcionario);

	}

	/*
	 * @Test
	 * 
	 * @Ignore public void excluirPorCodigo() { FuncionarioDAO fdao = new
	 * FuncionarioDAO(); fdao.excluir(4L); }
	 * 
	 */

	@Test
	@Ignore
	public void editar() {

		FuncionariosDAO fdao = new FuncionariosDAO();		

		Funcionario funcionario = fdao.buscarPorCodigo(3L);
		funcionario.setNome("MICHEL");

		fdao.editar(funcionario);
	}

}
