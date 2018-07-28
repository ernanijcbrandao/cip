package br.com.branddonsw.cip.model.base;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModelIdAtivo extends BaseModelId {

	private static final long serialVersionUID = -3649874410480644640L;
	
	private Boolean ativo;

	public BaseModelIdAtivo() {
		super();
	}
	public BaseModelIdAtivo(Long id) {
		super(id);
	}
	public BaseModelIdAtivo(Long id, Boolean ativo) {
		this(id);
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
