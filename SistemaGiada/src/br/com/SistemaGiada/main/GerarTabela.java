package br.com.SistemaGiada.main;

import br.com.SistemaGiada.util.HibernateUtil;

public class GerarTabela {

	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}

}
