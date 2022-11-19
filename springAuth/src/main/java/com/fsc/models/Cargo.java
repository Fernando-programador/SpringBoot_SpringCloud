package com.fsc.models;

import java.io.Serializable;



public class Cargo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String cargo;

	public Cargo() {
		super();
	}

	public Cargo(Long id, String cargo) {
		super();
		this.id = id;
		this.cargo = cargo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
