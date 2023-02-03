package ejercicioSeguros;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString

@Entity

public class AsistenciaMedica implements Serializable {

	@EqualsAndHashCode.Include
	
	@Id	
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idAsistenciaMedica;
	
	@Column(length = 100, nullable = false)
	private String breveDescripcion;
	
	@Column(length = 20, nullable = false)
	private String lugar;
	
	@Column(nullable = false)
	private String explicacion;
	
	@Column(nullable = false)
	private String tipoAsistencia;
	
	@Column(length = 20, nullable = false)
	private LocalDate fecha;
	
	@Column(nullable = false)
	private LocalTime hora;
	
	@Column(nullable = false)
	private float importe;
	
}
