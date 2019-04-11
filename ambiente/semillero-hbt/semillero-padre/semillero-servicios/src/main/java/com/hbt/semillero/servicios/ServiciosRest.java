package com.hbt.semillero.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.LineaDTO;
import com.hbt.semillero.dto.MarcaDTO;
import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.entidades.Linea;
import com.hbt.semillero.entidades.Marca;
import com.hbt.semillero.entidades.Persona;
import com.hbt.semillero.servicios.interfaces.IConsultasBeanLocal;

/**
 * Expone las consultas a la base de datos de la aplicación
 * por medio de un servicio Rest
 * PathServer para acceder -> http://127.0.0.1:8085/semillero-servicios/rest/ServiciosRest
 * @author Daniel Echeverry
 *
 */
@Path("/ServiciosRest")
public class ServiciosRest {

	/**
	 * Interface que encapsula los metodos de consulta a la base de datos
	 */
	@EJB
	private IConsultasBeanLocal consultasBean; 
	
	/**
	 * Permite obtener todas las marcas almacenadas en la base de datos
	 * El acceso al metodo GET por el servicio Rest se hace por medio del pathServer/consultarMarcas 
	 * @return Lista con objetos JSON que contiene las marcas
	 */
	@GET
	@Path("/consultarMarcas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MarcaDTO> consultarMarcas() {
		List<Marca> marcas = consultasBean.consultarMarcas();
		List<MarcaDTO> retorno = new ArrayList<>();
		for (Marca marca : marcas) {
			MarcaDTO marcaDTO = construirMarcaDTO(marca);
			retorno.add(marcaDTO);
		}
		return retorno;
	}
	
	/**
	 * Permite obtener todas las lineas por marca almacenadas en la base de datos
	 * El acceso al metodo GET por el servicio Rest se hace por medio del pathServer/consultarLineas 
	 * @param idMarca Campo que identifica a una marca con la que quiero obtener las lineas
	 * @return Lista con objetos JSON que contiene las lineas de la marca
	 */
	@GET
	@Path("/consultarLineas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<LineaDTO> consultarLineas(@QueryParam(value = "idMarca")Long idMarca) {
		List<Linea> lineas = consultasBean.consultarLineas(idMarca);
		List<LineaDTO> retorno = new ArrayList<>();
		for (Linea linea : lineas) {
			LineaDTO lineaDTO = new LineaDTO();
			MarcaDTO marcaDTO = construirMarcaDTO(linea.getMarca());
			
			lineaDTO.setIdLinea(linea.getIdLinea());
			lineaDTO.setNombre(linea.getNombre());
			lineaDTO.setCilindraje(linea.getCilindraje());
			lineaDTO.setMarca(marcaDTO);
			retorno.add(lineaDTO);
		}
		return retorno;
	}
	
	/**
	 * Permite crea personas para almacenarlas en la base de datos
	 * El acceso al metodo POST por el servicio Rest se hace por medio del pathServer/crearPersona 
	 * @param personaDTO Objeto de tipo Persona
	 * @return Objeto de tipo ResultadoDTO que contiene el resultado de la consulta
	 * {
	 * 		exitoso: false,
	 * 		mensaje: "No se pudo ingresar a la persona"
	 * }
	 */
	@POST
	@Path("/crearPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.crearPersona(personaDTO);			
		}
		catch (Exception ex) {
			retorno.setExitoso(false);
			retorno.setMensajeError("No se pudo ingresar la persona");
		}
		return retorno;
	}
	
	
	
	/**
	 * Permite obtener las personas con cierto Tipo de Identificación y Número Identificación
	 * El acceso al metodo GET por el servicio Rest se hace por medio del pathServer/consultarPersonas
	 * @param tipoIdentificacion Tipo de Identificación de la persona -> "CC" o "TI" o "Pasaporte"]
	 * @param numeroIdentificacion Número de Identificación de la persona
	 * @return Lista con objetos JSON que contiene las personas
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarPersonas(@QueryParam(value = "tipoIdentificacion")String tipoIdentificacion, @QueryParam(value = "numeroIdentificacion") String numeroIdentificacion ) {
		List<Persona> personas = consultasBean.consultarPersonas(tipoIdentificacion, numeroIdentificacion);
		List<PersonaDTO> retorno = new ArrayList<>();
		for (Persona persona : personas) {
			PersonaDTO personaDTO = new PersonaDTO();
			
			personaDTO.setIdPersona(persona.getIdPersona());
			personaDTO.setNombres(persona.getNombres());
			personaDTO.setApellidos(persona.getApellidos());
			personaDTO.setTipoIdentificacion(persona.getTipoIdentificacion());
			personaDTO.setNumeroIdentificacion(persona.getNumeroIdentificacion());
			personaDTO.setNumeroTelefonico(persona.getNumeroTelefonico());
			personaDTO.setEdad(persona.getEdad());
			
			retorno.add(personaDTO);
		}
		return retorno;
	}
	
	/**
	 * Permite actualizar una persona almacenada en la base de datos
	 * El acceso al metodo PUT por el servicio Rest se hace por medio del pathServer/actualizarPersona 
	 * @param personaDTO Objeto de tipo Persona
	 * @return Objeto de tipo ResultadoDTO que contiene el resultado de la consulta
	 * {
	 * 		exitoso: false,
	 * 		mensaje: "No se pudo actualizar la persona"
	 * }
	 */
	@PUT
	@Path("/actualizarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO actualizarPersona(PersonaDTO personaDTO) {
		ResultadoDTO retorno = new ResultadoDTO();
		retorno.setExitoso(true);
		try {
			consultasBean.actualizarPersona(personaDTO);			
		}
		catch (Exception ex) {
			retorno.setExitoso(false);
			retorno.setMensajeError("No se pudo actualizar la persona");
		}
		return retorno;
	}
	
	
	/**
	 * Asignar a un objeto MarcaDTO los valores de las propiedades de un objeto Marca
	 * de un objeto Marca
	 * @param marca Marca a convertir
	 * @return Objeto MarcaDTO
	 */
	private MarcaDTO construirMarcaDTO(Marca marca) {
		MarcaDTO marcaDTO = new MarcaDTO();
		marcaDTO.setIdMarca(marca.getIdMarca());
		marcaDTO.setNombre(marca.getNombre());
		return marcaDTO;
	}
	
}
