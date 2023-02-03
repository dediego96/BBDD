package ejercicioSeguros;

import java.io.Serializable;

import javax.annotation.processing.Generated;
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
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString

@Entity

public class Enfermedades implements Serializable {

	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idAlergia;
	
	@Column(nullable = false)
	private boolean corazon;
	
	@Column(nullable = false)
	private boolean estomacal;
	
	@Column(nullable = false)
	private boolean rinyones;
	
	@Column(nullable = false)
	private boolean alergia;
	
	@Column(nullable = true)
	private String nombreAlergia;
	
}
