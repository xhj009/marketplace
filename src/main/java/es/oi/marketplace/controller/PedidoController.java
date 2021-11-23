package es.oi.marketplace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.oi.marketplace.dto.ArticulosPedidosDto;
import es.oi.marketplace.dto.Pedidodto;
import es.oi.marketplace.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
	ArticulosPedidosDto articulosPedidosDto;

	
	@GetMapping(path = "/{id}")
	public Pedidodto buscarPedido(@PathVariable int id) {
		return pedidoService.buscarPedido(id);
	}
	
	@PostMapping("")
	public ResponseEntity<String> crearPedido(@RequestBody Pedidodto pedidodto){
		pedidoService.crearPedido(pedidodto);
		return new ResponseEntity<String> (HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path =  "/{id}")
	public ResponseEntity<String> actualizarPedido(@PathVariable Integer id, @RequestBody Pedidodto pedidodto){
		
		if (id.equals(pedidodto.getId())) {
			pedidoService.actualizar(pedidodto, id);
			return new ResponseEntity<String>(HttpStatus.ACCEPTED);
		}else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@DeleteMapping(path =  "/{id}")
	public ResponseEntity<String> eliminarPedido(@PathVariable Integer id) {
		pedidoService.delete(id);
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}
	
	@GetMapping(path = "/nombre/{nombreparcial}")
	public ResponseEntity<List<Pedidodto>> pedidosQueContengan(@PathVariable String nombreparcial ){
		return new ResponseEntity<List<Pedidodto>>(pedidoService.buscarPedidosQueContengan(nombreparcial),HttpStatus.ACCEPTED);
	}
	
}
