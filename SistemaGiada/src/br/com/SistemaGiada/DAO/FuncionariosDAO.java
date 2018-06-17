package br.com.SistemaGiada.DAO;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import br.com.SistemaGiada.domain.Funcionario;
import br.com.SistemaGiada.util.HibernateUtil;

public class FuncionariosDAO {
	public void salvar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();// iniciando a sessao conexao criada exemplo
																			// fabrica..

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();// abrindo a transacao
			sessao.save(funcionario);// salvando os dados
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação

			}
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked") // se n encontrar nada
	public List<Funcionario> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Funcionario> funcionario = null;
		try {

			Query consulta = sessao.getNamedQuery("Funcionario.listar");
			funcionario = consulta.list();

		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return funcionario;
	}

	public Funcionario buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Funcionario funcionario = null;
		try {

			Query consulta = sessao.getNamedQuery("Funcionario.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			funcionario = (Funcionario) consulta.uniqueResult();// buscar por valor unico

		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return funcionario;
	}

	public void excluir(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();// abrindo a transacao
			sessao.delete(funcionario);
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação

			}
		} finally {
			sessao.close();
		}

	}

	/*
	 * public void excluir(Long codigo) { Session sessao =
	 * HibernateUtil.getSessionFactory().openSession();
	 * 
	 * Transaction transacao = null; try { transacao = sessao.beginTransaction();//
	 * abrindo a transacao Funcionario funcionario = buscarPorCodigo(codigo);
	 * sessao.delete(funcionario); transacao.commit(); // confirmando a transação
	 * 
	 * } catch (RuntimeException e) { if (transacao != null) { transacao.rollback();
	 * // desfaz a transação
	 * 
	 * } } finally { sessao.close(); }
	 * 
	 * }
	 */
	

	public void editar(Funcionario funcionario) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			Funcionario funcionarioEditar = buscarPorCodigo(funcionario.getCodigo());
			funcionarioEditar.setNome(funcionario.getNome());
			funcionarioEditar.setCpf(funcionario.getCpf());
			funcionarioEditar.setSenha(funcionario.getSenha());
			funcionarioEditar.setFuncao(funcionario.getFuncao());
			sessao.update(funcionarioEditar);
			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação

			}
		} finally {
			sessao.close();
		}

	}
}
