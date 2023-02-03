package ejBancoRepasoz;

import daw.com.Teclado;
import utilidadesmenu.MenuAction;

public class RetirarDinero extends AcctionBanco implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub

		String msj;
		
		Cuenta c;
		
		do {
			c = cuentaDAO.findById(Teclado.leerString("\nDime el numero de cuenta para retirar: ")).orElse(null);			
		} while (c == null);
		
		if (c.retirarDinero(Teclado.leerFloat("\nDinero a ingresar: "))) {
			msj = "Dinero retirado";
			cuentaDAO.update(c);
		} else
			msj = "Error al realizar el retiro";
		
		System.out.println(msj);		
		
		
	}

}
