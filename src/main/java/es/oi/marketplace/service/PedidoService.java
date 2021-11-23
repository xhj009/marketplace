package es.oi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.oi.marketplace.dto.Articulodto;
import es.oi.marketplace.dto.Pedidodto;
import es.oi.marketplace.entity.Articulo;
import es.oi.marketplace.entity.Pedido;
import es.oi.marketplace.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public Pedidodto buscarPedido(int id) {
		
		Pedido pedido = pedidoRepository.findById(id).get();
		
		
		List<Articulo> articulos = new ArrayList<>();
		List<Articulodto> listarArticulodtos = new ArrayList<>();
		
		for (Articulo articulo: articulos) {
			Articulodto articulodto = Articulodto.builder()
					.nombre(articulo.getNombre())
					.precio(articulo.getPrecio())
					.stock(articulo.getStock())
					.build();
			listarArticulodtos.add(articulodto);
		}
		
		
		Pedidodto pedidodto = Pedidodto.builder()
				.nombre(pedido.getNombre())
				.fecha(pedido.getFecha())
				.articulos(listarArticulodtos)
				.build();
			return pedidodto;
	}
	
	public void crearPedido(Pedidodto pedidodto) {
		List<Pedido> pedidos = new ArrayList<>();
		List<Pedidodto> listaPedidos = new ArrayList<>();
		List<Articulodto> listaArticulos = new ArrayList<>();
		List<Articulo> articulos = new ArrayList<>();
		//Pedido pedido = new Pedido();
		
		for (Articulo articulo : articulos) {
			Articulodto articulodto = Articulodto.builder()
					.nombre(articulo.getNombre())
					.precio(articulo.getPrecio())
					.stock(articulo.getStock())
					.build();
			listaArticulos.add(articulodto);
		}
		
		for (Pedido pedido : pedidos) {
			Pedidodto pedidodto1 = Pedidodto.builder()
					.nombre(pedido.getNombre())
					.fecha(pedido.getFecha())
					.articulos(listaArticulos)
					.build();
			listaPedidos.add(pedidodto1);
		}
		
//		pedido.setNombre(pedidodto.getNombre());
//		pedido.setFecha(pedidodto.getFecha());
//		pedido.setPedidos(listaArticulos);
		pedidoRepository.save(listaPedidos);
	}
	
	public void actualizarPedido(int id,Pedidodto pedidodto) {
		Pedido pedido = pedidoRepository.findById(id).get();
		List<Articulo> articulos = new ArrayList<>();
		List<Articulodto> listaArticulos = new ArrayList<>();
		
		for (Articulo articulo : articulos) {
			Articulodto articulodto = Articulodto.builder()
					.nombre(articulo.getNombre())
					.precio(articulo.getPrecio())
					.stock(articulo.getStock())
					.build();
			listaArticulos.add(articulodto);

		}
		
		pedido.setNombre(pedidodto.getNombre());
		pedido.setFecha(pedidodto.getFecha());
		pedido.setPedidos(listaArticulos);
	}
	
	public void delete(int id) {
		pedidoRepository.deleteById(id);
	}
	
	public List<Pedidodto> buscarPedidosQueContengan(String nombre){
		List<Pedido> contenga = pedidoRepository.findByNombreContaining(nombre);
		List<Pedidodto> pedidos = new ArrayList<>();
		
		List<Articulo> articulos = new ArrayList<>();
		List<Articulodto> listaArticulos = new ArrayList<>();
		
		for (Articulo articulo : articulos) {
			Articulodto articulodto = Articulodto.builder()
					.nombre(articulo.getNombre())
					.precio(articulo.getPrecio())
					.stock(articulo.getStock())
					.build();
			listaArticulos.add(articulodto);
		}
		
		
		for (Pedido pedido : contenga) {
			Pedidodto pedidodto = Pedidodto.builder()
					.nombre(pedido.getNombre())
					.fecha(pedido.getFecha())
					.articulos(listaArticulos)
					.build(); 
			pedidos.add(pedidodto);
		}
		return pedidos;
	}
	
}
