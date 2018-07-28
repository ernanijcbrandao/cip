package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.branddonsw.cip.model.base.BaseModelIdAtivo;
import br.com.branddonsw.cip.model.enums.TipoInvestimentoEnumeration;

@Entity
@Table(name="taxas", catalog="dbcip")
public class Taxa extends BaseModelIdAtivo {

	private static final long serialVersionUID = 8648813645871388525L;
	
	@Enumerated(value=EnumType.STRING)
	private TipoInvestimentoEnumeration taxa;
	
	@Temporal(TemporalType.DATE)
	private Calendar data;
	
	private BigDecimal valor;

	public Taxa() {
		super();
	}
	public Taxa(Long id, Boolean ativo) {
		super(id, ativo);
	}
	public Taxa(Long id) {
		super(id);
	}
	public Taxa(Long id, Boolean ativo, TipoInvestimentoEnumeration taxa, Calendar data, BigDecimal valor) {
		this(id, ativo);
		this.taxa = taxa;
		this.data = data;
		this.valor = valor;
	}
	
	public TipoInvestimentoEnumeration getTaxa() {
		return taxa;
	}
	public void setTaxa(TipoInvestimentoEnumeration taxa) {
		this.taxa = taxa;
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

}
