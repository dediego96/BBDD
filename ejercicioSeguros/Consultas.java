package ejercicioSeguros;

import java.util.Arrays;
import java.util.function.Consumer;

import utilidadesmenu.MenuAction;

public class Consultas extends AccionBanco implements MenuAction {

	private String query;
	
	Consumer <Object> imprimirUno = (o) -> System.out.println(o);
	
	Consumer<Object[]> imprimirMuchos;
	
	public Consultas() {
		imprimirUno = (o) -> System.out.println(o);
		imprimirMuchos = o -> System.out.println(Arrays.stream(o).reduce((o1,o2) -> o1 + " | " + o2).get());
		query = "";
	}
	
	@Override
	public void doMenuAction() {

		Consultas app = new Consultas();
		
		query = "Select e FROM Enfermedades e";
		
		query = "Select c FROM Cobertura c";
		
		query = "Select s FROM Seguro s";
		
		enfermedadesDAO.executeQuery(query).forEach(imprimirUno);

	}

}
