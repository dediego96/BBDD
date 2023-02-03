package ejercicioRelacionesJPA;

import java.util.List;

import javax.persistence.PreRemove;

import utilidadeshibernate.GenericJPADAO;

public class AlumnoListener {
	
	private final String PERSISTENCE_UNIT = "ejerRelacionesJPA";
	
	@PreRemove
	private void borradoAlumno(Alumno alumno) {
		
		GenericJPADAO <Calificacion,Integer> calificacionDAO;
		calificacionDAO = new GenericJPADAO(Calificacion.class,PERSISTENCE_UNIT);
		
		List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();
		
		calificaciones.stream().
			filter(c -> c.getAlumno().equals(alumno)).
			forEach(calificacionDAO::delete);
		
	}
}
