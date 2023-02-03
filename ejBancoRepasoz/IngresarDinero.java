package ejBancoRepasoz;

import daw.com.Teclado;
import utilidadesmenu.MenuAction;

public class IngresarDinero extends AcctionBanco implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub

		Cuenta c;
		
		do {
			c = cuentaDAO.findById(Teclado.leerString("\nDime el numero de cuenta para ingresar: ")).orElse(null);			
		} while (c == null);
		
		c.ingresarDinero(Teclado.leerFloat("\nDinero a ingresar: "));
		
		cuentaDAO.update(c);
			
		
	}

}
