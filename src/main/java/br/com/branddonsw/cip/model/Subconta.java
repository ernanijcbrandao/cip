package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.branddonsw.cip.model.base.BaseModelId;

@Entity
@Table(name="subconta", catalog="dbcip")
public class Subconta extends BaseModelId {
	
	private static final long serialVersionUID = 758804948289589272L;
	
	@Temporal(value=TemporalType.DATE)
	private Calendar aniversario;
	private BigDecimal saldo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_conta", nullable=false)
	private Conta conta;
	
	@OneToMany
	private List<Movimentacao> movimentacoes;
	
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
	
	// auxiliares
	public List<Movimentacao> getAplicacoes() {
		List<Movimentacao> aplicacoes = null;
		if (movimentacoes != null) {
			aplicacoes = new ArrayList<Movimentacao>();
			for (Movimentacao movto : movimentacoes) {
				if (movto.isAplicacao()) {
					aplicacoes.add(movto);
				}
			}
			Collections.sort(aplicacoes);
		}
		return aplicacoes;
	}
	public List<Movimentacao> getResgates() {
		List<Movimentacao> resgates = null;
		if (movimentacoes != null) {
			resgates = new ArrayList<Movimentacao>();
			for (Movimentacao movto : movimentacoes) {
				if (movto.isResgate()) {
					resgates.add(movto);
				}
			}
			Collections.sort(resgates);
		}
		return resgates;
	}
	public List<Movimentacao> getRendimentos() {
		List<Movimentacao> rendimentos = null;
		if (movimentacoes != null) {
			rendimentos = new ArrayList<Movimentacao>();
			for (Movimentacao movto : movimentacoes) {
				if (movto.isRendimento()) {
					rendimentos.add(movto);
				}
			}
			Collections.sort(rendimentos);
		}
		return rendimentos;
	}
	
}
