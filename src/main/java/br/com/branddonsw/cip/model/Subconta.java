package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.branddonsw.cip.model.base.BaseModelId;

@Entity
@Table(name="subconta", catalog="dbcip")
public class Subconta extends BaseModelId {
	
	private static final long serialVersionUID = 758804948289589272L;
	
	private Calendar aniversario;
	private BigDecimal saldo;
	
	@OneToMany(mappedBy="subconta")
	private List<Aplicacao> aplicacoes;
	@OneToMany(mappedBy="subconta")
	private List<Resgate> resgates;
	@OneToMany(mappedBy="subconta")
	private List<Rendimento> rendimentos;
	
	public Subconta() {
		super();
	}
	public Subconta(Long id) {
		super(id);
	}
	public Subconta(Long id, Calendar aniversario, BigDecimal saldo) {
		this(id);
		this.aniversario = aniversario;
		this.saldo = saldo;
	}
	
	public Calendar getAniversario() {
		return aniversario;
	}
	public void setAniversario(Calendar aniversario) {
		this.aniversario = aniversario;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public List<Aplicacao> getAplicacoes() {
		if (aplicacoes != null) {
			Collections.sort(aplicacoes);
		}
		return aplicacoes;
	}
	public void setAplicacoes(List<Aplicacao> aplicacoes) {
		this.aplicacoes = aplicacoes;
	}
	public List<Resgate> getResgates() {
		if (resgates != null) {
			Collections.sort(resgates);
		}
		return resgates;
	}
	public void setResgates(List<Resgate> resgates) {
		this.resgates = resgates;
	}
	public List<Rendimento> getRendimentos() {
		if (rendimentos != null) {
			Collections.sort(rendimentos);
		}
		return rendimentos;
	}
	public void setRendimentos(List<Rendimento> rendimentos) {
		this.rendimentos = rendimentos;
	}
	
}
