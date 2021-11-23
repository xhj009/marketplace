package es.oi.marketplace.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PerteneceA {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cantidad;
	@ManyToOne(targetEntity = Articulo.class,cascade = CascadeType.ALL)
	private Articulo articulo;
	@ManyToOne(targetEntity = Pedido.class,cascade = CascadeType.ALL)
	private Pedido pedido;
}
