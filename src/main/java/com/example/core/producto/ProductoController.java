package com.example.core.producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //la clase s vuelve un controlador
@RequestMapping(path = "api/v1/productos") //indicarle la version de la api, y que este es el controlador de...
public class ProductoController {
	
	
	private final ProductoService productoService;
		
	@Autowired //para inyectar esta clase en el constructor
	public ProductoController(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@GetMapping
	public List<Producto> getProductos(){
		return productoService.getProductos();
	}
	
	@PostMapping
	public ResponseEntity<Object> registrarProducto(@RequestBody Producto producto) {
		return productoService.nuevoProducto(producto);
	}
	
	@PutMapping
	public ResponseEntity<Object> actualizarProducto(@RequestBody Producto producto) {
		return productoService.nuevoProducto(producto);
	}
	
	@DeleteMapping(path = "{productoId}")
	public ResponseEntity<Object> eliminarProducto(@PathVariable("productoId") Long id) {
		return productoService.deleteProducto(id);
	}
	
}
