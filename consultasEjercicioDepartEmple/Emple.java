package consultasEjercicioDepartEmple;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

public class Emple {
	
	@EqualsAndHashCode.Include
	@NonNull
	
	@Id
	@Column(length = 12, nullable = false)
	private String nidemp;
	
	@Column(length = 30, nullable = false)
	private String nomEmp;
	
	@Enumerated(value=EnumType.STRING)
	@Column(length = 1, nullable = false)
	private SexoEmp sexEmp;
	
	@Column(nullable = false)
	private LocalDate fecNac;
	
	@Column(nullable = false)
	private LocalDate fecIncorporacion;
	
	@Column(nullable = false)
	private float salEmp;
	
	@Column(nullable = false)
	private float comisionE;
	
	@Column(length = 15, nullable = false)
	private String cargoE;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "jefeID", nullable = true)
	private Emple jefe;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codDepto", nullable = false)
	private Depart depto;

	@Override
	public String toString() {
		return "Emple [nDIEmp=" + nidemp + ", nomEmp=" + nomEmp + ", sexEmp=" + sexEmp + ", fecNac=" + fecNac
				+ ", fecIncorporacion=" + fecIncorporacion + ", salEmp=" + salEmp + ", comisionE=" + comisionE
				+ ", cargoE=" + cargoE + ", jefe=" + (jefe != null?jefe.getNidemp():"sin jefe") + ", depto=" + depto.getCodDepto() + "]";
	}
	
	

}


