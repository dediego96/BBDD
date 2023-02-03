package ejBancoRepasoz;

import daw.com.Teclado;
import utilidadesmenu.MenuAction;

public class Consultas extends AcctionBanco implements MenuAction {

	@Override
	public void doMenuAction() {

		int opc;

		do {
			System.out.println("\n1) Consultar saldo de cuenta");
			System.out.println("\n2) Consultar saldo de la entidad financiera");
			System.out.println("\n3) Mejor cliente");
			System.out.println("\n4) Companyia con mas clientes");
			System.out.println("\n5) Cuetas con saldo negativo");

			opc = Teclado.leerInt("opc: ");
		} while (opc > 5);

		switch (opc) {
		case 1: {
			consultaSaldo();
			break;
		}
		case 2: {
			consultaSaldoEntidad();
			break;
		}
		case 3: {
			mejorCliente();
			break;
		}
		case 4: {
			companyiaMasCliente();
			break;
		}
		case 5: {
			cuentasNegativas();
			break;
		}
		}

	}

	private void consultaSaldo() {
		
		/*
			Consultar saldo de una cuenta. La aplicación solicitará el nº de cuenta y
			mostrará todos los datos de la cuenta, incluido el saldo, así como la fecha y
			hora actuales del sistema con el formato como el mostrado “09/03/2012 12:40”.
		 */
		
		Cuenta c;
		String numCuenta;
		
		do {
			numCuenta = Teclado.leerString("\nNuemro de cuenta");
			c = cuentaDAO.findById(numCuenta).orElse(null);
		}while(c == null);
		
		System.out.println(c.toString());

	}

	private void consultaSaldoEntidad() {
		
		/*
		 	Consultar saldo de la entidad financiera. La aplicación mostrará por pantalla el nº
			de cuenta y el saldo de cada una de las cuentas y finalmente el total de la
			entidad, es decir la suma de todos los saldos de todas las cuentas.
		 */
		
		String query = "SELECT SUM(c.saldo) FROM Cuenta c";
		
		cuentaDAO.executeQuerySingleResult(query).ifPresentOrElse(imprimirUno, sinDatos);

	}

	private void mejorCliente() {
		/*
		 	Consultar los datos del cliente que tenga más dinero en el banco, es decir el
			cliente que sumando el saldo de las cuentas en las que participa tenga un valor
			máximo.
		 */
		
		//"Select cli, sum(c.saldo) FROM Cuenta c, Cliente cli WHERE 

		String query = "SELECT cliente, SUM(cuenta.saldo) FROM Cuenta cuenta INNER JOIN cuenta.clientes cliente "
				+ "GROUP BY cliente.nif ORDER BY SUM(cuenta.saldo) DESC"; 


		cuentaDAO.executeQuerySingleResult(query).ifPresentOrElse(imprimirMuchos, sinDatos);
	}

	private void companyiaMasCliente() {
		/*
			Consultar la compañía de telecomunicaciones que más clientes tiene en la
			sucursal.
		*/
		
		String query = "SELECT t.companyia, COUNT(t) FROM Cliente c INNER JOIN c.telefonos t "
				+ "GROUP BY t.companyia ORDER BY COUNT(t) DESC";
		cuentaDAO.executeQuerySingleResult(query).ifPresentOrElse(imprimirMuchos, sinDatos);

	}

	private void cuentasNegativas() {

		/*
		 	Listar las cuentas empresariales con saldo negativo ordenadas de menor a
			mayor, es decir, primero las que más saldo negativo tengan.
		 */

		String query = "SELECT c FROM CuentaEmpresa c where c.saldo < 0 ORDER BY c.saldo";
		
		cuentaDAO.executeQuery(query).forEach(imprimirUno);;
		
	}

}
