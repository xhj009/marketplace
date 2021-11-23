package es.oi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.oi.marketplace.dto.Usuariodto;
import es.oi.marketplace.entity.Usuario;
import es.oi.marketplace.repository.UsuarioRepository;

@Service

public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuariodto> buscarUsuarios(){
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<Usuariodto> listaUsuarios = new ArrayList<>();
		
		for (Usuario usuario : usuarios ) {
			Usuariodto dto = Usuariodto.builder()
					.id(usuario.getId())
					.nombre(usuario.getNombre())
					.password(usuario.getPassword())
					.build();
			listaUsuarios.add(dto);
		}
		return listaUsuarios;
	}
	
	public void crearUsuario(Usuariodto usuariodto) {
		Usuario usuario = new Usuario();
		usuario.setId(usuariodto.getId());
		usuario.setNombre(usuariodto.getNombre());
		usuario.setPassword(usuariodto.getPassword());
		usuarioRepository.save(usuario);
	}
	
	public void actualizarUsuarios(int id , Usuariodto usuariodto) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNombre(usuariodto.getNombre());
		usuario.setPassword(usuariodto.getPassword());
		usuarioRepository.save(usuario);
	}
	
	public Boolean comprobarUsuario(Usuariodto usuariodto) {
		Usuario usuario = usuarioRepository.findByNombreAndPassword(usuariodto.getNombre(), usuariodto.getPassword());
		if (usuario == null) {
			return false;
		}else {
			return true;
		}
	}
}
