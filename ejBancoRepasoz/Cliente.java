package ejBancoRepasoz;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity

public class Cliente implements Serializable {

	@EqualsAndHashCode.Include
	
	@Id
	@Column(length = 15, nullable = false)
	private String nif;
	
	@Column(length = 30, nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private float valorMaxAval;
	
	@Singular
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "idTelefono")	
	private List<TelefonoContacto> telefonos;
}
