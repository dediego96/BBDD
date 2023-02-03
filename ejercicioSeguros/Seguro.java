package ejercicioSeguros;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@ToString

@Entity

public class Seguro implements Serializable {

	@EqualsAndHashCode.Include
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int idSeguro;
	
	@Column(length = 9, nullable = false)
	private String nif;
	
	@Column(length = 20, nullable = false)
	private String nombre;
	
	@Column(length = 20, nullable = false)
	private String ape1;
	
	@Column(length = 20, nullable = false)
	private String ape2;
	
	@Column(nullable = false)
	private int edad;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Column(nullable = false)
	private boolean casado;
	
	@Column(nullable = false)
	private int numHijos;
	
	@Column(nullable = false)
	private boolean embarazada;
	
	@Column(nullable = false)
	private LocalDate fechaCreacion;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idCobertura")
	private Cobertura cobertura;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idEnfermedad")	
	private Enfermedades enfermedades;
	
	@Singular
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "FK_ASIS")	
	private List<AsistenciaMedica> asistenciasMedicas; 
	
	
}
