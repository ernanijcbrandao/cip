package br.com.branddonsw.cip.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "APLICACAO")
public class Aplicacao extends Movimentacao {

	private static final long serialVersionUID = 231325523857019544L;

}
