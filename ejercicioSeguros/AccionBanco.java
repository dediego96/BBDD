package ejercicioSeguros;

import utilidadeshibernate.GenericJPADAO;

public class AccionBanco {

	private final static String UNIDADPERSISTENCIA = "ejercicioSeguros";

	protected static GenericJPADAO<Seguro, Integer> seguroDAO = new GenericJPADAO<Seguro, Integer>(Seguro.class,
			UNIDADPERSISTENCIA);
	
	protected static GenericJPADAO<AsistenciaMedica, Integer> asistenciaDAO = new GenericJPADAO<AsistenciaMedica, Integer>(AsistenciaMedica.class,
			UNIDADPERSISTENCIA);
	
	protected static GenericJPADAO<Enfermedades, Integer> enfermedadesDAO = new GenericJPADAO<Enfermedades, Integer>(Enfermedades.class,
			UNIDADPERSISTENCIA);

}
