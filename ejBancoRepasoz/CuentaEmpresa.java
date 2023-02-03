package ejBancoRepasoz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@SuperBuilder

@Entity

public class CuentaEmpresa extends Cuenta implements Serializable {

	public static final float COMISION = 0.001f;
	public static final float MAXIMOCOMISION = 6f;
	
	@Column(nullable = false)
	private String cifEmpresa;
	
	@Column(nullable = false)
	private String nombreEmpresa;	
	
	@Column(nullable = false)
	private boolean localPropio;

	@Override
	public float valorAvalMax() {
		return totalAvales() * 2;
	}
	
	@Override
	public float getComision() {
		// TODO Auto-generated method stub
		return COMISION;
	}

	@Override
	public float getMaximoComision() {
		// TODO Auto-generated method stub
		return MAXIMOCOMISION;
	}
	
}
