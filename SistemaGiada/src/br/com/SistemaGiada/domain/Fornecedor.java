package br.com.SistemaGiada.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fornecedores")
@NamedQueries({ @NamedQuery(name = "Fornecedor.listar", query = "SELEXT fornecedor FROM Fornecedor fornecedor") })
public class Fornecedor {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "for_codigo")
	private Integer codigo;

	@Column(name = "for_descricao", length = 50, nullable = false)
	private String descricao;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
