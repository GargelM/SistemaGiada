package br.com.SistemaGiada.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.util.HibernateUtil;

public class FornecedoresDAO {
	public void salvar(Fornecedor fornecedor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();//iniciando a sessao conexao criada exemplo fabrica..
		
		Transaction transacao = null;		
		try {
			transacao = sessao.beginTransaction();//abrindo a transacao
			sessao.save(fornecedor);//salvando os dados
			transacao.commit(); // confirmando a transação
									
		}catch (RuntimeException e) {
			if(transacao != null) {
				transacao.rollback(); //desfaz a transação
				sessao.close();
			}
		}finally {
			
		}

	}
	public List<Fornecedor>listar(){
		
	}
}
