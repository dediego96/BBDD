package ejercicioSeguros;

import utilidadesmenu.AppMenu;
import utilidadesmenu.MenuItem;

public class App extends AppMenu {
	
	public App ()
	{
		// Cargar opciones de menú
		addOpcion (new MenuItem("Cargar datos", 1, new CargarDatos()));
		addOpcion (new MenuItem("Consultas", 2, new Consultas()));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app = new App ();
		app.run();

	}
}
