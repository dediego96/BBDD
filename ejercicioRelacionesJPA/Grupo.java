package ejercicioRelacionesJPA;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity

public class Grupo implements Serializable {
	
	@EqualsAndHashCode.Include
	
	@Id
	@Column(length=20)
	//@GeneratedValue (strategy = GenerationType.TABLE)
	
	private String nombre;
	@Column(length=20)
	private String ubicacion;
	
	//@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER) //no modificar profesor
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="idProfesor")
	private Profesor tutor;
	
	@Singular
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="idGrupo")
	private Set<Alumno> alumnos;
	
}
