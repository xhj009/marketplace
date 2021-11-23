package es.oi.marketplace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.oi.marketplace.entity.Articulo;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Integer>{
	public List<Articulo> findByNombreContaining(String nombre);
}
