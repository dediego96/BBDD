package ejercicioRelacionesJPA;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class CalificacionListener {
	
	@PrePersist
	@PreUpdate

	public void comprobarCalificacion(Calificacion calificacion) {

		if (calificacion.getNota() != null) {

			if (calificacion.getNota() < 1) {

				calificacion.setNota(1);

			} else if (calificacion.getNota() > 10) {

				calificacion.setNota(10);

			}

		}

	}
}