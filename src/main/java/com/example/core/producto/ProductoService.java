package com.example.core.producto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	
	HashMap<String, Object> datos;
	private final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	
	
	public List<Producto> getProductos() {
		return this.productoRepository.findAll();
	}


	public ResponseEntity<Object> nuevoProducto(Producto producto) {
		Optional<Producto> res = productoRepository.findProductoByNombre(producto.getNombre());
		
		datos = new HashMap<>();
		
		if(res.isPresent() && producto.getId() == null) {
			datos.put("error", true);
			datos.put("message", "Ya existe un producto cno ese nombre");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
			);
		}
		datos.put("message", "Se guardo con exito");
		
		if(producto.getId() != null) {
			datos.put("message", "Se actualizo con exito");
		}
		
		productoRepository.save(producto);
		datos.put("data", producto);
		
		return new ResponseEntity<>(
				datos,
				HttpStatus.CREATED
		);
	}
	
	public ResponseEntity<Object> deleteProducto(Long id) {
		datos = new HashMap<>();
		
		boolean existe = this.productoRepository.existsById(id);
		
		if(!existe) {
			datos.put("error", true);
			datos.put("message", "No existe un producto con ese ID");
			return new ResponseEntity<>(
					datos,
					HttpStatus.CONFLICT
			);
		}
		
		productoRepository.deleteById(id);
		datos.put("message", "Producto eliminado");
		return new ResponseEntity<>(
				datos,
				HttpStatus.ACCEPTED
		);
	}
}
