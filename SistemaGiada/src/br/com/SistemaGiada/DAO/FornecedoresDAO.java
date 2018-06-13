package br.com.SistemaGiada.DAO;

import org.hibernate.Session;

import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.util.HibernateUtil;

public class FornecedoresDAO {
	public void salvar(Fornecedor fornecedor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();//iniciando a sessao conexao criada exemplo fabrica..
		
		sessao.save(fornecedor);
		sessao.close();
	}
}
