package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.branddonsw.cip.model.base.BaseModelNomeIdAtivo;
import br.com.branddonsw.cip.model.enums.TipoInvestimentoEnumeration;

@Entity
@Table (name="conta", catalog="dbcip")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
public class Conta extends BaseModelNomeIdAtivo {

	private static final long serialVersionUID = -2895669546517463796L;
	
	private BigDecimal saldo;
	@Enumerated(value=EnumType.STRING)
	private TipoInvestimentoEnumeration tipo;
	@Temporal(value=TemporalType.DATE)
	private Calendar abertura;

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
	
}
