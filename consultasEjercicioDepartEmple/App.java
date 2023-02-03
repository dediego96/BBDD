package consultasEjercicioDepartEmple;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import utilidadeshibernate.GenericJPADAO;

public class App {
	
	public static final String UNIDADPERSISTENCIA = "consultasEjercicioDepartEmple";
	
	private GenericJPADAO<Depart,String> departDAO;
	private GenericJPADAO<Emple,String> empleDAO;
	private String query;
	
	Consumer <Object> imprimirUno = (o) -> System.out.println(o);
	
	Consumer<Object[]> imprimirMuchos;
	
	public App()
	{
		departDAO = new GenericJPADAO<Depart, String>(Depart.class,UNIDADPERSISTENCIA);
		empleDAO = new GenericJPADAO<Emple, String>(Emple.class,UNIDADPERSISTENCIA);
		query = "";
		
		imprimirUno = (o) -> System.out.println(o);
		imprimirMuchos = o -> System.out.println(Arrays.stream(o).reduce((o1,o2) -> o1 + " | " + o2).get());
					
	}

	public static void main(String[] args) {

		App app = new App();
		
		
		//app.consul1();
		//app.consul2();
		//app.consul3();
		//app.consul4();
		//app.consul5();
		//app.consul6();
		//app.consul7();
		//app.consul8();
		//app.consul9();
		//app.consul10();
		//app.consul11();
		//app.consul12();
		//app.consul13();
		//app.consul14();
		//app.consul15();
		//app.consul16();
		//app.consul17();
		//?app.consul18();
		//app.consul19();
		//app.consul20();
		//??app.consul21();
		//app.consul22();
		//app.consul23();
		//??app.consul24();
		//app.consul25();
		//app.consul26();
		//??app.consul27();
		//??app.consul28();
		//app.consul29();
		//app.consul30();
		//app.consul31();
		//app.consul32();
		//app.consul33();
		//app.consul34();
		//app.consul35();
		app.consul53();
		

		
		//app.consul53();

	}
	









	

	private void consul1() {
		
		//1. Obtener los datos completos de los empleados.
		
		empleDAO.findAll().forEach(System.out::println);
		
	}	

	private void consul2() {

		//2. Obtener los datos completos de los departamentos

		departDAO.findAll().forEach(System.out::println);
		
	}	
	
	private void consul3() {
		
		//3. Obtener los datos de los empleados con cargo 'Secretaria'.
		//empleDAO.findAll().stream().filter(e -> e.getCargoE().equals("Secretaria")).forEach(System.out::println);
		
		query = "Select e from Emple e where e.cargoE = 'Secretaria'";
		
		empleDAO.executeQuery(query).forEach(System.out::println);		
		
	}

	private void consul4() {
		
		//4. Obtener el nombre y salario de los empleados.
			
		query = "SELECT e.nomEmp, e.salEmp FROM Emple e";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);;
		
