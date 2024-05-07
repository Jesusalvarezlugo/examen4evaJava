package servicios;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import dtos.PacienteDto;

public class OperativaImplementacion implements OperativaInterfaz {

	@Override
	public void registroPacientes(List<PacienteDto> listaPacientesAntg) {
		
		Scanner sc = new Scanner(System.in);
		String pacienteDni;
		LocalDate fechaActual=LocalDate.now();
		System.out.println("Introduzca su dni: ");
		pacienteDni=sc.next();
		
		while(validarDni(pacienteDni)==false) {
			
			System.out.println("[ERROR] Dni erroneo . ");
			System.out.println("Introduzca su dni: ");
			pacienteDni=sc.next();
		}
		LocalDate soloFecha; 
		boolean encontrarDni=false;
		
		for(PacienteDto paciente:listaPacientesAntg) {
			
			soloFecha=paciente.getFechaCita().toLocalDate();
			if(paciente.getDni()==pacienteDni && fechaActual==soloFecha) {
				
				System.out.println("Espere su turno para la consulta de "+paciente.getEspecialidad()+" en la sala de espera. Su especialista le avisará.");
				encontrarDni=true;
				break;
			}
		}
		
		if(encontrarDni==false) {
			
			System.out.println("No se encontro su cita.");
		}
	}

	
	@Override
	public void listadoPacientes(List<PacienteDto> listaPacientesAntg,Scanner sc) {
		
		int opcionL;
		int opcionEsp;
		boolean cerrarMenuL=false;
		boolean cerrarMenuEsp=false;
		MenuInterfaz mi = new MenuImplementacion();
		
		while(!cerrarMenuL) {
			
			opcionL=mi.mostrarMenuYSeleccionList(sc);
			
			switch(opcionL) {
			
			case 0:
					System.out.println("[INFO] se volvera al menu principal.");
					cerrarMenuL=true;
				break;
				
			case 1:
				System.out.println("[INFO] se accedera al menu para mostrar las consultas.");
				
				
				while(!cerrarMenuEsp) {
					
					opcionEsp=mi.mostrarMenuYSeleccionEsp(sc);
					
					switch(opcionEsp) {
					
					case 0:
						System.out.println("[INFO] Se volvera al menu de listados.");
						cerrarMenuEsp=true;
						break;
						
					case 1:
						System.out.println("[INFO] Psicologia.");
						mostrarPsico(listaPacientesAntg,sc);
						break;
						
					case 2:
						break;
						
					case 3:
						break;
						
					default:
						break;
					}
					
				}
				
				break;
				
			case 2:
				System.out.println("[INFO] se accedera al menu para imprimir  las consultas.");
				opcionEsp=mi.mostrarMenuYSeleccionEsp(sc);
				break;
				
			default:
				System.out.println("[ERROR] Opcion introducida no valida.");
				break;
			}
		}
		
	}
	
	private void mostrarPsico(List<PacienteDto> listaPacientesAntg,Scanner sc) {
		
		String fechaAElegir;
		LocalDate soloFecha;
		System.out.println("Elija una fecha (dd-MM-yyyy): ");
		fechaAElegir=sc.next();
		DateTimeFormatter formater= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fecha=LocalDate.parse(fechaAElegir,formater);
		
		
		for(int i=0;i<listaPacientesAntg.size();i++) {
			soloFecha=listaPacientesAntg.get(i).getFechaCita().toLocalDate();
			if(listaPacientesAntg.get(i).getEspecialidad()=="Psicología" && fecha==soloFecha) {
				
				listaPacientesAntg.get(i).enseñarCitas();
				
			}else {
				break;
			}
			
			
		}
		
		System.out.println("No hay datos disponibles para la especialidad y fecha indicada.");
	}
	
	private boolean validarDni(String dni) {
		
		String letraDni=dni.substring(dni.length()-1);
		int numDni=Integer.parseInt(dni.substring(0,dni.length()-1));
		
		String[] letrasDniVal= {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E",};
		
		int valorResto=numDni%23;
		return letrasDniVal[valorResto].equals(letraDni);
		
	}
	
	
}
