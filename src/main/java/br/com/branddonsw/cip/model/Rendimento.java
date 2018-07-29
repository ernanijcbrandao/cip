package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.branddonsw.cip.model.enums.TipoMovimentacaoEnumeraton;

@Entity
@DiscriminatorValue(value = "RENDIMENTO")
public class Rendimento extends Movimentacao {

	private static final long serialVersionUID = -2795465610171171909L;
	
	private BigDecimal saldoBase;
	private BigDecimal rendimento;
	
	public Rendimento() {
		super();
	}
	public Rendimento(Long id, Calendar data, BigDecimal valor, String tipo, Subconta subconta, String chave) {
		super(id, data, valor, tipo, subconta, chave);
	}
	public Rendimento(Long id) {
		super(id);
	}
	public Rendimento(Long id, Calendar data, BigDecimal valor, String tipo, Subconta subconta, String chave,
			BigDecimal saldoBase, BigDecimal rendimento) {
		this(id, data, valor, tipo, subconta, chave);
		this.saldoBase = saldoBase;
		this.rendimento = rendimento;
	}
	
	public BigDecimal getSaldoBase() {
		return saldoBase;
	}
	public void setSaldoBase(BigDecimal saldoBase) {
		this.saldoBase = saldoBase;
	}
	public BigDecimal getRendimento() {
		return rendimento;
	}
	public void setRendimento(BigDecimal rendimento) {
		this.rendimento = rendimento;
	}

}