		//empleDAO.executeQuery(query).map((Emple)Emple::getNomEmp()).forEach(System.out::println);		
	
	}
	
	private void consul5() {
		
		//5. Obtener los datos de los empleados vendedores, ordenado por nombre.
			
		query = "SELECT e FROM Emple e ORDER BY e.nomEmp";
		
		empleDAO.executeQuery(query).forEach(System.out::println);		
	
	}
	
	private void consul6() {
		
		//6. Listar el nombre de los departamentos
			
		query = "SELECT d.nombreDpto FROM Depart d";
		
		departDAO.executeQuery(query).forEach(imprimirUno);		
	
	}
	
	private void consul7() {
		// 7. Listar el nombre de los departamentos, ordenado por nombre
		query = "SELECT d.nombreDpto FROM Depart d ORDER BY d.ciudad";
		
		departDAO.executeQuery(query).forEach(imprimirUno);	
	}

	private void consul8() {
		
		//8. Listar el nombre de los departamentos, ordenado por ciudad
		
		query = "SELECT d.nombreDpto FROM Depart d ORDER BY d.ciudad";
		
		departDAO.executeQuery(query).forEach(imprimirUno);	
	
	}
	
	private void consul9() {
		
		//9. Listar el nombre de los departamentos, ordenado por ciudad, en orden inverso
		
		query = "SELECT d.nombreDpto FROM Depart d ORDER BY d.ciudad DESC";
		
		departDAO.executeQuery(query).forEach(imprimirUno);	
		
	}

	private void consul10() {
		// 10. Obtener el nombre y cargo de todos los empleados, ordenado por salario
		
		query = "SELECT e.nomEmp, e.cargoE FROM Emple e ORDER BY e.salEmp";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);
		
	}

	private void consul11() {
		// 11. Obtener el nombre y cargo de todos los empleados, ordenado por cargo y por salario
		
		query = "SELECT e.nomEmp, e.cargoE FROM Emple e ORDER BY e.cargoE, e.salEmp";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);
		
		
	}

	private void consul12() {
		// 12. Obtener el nombre y cargo de todos los empleados, en orden inverso por cargo
		
		query = "SELECT e.nomEmp, e.cargoE FROM Emple e ORDER BY e.cargoE DESC";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);
		
	}

	private void consul13() {
		// 13. Listar los salarios y comisiones de los empleados del departamento 2000
		
		query = "SELECT e.salEmp, e.comisionE FROM Emple e, Depart d WHERE d.codDepto = 2000";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);	
	}
	
	private void consul14() {
		// 14. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por comisión
		
		query = "SELECT e.salEmp, e.comisionE FROM Emple e, Depart d WHERE d.codDepto = 2000 ORDER BY e.comisionE";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);	
		
	}

	private void consul15() {
		// 15. Listar todas las comisiones
		
		query = "SELECT e.comisionE FROM Emple e";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);				
		
		
	}

	private void consul16() {
		// 16. Listar las comisiones que sean diferentes, ordenada por valor
		
		query = "SELECT DISTINCT e.comisionE FROM Emple e ORDER BY e.comisionE DESC";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);	
		
	}

	private void consul17() {
		// 17. Listar los diferentes salarios
		
		query = "SELECT DISTINCT e.salEmp FROM Emple e";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);	
		
	}
	
	private void consul18() {
		// 18. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una
		//bonificación de $500.000, en orden alfabético del empleado
		
		query = "SELECT SUM(e.salEmp + 500.000) FROM Emple e, Depart d WHERE d.codDepto = 3000" ;
		
		empleDAO.executeQuery(query).forEach(imprimirUno);	
		
	}
	
	private void consul19() {
		// 19. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
		
		query = "Select e FROM Emple e WHERE e.comisionE > e.salEmp";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);
	}

	private void consul20() {
		// 20. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
		
		query = "SELECT e FROM Emple e WHERE e.comisionE <= e.salEmp * 0.3";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);;

	}

	private void consul21() {
		// 21. Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo para cada empleado
		
		
		

	}

	private void consul22() {
		// 22. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad
		//es superior al '19.709.802'
		
		query = "SELECT e.salEmp, e.comisionE FROM Emple e WHERE e.nidemp > '19.709.802'";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);

	}

	private void consul23() {
		// 23. Listar los empleados cuyo salario es menor o igual que el 40% de su comisión
		
		query = "SELECT e FROM Emple e WHERE e.salEmp <= e.comisionE * 0.4";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);

	}

	private void consul24() {
		// 24. 	Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra
		//		Z. Liste estos empleados y su cargo por orden alfabético.
		
		query = "SELECT e FROM Emple e WHERE e.nomEmp LIKE 'J%' ORDER BY e.nomEmp";
		
		query = "SELECT e FROM Emple e WHERE JOIN e.nomEmp LIKE 'J%'";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);

	}

	private void consul25() {
		// 25. 	Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del
		//		empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el
		//		informe por el número del documento de identidad
		
		query = "SELECT e.salEmp, e.comisionE, SUM(e.salEmp + e.comisionE), e.nidemp, e.nomEmp "
				+ "FROM Emple e WHERE e.comisionE > 1000000 GROUP BY e.nidemp ORDER BY e.nidemp";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);

	}

	private void consul26() {
		// 26. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión
		
		
		query = "SELECT e.salEmp, e.comisionE, SUM(e.salEmp + e.comisionE), e.nidemp, e.nomEmp "
				+ "FROM Emple e WHERE e.comisionE = 0 GROUP BY e.nidemp ORDER BY e.nidemp";
		
		empleDAO.executeQuery(query).forEach(imprimirMuchos);
	}

	private void consul27() {
		// 27. 	Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como
		//		jefe al empleado con documento de identidad '31.840.269'
		
		query = "SELECT e.nomEmp FROM Emple e WHERE e.salEmp > 1000000 AND e.jefe";
		
		//empleDAO.executeQuery(query).forEach(imprimirUno);

	}

	private void consul28() {
		// 28. Hallar el conjunto complementario del resultado del ejercicio anterior.
		
	}

	private void consul29() {
		// 29. Hallar los empleados cuyo nombre no contiene la cadena “MA”
		
		query = "SELECT e FROM Emple e WHERE e.nomEmp NOT LIKE '__%MA%__'";
		
		empleDAO.executeQuery(query).forEach(imprimirUno);
		
	}

	private void consul30() {
		// 30. 	Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” NI
		//		‘MANTENIMIENTO’, ordenados por ciudad.
		
		query = "SELECT d.nombreDpto FROM Depart d WHERE d.nombreDpto NOT LIKE 'VENTAS' AND NOT LIKE ''"
				+ " ORDER BY d.ciudad";
		departDAO.executeQuery(query).forEach(imprimirUno);
		
	}
	

	
	private void consul53() {
		
		/*
		 	53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que
			dirige. Puede haber empleados que no tengan supervisores, para esto se indicará solamente el
			numero de ellos dejando los valores restantes en NULL.
		 */
		
		query = "SELECT j.nidemp, j.nomEmp, COUNT(e) FROM Emple e JOIN e.jefe j GROUP BY j";
		empleDAO.executeQuery(query).forEach(imprimirMuchos);
		
	}
	
}
