//fazer comunica√ßao parte web com banco de dados. java vx xhtml
package br.com.SistemaGiada.Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaGiada.DAO.FornecedoresDAO;
import br.com.SistemaGiada.domain.Fornecedor;
import br.com.SistemaGiada.util.JSFUtil;

@ManagedBean(name = "MBFornecedores") // uma forma de passar referencia usara para chamar em vez de chamar
										// fornecedoresbean
@ViewScoped
public class FornecedoresBean {

	private Fornecedor fornecedores;
	private ArrayList<Fornecedor> itens;
	private ArrayList<Fornecedor> itensFiltrados;
	private String acao;
	
	

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Fornecedor getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(Fornecedor fornecedores) {
		this.fornecedores = fornecedores;
	}

	public ArrayList<Fornecedor> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fornecedor> itens) {
		this.itens = itens;
	}

	public ArrayList<Fornecedor> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fornecedor> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// ira construir o q esta abaixo assim q a pagina for iniciada
	// @PostConstruct
	public void prepararPesquisa() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			itens = (ArrayList<Fornecedor>) fdao.listar();

		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void carregarCadastro() {
		try {
			
			acao = JSFUtil.getParam("foracao");
			
			String valor = JSFUtil.getParam("forcod");
			if (valor != null) {
				Long codigo = Long.parseLong(valor);
				FornecedoresDAO fdao = new FornecedoresDAO();

				fornecedores = fdao.buscarPorCodigo(codigo);
			}else {
				fornecedores = new Fornecedor();
			}

		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void novo() {
		fornecedores = new Fornecedor();
	}

	public void salvar() {

		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.salvar(fornecedores);

			fornecedores = new Fornecedor();
			// itens = (ArrayList<Fornecedor>) fdao.listar();//atualizar a pagina

			JSFUtil.adicionarMensagemSucesso("Salvo com sucesso");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.excluir(fornecedores);

			JSFUtil.adicionarMensagemSucesso("Fornecedor excluido com sucesso");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("N„o foi possivel excluir um fornecedor que tenha um produto associado!");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			FornecedoresDAO fdao = new FornecedoresDAO();
			fdao.editar(fornecedores);

			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso");
		} catch (RuntimeException e) {
			// TODO: handle exception
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
}
