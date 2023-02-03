package ejercicioRelacionesJPA;

import java.util.List;

import javax.persistence.PreUpdate;

import utilidadeshibernate.GenericJPADAO;

public class ProfesorListener {

	private final String PERSISTENCE_UNIT = "ejerRelacionesJPA";

	@PreUpdate
	private void borrarProfesor(Profesor profesor) {

		tratarModulos(profesor);
		tratarGrupos(profesor);

	}

	private void tratarGrupos(Profesor profesor) {

		GenericJPADAO<Grupo, String> grupoDAO;
		grupoDAO = new GenericJPADAO(Grupo.class, PERSISTENCE_UNIT);

		List<Grupo> grupos = grupoDAO.findAll();

		grupos.stream().filter(g -> g.getTutor().equals(profesor)).forEach(g -> {
			g.setTutor(null);
			grupoDAO.update(g);
		});

	}

	private void tratarModulos(Profesor profesor) {

		GenericJPADAO<Modulo, String> moduloDAO;
		moduloDAO = new GenericJPADAO(Modulo.class, PERSISTENCE_UNIT);

		List<Modulo> modulos = moduloDAO.findAll();

		modulos.stream().filter(m -> m.getProfesor().equals(profesor)).forEach(m -> {
			m.setProfesor(null);
			moduloDAO.update(m);
		});

	}

}
