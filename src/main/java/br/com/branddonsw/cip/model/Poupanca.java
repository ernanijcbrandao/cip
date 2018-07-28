package br.com.branddonsw.cip.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import br.com.branddonsw.cip.model.enums.TipoInvestimentoEnumeration;

@Entity
@DiscriminatorValue(value = "POUPANCA")
public class Poupanca extends Conta {

	private static final long serialVersionUID = -6678436290749950768L;
	
	private List<Subconta> subcontas;

	public Poupanca() {
		super();
	}

	public Poupanca(Long id, String nome, Boolean ativo, BigDecimal saldo, TipoInvestimentoEnumeration tipo,
			Calendar abertura) {
		super(id, nome, ativo, saldo, tipo, abertura);
	}

	public Poupanca(Long id, String nome, Boolean ativo) {
		super(id, nome, ativo);
	}

	public Poupanca(Long id, String nome) {
		super(id, nome);
	}

	public Poupanca(Long id) {
		super(id);
	}

	public List<Subconta> getSubcontas() {
		return subcontas;
	}

	public void setSubcontas(List<Subconta> subcontas) {
		this.subcontas = subcontas;
	}
	
	// auxiliares
	public List<Aplicacao> getAplicacoes() {
		List<Aplicacao> result = null;
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
	
	public List<Resgate> getResgates() {
		List<Resgate> result = null;
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
	
	public List<Rendimento> getRendimentos() {
		List<Rendimento> result = null;
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
