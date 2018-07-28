package br.com.branddonsw.cip.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "RESGATE")
public class Resgate extends Movimentacao {

	private static final long serialVersionUID = -9167359052176583925L;
	
}
