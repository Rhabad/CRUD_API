package com.example.core.producto;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //de forma automatica se generen los valores para este id
	private Long id;
	
	@Column(unique = true)
	private String nombre;
	private float precio;
	private LocalDate fecha;
	@Transient
	private int antiguedad;
	
	
	public Producto() {
	}

	//constructor para enviar todos los datos
	public Producto(Long id, String nombre, float precio, LocalDate fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
	}

	//contructor para enviar todos los datos menos el id.
	public Producto(String nombre, float precio, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.fecha = fecha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getAntiguedad() {
		return Period.between(this.fecha, LocalDate.now()).getYears();
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	
	
}
