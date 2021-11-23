package es.oi.marketplace.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	private String nombre;
	@OneToMany(targetEntity = PerteneceA.class,cascade = CascadeType.ALL)
	private List<PerteneceA> pedidos;
	@ManyToOne(targetEntity = Usuario.class,cascade = CascadeType.ALL)
	private Usuario usuario;
}
