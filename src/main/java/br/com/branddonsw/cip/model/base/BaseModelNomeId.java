package br.com.branddonsw.cip.model.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModelNomeId extends BaseModelId {

	private static final long serialVersionUID = 8327728287540199323L;
	
	private String nome;

	public BaseModelNomeId() {
		super();
	}
	public BaseModelNomeId(Long id) {
		super(id);
	}
	public BaseModelNomeId(Long id, String nome) {
		this(id);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
