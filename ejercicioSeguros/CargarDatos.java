package ejercicioSeguros;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.function.Consumer;

import javax.persistence.Column;

import utilidadesmenu.MenuAction;

public class CargarDatos extends AccionBanco implements MenuAction {

	@Override
	public void doMenuAction() {

		Consumer<Object[]> imprimirMuchos = 
				o -> System.out.println(Arrays.stream(o).reduce((o1,  o2) -> o1 + " | " + o2).get());

		
		Cobertura c1 = Cobertura.builder().oftalmologia(true).dental(false).fecundacionInVitro(false).build();
		Cobertura c2 = Cobertura.builder().oftalmologia(false).dental(true).fecundacionInVitro(false).build();
		Cobertura c3 = Cobertura.builder().oftalmologia(false).dental(false).fecundacionInVitro(true).build();
		
		Enfermedades e1 = Enfermedades.builder().
				corazon(true).estomacal(false).rinyones(false).alergia(false).nombreAlergia("Alergia 1").
				build();
		Enfermedades e2 = Enfermedades.builder().
				corazon(false).estomacal(true).rinyones(false).alergia(false).nombreAlergia("Alergia 2").
				build();
		Enfermedades e3 = Enfermedades.builder().
				corazon(false).estomacal(false).rinyones(true).alergia(false).nombreAlergia("Alergia 3").				
				build();
		
		AsistenciaMedica a1 = AsistenciaMedica.builder().
				breveDescripcion("pasaron cosas").
				lugar("Madrid").
				explicacion("buah ikk¡o").
				tipoAsistencia("una").
				fecha(LocalDate.of(2022, 1, 1)).
				hora(LocalTime.now()).
				importe(10000).
				build();
		
		AsistenciaMedica a2 = AsistenciaMedica.builder().
				breveDescripcion("pasaron cosas nazis").
				lugar("Madrid").
				explicacion("aaaaaaaaaaaaaaaaaaaaaaaa").
				tipoAsistencia("dos").
				fecha(LocalDate.of(2022, 12, 1)).
				hora(LocalTime.now()).
				importe(300000).
				build();
		
		AsistenciaMedica a3 = AsistenciaMedica.builder().
				breveDescripcion("si o q pasaron cosas").
				lugar("Madrid").
				explicacion("buah ikk¡o").
				tipoAsistencia("tres").
				fecha(LocalDate.of(2023, 1, 1)).
				hora(LocalTime.now()).
				importe(20000).
				build();
		
		Seguro s1 = Seguro.builder().
				nif("001").
				nombre("nbS1").ape1("ape1_1").ape2("ape2_1").
				edad(26).sexo(Sexo.M).
				casado(false).numHijos(0).embarazada(false).
				cobertura(c1).enfermedades(e1).
				fechaCreacion(LocalDate.of(2023,  1, 15)).
				asistenciasMedica(a1).
				build();
		
		Seguro s2 = Seguro.builder().
				nif("002").
				nombre("nbS2").ape1("ape1_2").ape2("ape2_2").
				edad(55).sexo(Sexo.M).
				casado(false).numHijos(0).embarazada(false).
				cobertura(c2).enfermedades(e2).
				fechaCreacion(LocalDate.of(2022,  5, 19)).
				asistenciasMedica(a2).
				build();
		
		Seguro s3 = Seguro.builder().
				nif("003").
				nombre("nbS3").ape1("ape1_3").ape2("ape2_3").
				edad(70).sexo(Sexo.M).
				casado(false).numHijos(0).embarazada(false).
				cobertura(c3).enfermedades(e3).
				fechaCreacion(LocalDate.of(2022,  10, 2)).
				asistenciasMedica(a3).
				build();
		
		seguroDAO.save(s1);
		seguroDAO.save(s2);
		seguroDAO.save(s3);
		
		System.out.println("Datos cargados correctamente");
		
		
	}

}
