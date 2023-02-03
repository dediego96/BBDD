package ejBancoRepasoz;

import java.util.Arrays;
import java.util.function.Consumer;

import utilidadesmenu.MenuAction;

public class CargarDatos extends AcctionBanco implements MenuAction {

	private Consumer<Object[]> imprimirMuchos = 
			o -> System.out.println(Arrays.stream(o).reduce((o1, o2) -> o1 + " | " + o2).get()); 
	
	private Consumer<Object> imprimirUno = (o) -> System.out.println(o);
	
	
	@Override
	public void doMenuAction() {

		TelefonoContacto t11 = TelefonoContacto.builder().numTel("111111111").companyia("Movistar").build();
		TelefonoContacto t12 = TelefonoContacto.builder().numTel("222222222").companyia("Movistar").build();
		
		TelefonoContacto t21 = TelefonoContacto.builder().numTel("333333333").companyia("Orange").build();
		TelefonoContacto t22 = TelefonoContacto.builder().numTel("444444444").companyia("Movistar").build();
		
		TelefonoContacto t31 = TelefonoContacto.builder().numTel("555555555").companyia("Orange").build();
		TelefonoContacto t32 = TelefonoContacto.builder().numTel("666666666").companyia("Orange").build();
		
		Cliente c1 = Cliente.builder()
				.nif("nifCliente1")
				.nombre("clienete1").
				valorMaxAval(2000).
				telefono(t11).
				telefono(t12).
				build();
		
		Cliente c2 = Cliente.builder()
				.nif("nifCliente2")
				.nombre("clienete2").
				valorMaxAval(5000).
				telefono(t21).
				telefono(t22).
				build();		
		
		Cliente c3 = Cliente.builder()
				.nif("nifCliente3")
				.nombre("clienete3").
				valorMaxAval(10000).
				telefono(t31).
				telefono(t32).
				build();
		
		Cuenta cuenta1 = CuentaPersonal.builder().
				numCuenta("001").
				saldo(5000).
				cliente(c1).
				tarjetaCredito(true).
				build();

		Cuenta cuenta2 = CuentaEmpresa.builder().
				numCuenta("002").
				saldo(15000).
				cifEmpresa("000BB").
				nombreEmpresa("mi empresa").
				localPropio(false).
				cliente(c2).
				cliente(c1).
				build();

		Cuenta cuenta3 = CuentaEmpresa.builder().
				numCuenta("003").
				saldo(-10000).
				cifEmpresa("000CC").
				nombreEmpresa("otra empresa").
				localPropio(true).
				cliente(c3).
				build();
		
		
		cuentaDAO.save(cuenta1);
		cuentaDAO.save(cuenta2);
		cuentaDAO.save(cuenta3);
	}

}
