package br.com.branddonsw.cip.model.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModelNomeIdAtivo extends BaseModelNomeId {

	private static final long serialVersionUID = 1860835349949040287L;
	
	private Boolean ativo;

	public BaseModelNomeIdAtivo() {
		super();
	}
	public BaseModelNomeIdAtivo(Long id, String nome) {
		super(id, nome);
	}
	public BaseModelNomeIdAtivo(Long id) {
		super(id);
	}
	public BaseModelNomeIdAtivo(Long id, String nome, Boolean ativo) {
		this(id, nome);
		this.ativo = ativo;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}
	public boolean isAtivo() {
		return ativo != null ? ativo : false;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
