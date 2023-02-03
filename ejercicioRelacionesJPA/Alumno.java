package ejercicioRelacionesJPA;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@EntityListeners(AlumnoListener.class)
@Entity

public class Alumno implements Serializable {
	
	@EqualsAndHashCode.Include
	
	@Id
	@Column(length=9)
	private String dni;
	
	@Column(length=20)
	private String nombre;
	
	private LocalDate fecNac;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="idDireccion")
	private Direccion direccion;
	
	public Alumno(String dni) {
		this.dni = dni;
	}
	
}
