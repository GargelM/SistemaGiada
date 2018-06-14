package br.com.SistemaGiada.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.util.HibernateUtil;

public class FornecedoresDAO {
	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();// iniciando a sessao conexao criada exemplo
																			// fabrica..

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();// abrindo a transacao
			sessao.save(fornecedor);// salvando os dados
			transacao.commit(); // confirmando a transação

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback(); // desfaz a transação

			}
		} finally {
			sessao.close();
		}

	}

	@SuppressWarnings("unchecked")//se n encontrar nada 
	public List<Fornecedor> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Fornecedor> fornecedores = null;
		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.listar");
			fornecedores = consulta.list();

		} catch (RuntimeException e) {
				throw e;
		} finally {
			sessao.close();
		}
		return fornecedores;
	}
	
	public Fornecedor buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Fornecedor fornecedor = null;
		try {

			Query consulta = sessao.getNamedQuery("Fornecedor.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			fornecedor = (Fornecedor) consulta.uniqueResult();//buscar por valor unico

		} catch (RuntimeException e) {
				throw e;
		} finally {
			sessao.close();
		}
		return fornecedor;
	}
}
