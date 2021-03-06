package es.oi.marketplace.dto;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pedidodto {
	private int id;
	private String nombre;
	private Date fecha;
	private List<ArticulosPedidosDto> articulos;
}
