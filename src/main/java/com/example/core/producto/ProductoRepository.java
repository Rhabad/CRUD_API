package com.example.core.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	
	//@Query("select * from producto p where p.name = ?") lo mismo que hacer lo de abajo
	Optional<Producto> findProductoByNombre(String nombre);
}
