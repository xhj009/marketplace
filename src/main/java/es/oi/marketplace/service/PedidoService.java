package es.oi.marketplace.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.oi.marketplace.dto.ArticulosPedidosDto;
import es.oi.marketplace.dto.Pedidodto;

import es.oi.marketplace.entity.Pedido;
import es.oi.marketplace.entity.PerteneceA;
import es.oi.marketplace.repository.ArticuloRepository;
import es.oi.marketplace.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ArticuloRepository articuloRepository;
		
	public Pedidodto buscarPedido(int id) {
		List<ArticulosPedidosDto> lista = new ArrayList<>();
		Pedido pedido = pedidoRepository.findById(id).get();
		Pedidodto dto = new Pedidodto();
		dto.setId(pedido.getId());
		dto.setFecha(pedido.getFecha());
		dto.setNombre(pedido.getNombre());
		
		for(PerteneceA articulo:pedido.getPedidos()) {
			ArticulosPedidosDto tmp = new ArticulosPedidosDto();
			tmp.setId( articulo.getCantidad());
			tmp.setCantidad(articulo.getCantidad());
			
			lista.add(tmp);
		}
		dto.setArticulos(lista);

		return dto;
		
		}
		

	
	public void crearPedido(Pedidodto pedidodto) {
		
		Pedido pedido = new Pedido();
		List<PerteneceA> lista = new ArrayList<>();
		
		for(ArticulosPedidosDto tmp : pedidodto.getArticulos() ) {
			PerteneceA perteneceA = new PerteneceA();
			perteneceA.setArticulo(articuloRepository.findById(tmp.getId()).get());
			perteneceA.setCantidad(tmp.getCantidad());
			perteneceA.setPedido(pedido);
			
			lista.add(perteneceA);
		}
		
		pedido.setFecha(pedidodto.getFecha());
		pedido.setNombre(pedidodto.getNombre());
		pedido.setPedidos(lista);
		
		pedidoRepository.save(pedido);

	}
	
	public void actualizar(Pedidodto pedidodto,Integer id) {
		
		Pedido pedido = pedidoRepository.getById(id);
		List<PerteneceA> lista = new ArrayList<>();
		
		for(ArticulosPedidosDto tmp : pedidodto.getArticulos() ) {
			PerteneceA perteneceA = new PerteneceA();
			perteneceA.setArticulo(articuloRepository.findById(tmp.getId()).get());
			perteneceA.setCantidad(tmp.getCantidad());
			perteneceA.setPedido(pedido);
			
			
			lista.add(perteneceA);
		}
		
		pedido.setId(pedidodto.getId());
		pedido.setFecha(pedidodto.getFecha());
		pedido.setNombre(pedidodto.getNombre());
		pedido.setPedidos(lista);
		
		pedidoRepository.save(pedido);

	}

	
	public void delete(Integer id) {
	      Pedido p = pedidoRepository.findById(id).get();
	      p.getUsuario().getPedidos().remove(p);
	     pedidoRepository.deleteById(id);

	   }
	

		
	public List<Pedidodto> buscarPedidosQueContengan(String nombre){
		List<Pedido> contenga = pedidoRepository.findByNombreContaining(nombre);
		List<ArticulosPedidosDto> listaArticulos = new ArrayList<>();
		List<Pedidodto> lista = new ArrayList<>();
		
		for (Pedido pedido : contenga) {
			Pedidodto dto = new Pedidodto();
			dto.setId(pedido.getId());
			dto.setNombre(pedido.getNombre());
			dto.setFecha(pedido.getFecha());


			for(PerteneceA tmp : pedido.getPedidos() ) {
				ArticulosPedidosDto articulosPedidosDto = new ArticulosPedidosDto();
				articulosPedidosDto.setId(tmp.getArticulo().getId());
				articulosPedidosDto.setCantidad(tmp.getCantidad());
				listaArticulos.add(articulosPedidosDto);
			}
			dto.setArticulos(listaArticulos);
			lista.add(dto);
		}
		return lista;
	}	
}
