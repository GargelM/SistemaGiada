package br.com.SistemaGiada.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaGiada.domain.Venda;
import br.com.SistemaGiada.util.HibernateUtil;

public class VendasDAO {
	public void salvar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(venda);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Venda> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Venda> venda = null;
		try {
			Query consulta = sessao.getNamedQuery("Venda.listar");
			venda = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return venda;
	}

	public Venda buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Venda venda = null;

		try {
			Query consulta = sessao.getNamedQuery("Venda.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			venda = (Venda) consulta.uniqueResult();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}

		return venda;
	}

	public void excluir(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(venda);
			transacao.commit();
		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}

	public void editar(Venda venda) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();

		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.update(venda);
			transacao.commit();

		} catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
}
