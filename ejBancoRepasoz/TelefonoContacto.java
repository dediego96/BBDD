package ejBancoRepasoz;

import java.io.Serializable;
import java.util.List;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder

@Entity
public class TelefonoContacto implements Serializable {

	@EqualsAndHashCode.Include
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@Column(length = 10, nullable = false)
	private String numTel;
	
	@Column(length = 10, nullable = false)
	private String companyia;
}
