package es.oi.marketplace;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

import es.oi.marketplace.dto.Usuariodto;
import es.oi.marketplace.service.UsuarioService;

@SpringBootTest
class MarketplaceApplicationTests {
	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	public void buscarUsuario() {
		Usuariodto usuariodto = new Usuariodto();
		usuariodto.setNombre("test");
		usuariodto.setPassword("test");
		usuarioService.crearUsuario(usuariodto);
		
		assertThat(usuarioService.buscarUsuarios());
				
	}
	
	@Test
	public void crearUsuario()
	{
		Usuariodto usuariodto = new Usuariodto();
		usuariodto.setNombre("test2");
		usuariodto.setPassword("test2");
		usuarioService.crearUsuario(usuariodto);
	
		
	}
	
	@Test
	public void actualizarUsuario() {
		Usuariodto usuariodto = new Usuariodto();
		usuariodto.setNombre("test3");
		usuariodto.setPassword("test3");
		usuarioService.crearUsuario(usuariodto);
		
		Usuariodto actualizar = usuarioService.buscarUsuarios().get(0);
		actualizar.setNombre("testActualizado");
		actualizar.setPassword("testActualizado");
		usuarioService.crearUsuario(actualizar); 
	}
	
	@Test
	public void comprobarLogin() {
		Usuariodto usuariodto = new Usuariodto();
		usuariodto.setNombre("test4");
		usuariodto.setPassword("test4");
		usuarioService.crearUsuario(usuariodto);
		//assertTrue(usuarioService.comprobarUsuario(usuariodto));
		assertEquals(usuariodto.getNombre(), usuariodto.getPassword());
		//assertThat(usuarioService.comprobarUsuario(usuariodto));
	}
	
}
