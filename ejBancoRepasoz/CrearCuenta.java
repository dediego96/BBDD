package ejBancoRepasoz;

import java.util.ArrayList;
import java.util.List;

import daw.com.Teclado;
import utilidadesmenu.MenuAction;

public class CrearCuenta extends AcctionBanco implements MenuAction {

	@Override
	public void doMenuAction() {

		int tipo;
		String nifCliente, numCuenta;
		Cliente c;
		List<Cliente> clientes = new ArrayList<>();
		String opc;
		Cuenta cu;
		
		do
		{
			tipo = Teclado.leerInt("tipo de cuenta (1. personal - 2. empresa)");
		}while (tipo != 1 && tipo != 2);
		
		Cuenta cuenta = tipo== 1 ? new CuentaPersonal() : new CuentaEmpresa();
		
		do {
			
			nifCliente = Teclado.leerString("\nNif titular: ");
			c = clienteDao.findById(nifCliente).orElse(null);			
			
			if (c == null)				
				c = crearCliente();
				
			clientes.add(c);
			
			opc = Teclado.leerString("Otro Cliente?");
			
		} while(opc.equals("s"));
		
		do {
			numCuenta = Teclado.leerString("Dime el numero de la nueva cuenta: ");
			cu = cuentaDAO.findById(numCuenta).orElse(null);
		} while(cu!=null);
		
		
		cuenta.setNumCuenta(numCuenta);
		cuenta.setSaldo(Teclado.leerFloat("\nDime el saldo: "));
		
		if (cuenta instanceof CuentaPersonal personal) {
			
			personal.setTarjetaCredito(Teclado.leerString("\\nTarjeta? s/n").equals("s"));
			
		} else if (cuenta instanceof CuentaEmpresa empresa) {
			
			empresa.setCifEmpresa(Teclado.leerString("\ncif :"));
			empresa.setNombreEmpresa(Teclado.leerString("\nnombre :"));
			empresa.setLocalPropio(Teclado.leerString("\ndispone de local propio(S/N)").equalsIgnoreCase("s"));
			
		}
		
		cuentaDAO.save(cuenta);


	}
	
	private Cliente crearCliente() {
		return Cliente.builder().nombre(Teclado.leerString("\nNombre: ")).valorMaxAval(Teclado.leerFloat("\nAval maximo: ")).build();
		
	}

	private Cuenta traerCuenta(String num) {
		
		return cuentaDAO.findById(num).orElse(null);
		
	}

}
