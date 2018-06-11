package br.com.SistemaGiada.test;

import org.junit.Test;

import br.com.SistemaGiada.util.HibernateUtil;

public class GerarTabelasTest {

	
	@Test
	public void gerar() {
		
		
		HibernateUtil.getSessionFactory();
		HibernateUtil.getSessionFactory().close();

	}
	
}
