package com.hbt.semillero.servicios.ejb;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.entidades.Comprador;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.entidades.Vendedor;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

@Stateless
public class ConsultasBean implements IConsultasBeanLocal{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Permite consultar las marcas almacenadas en la Base de Datos
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<Marca> consultarMarcas() {
		return entityManager.createQuery("Select ma FROM Marca ma").getResultList();
	}
	
	/**
	 * Permite consultar las lineas por marca almacenadas en la Base de Datos
	 */
	public List<Linea> consultarLineas(Long idMarca) {
		return entityManager.createQuery("Select ln from Linea ln JOIN FETCH ln.marca where ln.marca.idMarca=:idMarca")
				.setParameter("idMarca", idMarca).getResultList();
	}
	
	/**
	 * Permite crear una persona en la Base de Datos
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearPersona(PersonaDTO personaDTO) {
		Persona persona = new Persona();
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.persist(persona);
		
		if (personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);
		}
		if (personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);
		}
	}
	
	/**
	 * Permite consultar las personas almacenadas en la Base de Datos
	 */
	public List<Persona> consultarPersonas(String tipoIdentificacion, String numeroIdentificacion) {
		return entityManager.createQuery("Select per FROM Persona per where per.tipoIdentificacion=:tipoIdentificacion AND per.numeroIdentificacion=:numeroIdentificacion")
				.setParameter("tipoIdentificacion", tipoIdentificacion)
				.setParameter("numeroIdentificacion", numeroIdentificacion).getResultList();
	}
	
	/**
	 * Permite actualizar una persona en la Base de Datos
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void actualizarPersona(PersonaDTO personaDTO) {
		
		Persona persona = entityManager.find(Persona.class, personaDTO.getIdPersona());
		
		persona.setIdPersona(personaDTO.getIdPersona());
		persona.setNombres(personaDTO.getNombres());
		persona.setApellidos(personaDTO.getApellidos());
		persona.setTipoIdentificacion(personaDTO.getTipoIdentificacion());
		persona.setNumeroIdentificacion(personaDTO.getNumeroIdentificacion());
		persona.setNumeroTelefonico(personaDTO.getNumeroTelefonico());
		persona.setEdad(personaDTO.getEdad());
		
		entityManager.merge(persona);
		
		if (personaDTO.isComprador()) {
			Comprador comprador = new Comprador();
			
			comprador.setFechaAfiliacion(Calendar.getInstance());
			comprador.setPersona(persona);
			entityManager.persist(comprador);
		}
		if (personaDTO.isVendedor()) {
			Vendedor vendedor = new Vendedor();
			
			vendedor.setFechaIngreso(Calendar.getInstance());
			vendedor.setPersona(persona);
			entityManager.persist(vendedor);
		}
	}
}
