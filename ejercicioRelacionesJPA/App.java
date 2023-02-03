package ejercicioRelacionesJPA;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import daw.com.Pantalla;
import daw.com.Teclado;
import utilidadeshibernate.GenericJPADAO;

public class App {

	private final String PERSISTENCE_UNIT = "ejerRelacionesJPA";		
	
	private GenericJPADAO <Profesor,String> profesorDAO;
	private GenericJPADAO <Grupo,String> grupoDAO;		
	private GenericJPADAO <Alumno,String> alumnoDAO;
	private GenericJPADAO <Modulo,String> moduloDAO;
	private GenericJPADAO <Calificacion,Integer> calificacionDAO;
	
	public App() {
		
		profesorDAO = new GenericJPADAO(Profesor.class,PERSISTENCE_UNIT);		
		grupoDAO = new GenericJPADAO(Grupo.class,PERSISTENCE_UNIT);
		alumnoDAO = new GenericJPADAO(Alumno.class,PERSISTENCE_UNIT);
		moduloDAO = new GenericJPADAO(Modulo.class,PERSISTENCE_UNIT);
		calificacionDAO = new GenericJPADAO(Calificacion.class,PERSISTENCE_UNIT);
	}
	
	public static void main(String[] args) {
		
		App app = new App();
		
		app.insertarDatos();
		
		app.ponerNotas();
		
		app.menu();
		/*
		
		
		
		GenericJPADAO <Depart,String> departDAO ;
		String PERSISTENCE_UNIT = "unoamuchos";

		departDAO = new GenericJPADAO (Depart.class,PERSISTENCE_UNIT);

		Depart depart = createDepart();
		
		departDAO.save(depart);
		
		departDAO.findAll().forEach(System.out::println);
		*/
		
	}

	private void menu() {

		int opc = 0;
		
		do {
			Pantalla.escribirString("\nMENU APP");
			Pantalla.escribirString("\n--------");
			Pantalla.escribirString("\n");
			Pantalla.escribirString("\n1)Listar los alumnos de un grupo.");
			Pantalla.escribirString("\n2)Listar los distintos módulos que cursan los alumnos de un grupo.");
			Pantalla.escribirString("\n3)Eliminar un alumno.");
			Pantalla.escribirString("\n4)Eliminar todos los alumnos de un grupo.");
			Pantalla.escribirString("\n5)Subir un punto a todos los alumnos en un módulo.");
			Pantalla.escribirString("\n6)Mostrar los alumnos aprobados de un módulo.");
			Pantalla.escribirString("\n7)Salir.");
			
			opc = Teclado.leerInt("\n");
			
		} while(opc < 1 && opc > 7);

		
		switch (opc) {

			case 1: {
				listarPorGrupo();
				break;		
			}
			case 2: {
				listarModulosDeAlumnos();
				break;
			}
			case 3: {
				eliminarUnAlumno();
				break;
			}
			case 4: {
				eliminarAlumnosDeGrupo();
				break;
			}
			case 5: {
				subirPuntoAlumnosModulo();
				break;
			} 
			case 6: {
				mostrarAlumnosModulo();
				break;
			}
		}
		if (opc != 7)
			menu();
	}

	private void subirPuntoAlumnosModulo() {
		
		String id = Teclado.leerString("\nDime el id del modulo");
		Modulo m = moduloDAO.findById(id).orElse(new Modulo());
		
		List<Calificacion> calificaciones = calificacionDAO.findAll();
		
		
		calificaciones.stream().
			filter(c-> c.getModulo().equals(m)).
			forEach(c -> c.setNota(c.getNota() + 1));
		
		calificaciones.forEach(calificacionDAO::update);
		
	}

	private void eliminarAlumnosDeGrupo() {
		
		Grupo g = grupoDAO.findById(Teclado.leerString("\nDime el nombre del grupo")).orElse(new Grupo());
		
		g.getAlumnos().forEach(alumnoDAO::delete);		
	
		
	}

	private void eliminarUnAlumno() {
		
		String dni = Teclado.leerString("Dime el dni del alumno");
		
		Alumno a = new Alumno(dni);
		
		alumnoDAO.delete(a);
		
	}

	private void mostrarAlumnosModulo() {
		
		Modulo m = moduloDAO.findById(Teclado.leerString("\nDime el id del modulo")).orElse(new Modulo());
		
		
		List <Calificacion> calificaciones = calificacionDAO.findAll();
		
		Pantalla.escribirString("\n");
		
		calificaciones.stream().
			filter(c -> c.getModulo().equals(m)).
			filter(c -> c.getNota() > 4).
			map(c -> "Nombre: " + c.getAlumno().getNombre() + ", Nota: " + c.getNota()).
			forEach(System.out::println);
		
	}

	private void listarModulosDeAlumnos() {
		
		Grupo g = grupoDAO.findById(Teclado.leerString("\nDime el nombre del grupo")).orElse(new Grupo());
		Set<Alumno> alumnos = g.getAlumnos();
		
		List<Calificacion> calificaciones = (List<Calificacion>) calificacionDAO.findAll();
 		calificaciones.stream().filter(c -> alumnos.contains(c.getAlumno())).
 				map(Calificacion::getModulo).
 				map(Modulo::getNombre).
 				forEach(System.out::println);
		
	}

