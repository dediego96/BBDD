	package ejBancoRepasoz;

import utilidadesmenu.AppMenu;
import utilidadesmenu.MenuItem;

public class App extends AppMenu{

	public App() {
		
		addOpcion(new MenuItem("Cargar datos", 9, new CargarDatos()));
		addOpcion(new MenuItem("Crear cuenta", 1, new CrearCuenta()));
		addOpcion(new MenuItem("Ingresar dinero", 2, new IngresarDinero()));
		addOpcion(new MenuItem("Retirar dinero", 3, new RetirarDinero()));
		addOpcion(new MenuItem("Consultas", 4, new Consultas()));
		
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		app.run();

	}

}
