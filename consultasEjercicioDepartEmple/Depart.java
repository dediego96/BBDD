package consultasEjercicioDepartEmple;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

@Entity

public class Depart {

	@EqualsAndHashCode.Include
	@NonNull
	
	@Id
	@Column(name="coddepto", length = 4, nullable = false)
	private String codDepto;
	
	@Column(name ="nombredepto", length = 20, nullable = false)
	private String nombreDpto;
	
	@Column(length = 25, nullable = false)
	private String ciudad;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codDirector", nullable = true)
	private Emple director;

	@Override
	public String toString() {
		return "Depart [codDepto=" + codDepto + ", nombreDpto=" + nombreDpto + ", ciudad=" + ciudad + ", director="
				+ director.getNidemp() + "]";
	}
	
}