	private void listarPorGrupo() {

		String grupo = Teclado.leerString("\nDime el nombre del grupo");
		
		Grupo g = grupoDAO.findById(grupo).orElse(new Grupo());//.get();//.ifPresent(g -> g.getAlumnos().stream().forEach(System.out::println));
		
		
		Set<Alumno> alumnos = g.getAlumnos();
		List<Calificacion> calificaciones = calificacionDAO.findAll();
		
		//Calificacion c;
		if (alumnos == null) {
			Pantalla.escribirString("\nEl grupo no existe");
		} else {
			for (Alumno a: alumnos) {
				
				Pantalla.escribirString("\nDni: " + a.getDni());
				Pantalla.escribirString("\nNombre: " + a.getNombre() + "\n");
				calificaciones.stream().filter(c -> c.getAlumno().equals(a)).map(c -> "Nota: " + c.getNota()).forEach(System.out::println);
			
			}
		}
	}

	private void ponerNotas() {

		Calificacion c;
		Alumno a;
		Modulo m;
		
		a = alumnoDAO.findById("12345678Y").get();
		m = moduloDAO.findById("DAM1").get();
		c = Calificacion.builder().modulo(m).alumno(a).nota(3).build();
		calificacionDAO.save(c);
		
		a = alumnoDAO.findById("88585852Y").get();
		m = moduloDAO.findById("DAM1").get();
		c = Calificacion.builder().modulo(m).alumno(a).nota(4).build();
		calificacionDAO.save(c);
		
		a = alumnoDAO.findById("66664445Y").get();
		m = moduloDAO.findById("DAM2").get();
		c = Calificacion.builder().modulo(m).alumno(a).nota(5).build();
		calificacionDAO.save(c);
		
		a = alumnoDAO.findById("12323699Y").get();
		m = moduloDAO.findById("DAM2").get();
		c = Calificacion.builder().modulo(m).alumno(a).nota(6).build();
		calificacionDAO.save(c);
		
		a = alumnoDAO.findById("99999999Y").get();
		m = moduloDAO.findById("ASIR1").get();
		c = Calificacion.builder().modulo(m).alumno(a).nota(7).build();
		calificacionDAO.save(c);
		
		a = alumnoDAO.findById("88884400Y").get();
		m = moduloDAO.findById("ASIR2").get();
		c = Calificacion.builder().modulo(m).alumno(a).nota(8).build();
		calificacionDAO.save(c);
		
		
	}

	private void insertarDatos() {
		
		Profesor p1 = Profesor.builder().
				dni("00000000T").
				nombre("Juanito").
				especialidad("Informatica").
				build();
		
		Profesor p2 = Profesor.builder().
				dni("11111111T").
				nombre("Pedro").
				especialidad("Matematicas").
				build();
		
		profesorDAO.save(p1);
		profesorDAO.save(p2);
		
		Direccion d1 = Direccion.builder().calle("Falsa").portal(123).poblacion("Madrid").build();Direccion d2 = Direccion.builder().calle("Omega").portal(1).poblacion("Madrid").build();
		Direccion d3 = Direccion.builder().calle("Everlin Terras").portal(5).poblacion("Madrid").build();
		Direccion d4 = Direccion.builder().calle("Lardero").portal(21).poblacion("Barcelona").build();
		Direccion d5 = Direccion.builder().calle("Falsisima").portal(80).poblacion("Barcelona").build();
		Direccion d6 = Direccion.builder().calle("Nose la calle").portal(8).poblacion("Barcelona").build();
		
		Alumno a1 = Alumno.builder().
				dni("12345678Y").
				nombre("Carla").
				fecNac(LocalDate.of(1990, 5, 22)).
				direccion(d1).
				build();
		
		Alumno a2 = Alumno.builder().
				dni("88585852Y").
				nombre("Ahri").
				fecNac(LocalDate.of(1985, 12, 5)).
				direccion(d2).
				build();
		
		Alumno a3 = Alumno.builder().
				dni("66664445Y").
				nombre("Nasus").
				fecNac(LocalDate.of(1990, 11, 9)).
				direccion(d3).
				build();
		
		Alumno a4 = Alumno.builder().
				dni("12323699Y").
				nombre("Negan").
				fecNac(LocalDate.of(1990, 8, 25)).
				direccion(d4).
				build();
		
		Alumno a5 = Alumno.builder().
				dni("99999999Y").
				nombre("Cristina").
				fecNac(LocalDate.of(1990, 1, 12)).
				direccion(d5).
				build();
		
		Alumno a6 = Alumno.builder().
				dni("88884400Y").
				nombre("Juanjo").
				fecNac(LocalDate.of(1990, 2, 2)).
				direccion(d6).
				build();
		/*
		alumnoDAO.save(a1);
		alumnoDAO.save(a2);
		alumnoDAO.save(a3);
		alumnoDAO.save(a4);
		alumnoDAO.save(a5);
		alumnoDAO.save(a6);
		*/
		Grupo g1 = Grupo.builder().
				nombre("Grupo1").
				ubicacion("Madrid").
				tutor(p1).
				alumno(a1).
				alumno(a2).
				alumno(a3).
				build();
		
		Grupo g2 = Grupo.builder().
				nombre("Grupo2").
				ubicacion("Barcelona").
				tutor(p1).
				alumno(a4).
				alumno(a5).
				alumno(a6).
				build();
		
		grupoDAO.save(g1);
		grupoDAO.save(g2);
		
		
		Modulo m1 = Modulo.builder().
				id("DAM1").
				nombre("md1").
				profesor(p1).
				build();
		
		Modulo m2 = Modulo.builder().
				id("DAM2").
				nombre("dm2").
				profesor(p1).
				build();
		
		Modulo m3 = Modulo.builder().
				id("ASIR1").
				nombre("as1").
				profesor(p2).
				build();
		
		Modulo m4 = Modulo.builder().
				id("ASIR2").
				nombre("asr2").
				profesor(p2).
				build();
		
		moduloDAO.save(m1);
		moduloDAO.save(m2);
		moduloDAO.save(m3);
		moduloDAO.save(m4);
		
	}
	
}
