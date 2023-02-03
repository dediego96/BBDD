package ejercicioSeguros;

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
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString

@Entity

public class Cobertura implements Serializable {

	@EqualsAndHashCode.Include
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@Column(nullable = false)
	private boolean oftalmologia;
	
	@Column(nullable = false)
	private boolean dental;
	
	@Column(nullable = false)
	private boolean fecundacionInVitro;
	
}
