package es.oi.marketplace.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.oi.marketplace.dto.Articulodto;
import es.oi.marketplace.entity.Articulo;
import es.oi.marketplace.repository.ArticuloRepository;

@Service
public class ArticuloService {
	@Autowired
	ArticuloRepository articuloRepository;
	
	public Articulodto buscarArticulo(int id) {
		Articulo articulo =  articuloRepository.getById(id);
		
		Articulodto dto = Articulodto.builder()
				.nombre(articulo.getNombre())
				.stock(articulo.getStock())
				.precio(articulo.getPrecio())
				.build();
		return dto;
		
	}
	
	public void crearArticulo(Articulodto articulodto) {
		Articulo articulo = new Articulo();
		articulo.setNombre(articulodto.getNombre());
		articulo.setPrecio(articulodto.getPrecio());
		articulo.setStock(articulodto.getStock());
		articuloRepository.save(articulo);
	}
	
	public void actualizarArticulo(int id, Articulodto articulodto) {
		Articulo articulo = articuloRepository.findById(id).get();
		articulo.setNombre(articulodto.getNombre());
		articulo.setPrecio(articulodto.getPrecio());
		articulo.setStock(articulodto.getStock());
		articuloRepository.save(articulo);
	}
	
	public List<Articulodto> articulosQueContengan(String nombreparcial) {
		List<Articulodto> articulos = new ArrayList<>();
		 List<Articulo> contengan = articuloRepository.findByNombreContaining(nombreparcial);
		
		for (Articulo articulo : contengan) {

			Articulodto dto = Articulodto.builder()
					.nombre(articulo.getNombre())
					.stock(articulo.getStock())
					.precio(articulo.getPrecio())
					.build();
			articulos.add(dto);
		}
		return articulos;
		
		
	}
}
