package br.com.SistemaGiada.Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.SistemaGiada.DAO.FuncionariosDAO;

import br.com.SistemaGiada.domain.Funcionario;
import br.com.SistemaGiada.util.JSFUtil;

@ManagedBean(name = "MBFuncionarios")
@ViewScoped
public class FuncionariosBean {

	private Funcionario funcionario;
	private ArrayList<Funcionario> itens;
	private ArrayList<Funcionario> itensFiltrados;
	private String acao;
	private Long codigo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}

	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	// ira construir o q esta abaixo assim q a pagina for iniciada
	// @PostConstruct
	public void prepararPesquisa() {

		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			itens = (ArrayList<Funcionario>) fdao.listar();

		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}

	}

	public void carregarCadastro() {
		try {

			if (codigo != null) {
				FuncionariosDAO fdao = new FuncionariosDAO();
				funcionario = fdao.buscarPorCodigo(codigo);
			} else {
				funcionario = new Funcionario();
			}

		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}

	public void novo() {
		funcionario = new Funcionario();
	}

	public void salvar() {

		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.salvar(funcionario);

			funcionario = new Funcionario();
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
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.excluir(funcionario);

			JSFUtil.adicionarMensagemSucesso("Fornecedor excluido com sucesso");
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			JSFUtil.adicionarMensagemErro("Não foi possivel excluir um fornecedor que tenha um produto associado!");
			e.printStackTrace();
		}
	}

	public void editar() {
		try {
			FuncionariosDAO fdao = new FuncionariosDAO();
			fdao.editar(funcionario);

			JSFUtil.adicionarMensagemSucesso("Fornecedor editado com sucesso");
		} catch (RuntimeException e) {
			// TODO: handle exception
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
}
