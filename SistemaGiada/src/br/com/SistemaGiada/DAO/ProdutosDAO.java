package br.com.SistemaGiada.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.domain.Funcionario;
import br.com.SistemaGiada.domain.Produto;
import br.com.SistemaGiada.util.HibernateUtil;

public class ProdutosDAO {
	public void salvar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = null;

		try {
			transacao = sessao.beginTransaction();
			sessao.save(produto);
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
	public List<Produto> listar() {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		List<Produto> produto = null;
		try {
			Query consulta = sessao.getNamedQuery("Produto.listar");
			produto = consulta.list();
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		return produto;
	}
	
	public Produto buscarPorCodigo(Long codigo) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Produto produto = null;
		
		try {
			Query consulta = sessao.getNamedQuery("Produto.buscarPorCodigo");
			consulta.setLong("codigo", codigo);
			produto = (Produto) consulta.uniqueResult();
		}catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
		
		return produto;
	}
	
	public void excluir(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(produto);
			transacao.commit();
		}catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
	public void editar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(produto);
			transacao.commit();
			
		}catch (RuntimeException e) {
			if (transacao != null) {
				transacao.rollback();
			}
		} finally {
			sessao.close();
		}
	}
}

/*
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 */