package es.oi.marketplace.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) 
	private int id;
	private String nombre;
	private String password;
	@OneToMany(targetEntity = Pedido.class,cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
}
