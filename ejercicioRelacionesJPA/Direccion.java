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
//@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@NoArgsConstructor
@AllArgsConstructor

@Entity
//@Column(name="nombre",length=20)
public class Direccion implements Serializable {

	@EqualsAndHashCode.Include
	
	@Id
	@GeneratedValue (strategy = GenerationType.TABLE)
	private Integer idDireccion;
	@Column(length=50)
	private String calle;
	@Column(length=5)
	private int portal;
	@Column(length=20)
	private String poblacion;
	
}
