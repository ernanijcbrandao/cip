package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.branddonsw.cip.model.base.BaseModelId;

@Entity
@Table(name="movimentacao", catalog="dbcip")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo", length = 1, discriminatorType = DiscriminatorType.STRING)
public class Movimentacao extends BaseModelId implements Comparable<Movimentacao> {

	private static final long serialVersionUID = 4017701786975258944L;
	
	@Temporal(value=TemporalType.DATE)
	private Calendar data;
	private BigDecimal valor;
	
	private String tipo;
	
	private String chave;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_subconta", nullable=false)
	private Subconta subconta;
	
	public Movimentacao() {
		super();
	}
	public Movimentacao(Long id) {
		super(id);
	}
	public Movimentacao(Long id, Calendar data, BigDecimal valor, String tipo, Subconta subconta, String chave) {
		this(id);
		this.data = data;
		this.valor = valor;
		this.tipo = tipo;
		this.subconta = subconta;
		this.chave = chave;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
