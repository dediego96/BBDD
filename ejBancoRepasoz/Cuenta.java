package ejBancoRepasoz;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class Cuenta implements Serializable {

	@EqualsAndHashCode.Include
	
	@Id
	@Column(length = 10, nullable = false)
	private String numCuenta;
	
	@Column(nullable = false)
	private float saldo;
	
	@Singular
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "cuenta_cliente", 
		joinColumns = @JoinColumn(name = "numCuenta"),
		inverseJoinColumns = @JoinColumn(name = "nif"))
	private List<Cliente> clientes;
	
	public void ingresarDinero(float dineroAIngresar) {
		
		if (dineroAIngresar < 0)
			dineroAIngresar = 0;
		
		saldo += dineroAIngresar;
		
	}
	
	public boolean retirarDinero(float dineroARetirar) {
		
		boolean ok = false;
		
		if ((saldo - dineroARetirar) >= valorAvalMax()) {
			saldo -= dineroARetirar;
			ok = true;
		}
		
		return ok;
		
	}
	
	public boolean rrealizarTransferencia(float dineroATransferir) {
		
		boolean ok = false;
		
		if (retirarDinero(dineroATransferir)) {
			saldo -= comisionTransferencia(dineroATransferir);
			ok = true;
		}
		
		return ok;
	}
	
	public float totalAvales() {
		return (float) clientes.stream().mapToDouble(c -> c.getValorMaxAval()).sum();
	}
	
	private float comisionTransferencia(float dineroATransferir) {
		float comision = 0;
		
		if (dineroATransferir == 0)
			comision = 0;
		
		comision = dineroATransferir * getComision();
		
		if (comision > getMaximoComision ())	
			comision = getMaximoComision ();
		
		return comision;
	}
	
	


	
	protected abstract float getMaximoComision();

	protected abstract float getComision();

	public abstract float valorAvalMax();
	
	
}
