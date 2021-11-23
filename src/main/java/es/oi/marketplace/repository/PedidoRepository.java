package es.oi.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.oi.marketplace.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	public List<Pedido> findByNombreContaining(String nombre);
}
