package ejercicioRelacionesJPA;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

@Entity

public class Profesor implements Serializable {

	@EqualsAndHashCode.Include
	
	@Id
	@Column(length=9)
	private String dni;
	
	@Column(length=20)
	private String nombre;
	
	@Column(length=20)
	private String especialidad;
	
}
