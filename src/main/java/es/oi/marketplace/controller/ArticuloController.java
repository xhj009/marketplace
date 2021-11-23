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

import es.oi.marketplace.dto.Articulodto;
import es.oi.marketplace.service.ArticuloService;

@RestController
@RequestMapping("/articulo")
public class ArticuloController {
	@Autowired
	ArticuloService articuloService;
	
	@GetMapping(path =  "/{id}")
	public Articulodto buscarArticulo(@PathVariable int id) {
		return articuloService.buscarArticulo(id);
	}
	
	@PostMapping("")
	public ResponseEntity<String> crearArticulo(@RequestBody Articulodto articulodto){
		articuloService.crearArticulo(articulodto);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> actualizarArticulo(@PathVariable int id,@RequestBody Articulodto articulodto){
		articuloService.actualizarArticulo(id, articulodto);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping( path = "/nombre/{nombreparcial}")
	public ResponseEntity<List<Articulodto>> articulosQueContengan(@PathVariable String nombreparcial ){
		return new ResponseEntity<List<Articulodto>>(articuloService.articulosQueContengan(nombreparcial),HttpStatus.ACCEPTED);
	}
	
}
