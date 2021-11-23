package es.oi.marketplace;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.oi.marketplace.dto.Articulodto;
import es.oi.marketplace.service.ArticuloService;

public class ArticuloTest {
	@Autowired
	ArticuloService articuloService;

	@Test
	public void  obtenerArticulo() {
		Articulodto articulodto = new Articulodto();
		articulodto.setNombre("test");
		articulodto.setPrecio(0);
		articulodto.setStock(0);
		articuloService.crearArticulo(articulodto);
		
		assertThat(articuloService.buscarArticulo(articulodto.getId()));
		
		
		
	}
	
	@Test
	public void crearArticulo() {
		Articulodto articulodto = new Articulodto();
		articulodto.setNombre("test2");
		articulodto.setPrecio(0);
		articulodto.setStock(0);
	
	 	articuloService.crearArticulo(articulodto);
	 	assertEquals("tets", articulodto.getNombre());
	}
	
	@Test
	public void actualizarArticulo () {
		Articulodto articulodto = new Articulodto();
		articulodto.setNombre("test3");
		articulodto.setPrecio(0);
		articulodto.setStock(0);		
		articuloService.crearArticulo(articulodto);
		
		Articulodto actualizar = articuloService.buscarArticulo(articulodto.getId());
		actualizar.setNombre("testActualizado");
		actualizar.setPrecio(2);
		actualizar.setStock(1);
		articuloService.actualizarArticulo(articulodto.getId(),actualizar);
		
		
	}
	
	@Test
	public void ArticuloQueContenga() {
		Articulodto articulodto = new Articulodto();
		articulodto.setNombre("test4");
		articulodto.setPrecio(0);
		articulodto.setStock(0);		
		articuloService.crearArticulo(articulodto);
		
		//articuloService.articulosQueContengan(articulodto.getNombre());
		assertEquals("test", articuloService.articulosQueContengan(articulodto.getNombre()));
	}
}
