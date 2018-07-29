package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.branddonsw.cip.model.base.BaseModelId;
import br.com.branddonsw.cip.model.enums.TipoMovimentacaoEnumeraton;

@Entity
@Table(name="movimentacao", catalog="dbcip")
public class Movimentacao extends BaseModelId implements Comparable<Movimentacao> {

	private static final long serialVersionUID = 4017701786975258944L;
	
	@Column(nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Calendar data;
	
	@Column(nullable=false)
	private BigDecimal valor;
	
	@Column(nullable=false)
	private String chave;
	
	@Enumerated(value=EnumType.STRING)
	private TipoMovimentacaoEnumeraton tipo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_subconta", nullable=false)
	private Subconta subconta;
	
	@Column(name="saldo_base")
	private BigDecimal saldoBase;
	
	private BigDecimal rendimento;
	
	public Movimentacao() {
		super();
	}
	public Movimentacao(Long id) {
		super(id);
	}
	public Movimentacao(Long id, Calendar data, BigDecimal valor, TipoMovimentacaoEnumeraton tipo, Subconta subconta, String chave) {
		this(id);
		this.data = data;
		this.valor = valor;
		this.subconta = subconta;
		this.chave = chave;
		this.tipo = tipo;
	}
	
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public Subconta getSubconta() {
		return subconta;
	}
	public void setSubconta(Subconta subconta) {
		this.subconta = subconta;
	}
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public TipoMovimentacaoEnumeraton getTipo() {
		return tipo;
	}
	public void setTipo(TipoMovimentacaoEnumeraton tipo) {
		this.tipo = tipo;
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
	
	// auxiliares
	public boolean isAplicacao() {
		return TipoMovimentacaoEnumeraton.APLICACAO.equals(this.tipo);
	}
	public boolean isResgate() {
		return TipoMovimentacaoEnumeraton.RESGATE.equals(this.tipo);
	}
	public boolean isRendimento() {
		return TipoMovimentacaoEnumeraton.RENDIMENTO.equals(this.tipo);
	}
	
	@Override
	public int compareTo(Movimentacao o) {
		int order = 0;
		if (o != null) {
			if (this.getData() == null) {
				if (o.getData() != null) {
					order = 1;
				}
			} else {
				if (o.getData() == null) {
					order = -1;
				} else {
					order = this.compareTo(o);
				}
			}
		}
		return order;
	}

	
	
}
