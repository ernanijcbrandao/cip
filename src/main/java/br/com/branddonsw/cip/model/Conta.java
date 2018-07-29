package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.branddonsw.cip.model.base.BaseModelNomeIdAtivo;
import br.com.branddonsw.cip.model.enums.TipoInvestimentoEnumeration;

@Entity
@Table (name="conta", catalog="dbcip")
public class Conta extends BaseModelNomeIdAtivo {

	private static final long serialVersionUID = -2895669546517463796L;
	
	private BigDecimal saldo;
	
	@Enumerated(value=EnumType.STRING)
	private TipoInvestimentoEnumeration tipo;
	
	@Column(insertable=false, updatable=false)
	@Temporal(value=TemporalType.DATE)
	private Calendar abertura;
	
	@OneToMany
	private List<Subconta> subcontas;

	public Conta() {
		super();
	}
	public Conta(Long id, String nome, Boolean ativo) {
		super(id, nome, ativo);
	}
	public Conta(Long id, String nome) {
		super(id, nome);
	}
	public Conta(Long id) {
		super(id);
	}
	public Conta(Long id, String nome, Boolean ativo, BigDecimal saldo, TipoInvestimentoEnumeration tipo,
			Calendar abertura) {
		this(id, nome, ativo);
		this.saldo = saldo;
		this.tipo = tipo;
		this.abertura = abertura;
	}
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public TipoInvestimentoEnumeration getTipo() {
		return tipo;
	}
	public void setTipo(TipoInvestimentoEnumeration tipo) {
		this.tipo = tipo;
	}
	public Calendar getAbertura() {
		return abertura;
	}
	public void setAbertura(Calendar abertura) {
		this.abertura = abertura;
	}
	
	// auxiliares
	public List<Movimentacao> getAplicacoes() {
		List<Movimentacao> result = null;
		if (subcontas != null) {
			for (Subconta subconta : subcontas) {
				if (subconta.getAplicacoes() != null) {
					if (result == null) {
						result = subconta.getAplicacoes();
					} else {
						result.addAll(subconta.getAplicacoes());
					}
				}
			}
		}
		if (result != null) {
			Collections.sort(result);
		}
		return result;
	}
	
	public List<Movimentacao> getResgates() {
		List<Movimentacao> result = null;
		if (subcontas != null) {
			for (Subconta subconta : subcontas) {
				if (subconta.getResgates() != null) {
					if (result == null) {
						result = subconta.getResgates();
					} else {
						result.addAll(subconta.getResgates());
					}
				}
			}
		}
		if (result != null) {
			Collections.sort(result);
		}
		return result;
	}
	
	public List<Movimentacao> getRendimentos() {
		List<Movimentacao> result = null;
		if (subcontas != null) {
			for (Subconta subconta : subcontas) {
				if (subconta.getRendimentos() != null) {
					if (result == null) {
						result = subconta.getRendimentos();
					} else {
						result.addAll(subconta.getRendimentos());
					}
				}
			}
		}
		if (result != null) {
			Collections.sort(result);
		}
		return result;
	}
	
}
