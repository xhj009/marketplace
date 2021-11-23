package es.oi.marketplace.repository;

import org.springframework.stereotype.Repository;

import es.oi.marketplace.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer>{
	public Usuario findByNombreAndPassword(String nombre,String password);
}
