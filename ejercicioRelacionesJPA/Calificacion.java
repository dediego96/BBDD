package ejercicioRelacionesJPA;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@EntityListeners(CalificacionListener.class)
@Entity

public class Calificacion implements Serializable {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;

	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idModulo")
	private Modulo modulo;
	
	//@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idAlumno")
	private Alumno alumno;
	
	private Integer nota;
	
}
