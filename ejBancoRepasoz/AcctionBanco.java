package ejBancoRepasoz;

import java.util.Arrays;
import java.util.function.Consumer;

import utilidadeshibernate.GenericJPADAO;

public class AcctionBanco {

	private static final String UNIDAD_PERSISTENCIA = "ejercicioBanco";

	protected static GenericJPADAO<Cuenta, String> cuentaDAO = new GenericJPADAO<Cuenta, String>(Cuenta.class,
			UNIDAD_PERSISTENCIA);
	
	protected static GenericJPADAO<Cliente, String> clienteDao = new GenericJPADAO<Cliente, String>(Cliente.class,
			UNIDAD_PERSISTENCIA);

	protected static Consumer<Object[]> imprimirMuchos = 
			o -> System.out.println(Arrays.stream(o).reduce((o1, o2) -> o1 + " | " + o2).get());
			
	protected static Consumer<Object> imprimirUno = (o) -> System.out.println(o);
	
	protected static Runnable sinDatos = () -> System.out.println("Sin datos"); 	
	
}
