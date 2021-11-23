package es.oi.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.oi.marketplace.dto.Usuariodto;
import es.oi.marketplace.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("")
	public List<Usuariodto> mostrarUsuarios(){
		return usuarioService.buscarUsuarios();
	}
	
	
	@PostMapping("")
	public ResponseEntity<String> CrearUsuario(@RequestBody Usuariodto usuariodto){
		usuarioService.crearUsuario(usuariodto);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> ActualizarUsuarios(@PathVariable int id, @RequestBody Usuariodto usuariodto){
		usuarioService.actualizarUsuarios(id,usuariodto);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> comprobarUsuario(@RequestBody Usuariodto usuariodto ){
		return new ResponseEntity<Boolean>(usuarioService.comprobarUsuario(usuariodto),HttpStatus.ACCEPTED);
	}
}
