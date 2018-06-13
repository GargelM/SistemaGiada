package br.com.SistemaGiada.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.util.HibernateUtil;

public class FornecedoresDAO {
	public void salvar(Fornecedor fornecedor) throws Exception{
		Session sessao = HibernateUtil.getSessionFactory().openSession();//iniciando a sessao conexao criada exemplo fabrica..
		
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();//abrindo a transacao
			transacao.commit(); // confirmando a transação
			
			sessao.save(fornecedor);//salvando os dados
			
		}catch (Exception e) {
			if(transacao != null) {
				transacao.rollback(); //desfaz a transação
				sessao.close();
			}
			
			throw e;
		}finally {
			
		}

	}
}
