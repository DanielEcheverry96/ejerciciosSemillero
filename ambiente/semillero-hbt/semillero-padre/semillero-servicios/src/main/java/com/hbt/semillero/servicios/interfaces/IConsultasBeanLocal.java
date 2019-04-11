package com.hbt.semillero.servicios.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;

@Local
public interface IConsultasBeanLocal {
	
	public List<Marca> consultarMarcas();
	
	public List<Linea> consultarLineas(Long idMarca);
	
	public void crearPersona(PersonaDTO personaDTO);
	
	public List<Persona> consultarPersonas(String tipoIdentificacion, String numeroIdentificacion);

	public void actualizarPersona(PersonaDTO personaDTO);
	
}
