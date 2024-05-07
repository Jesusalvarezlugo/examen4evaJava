package controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dtos.PacienteDto;
import servicios.FicheroImplementacion;
import servicios.FicheroInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;
import servicios.OperativaImplementacion;
import servicios.OperativaInterfaz;

public class inicio {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int opcionP,opcionL,opcionEsp;
		List<PacienteDto> listaPacientes = new ArrayList<PacienteDto>();
		boolean cerrarMenuP=false;
		MenuInterfaz mi = new MenuImplementacion();
		OperativaInterfaz oi= new OperativaImplementacion();
		FicheroInterfaz fi = new FicheroImplementacion();
		String rutaArchivo="citas.txt";
		
		fi.leerFichero(rutaArchivo, listaPacientes);
		
		
		try {
			while(!cerrarMenuP) {
				
				opcionP=mi.mostrarMenuYSeleccionPrin(sc);
				
				switch(opcionP) {
				
				case 0:
						System.out.println("[INFO] se cerrara la aplicacion.");
						fi.crearFichero("[INFO] se cerrara la aplicacion.");
						cerrarMenuP=true;
					break;
					
				case 1:
					System.out.println("[INFO] Registro de llegada.");
					fi.crearFichero("[INFO] Registro de llegada.");
					oi.registroPacientes(listaPacientes);
					break;
					
				case 2:
					System.out.println("[INFO] Listado de consultas.");
					oi.listadoPacientes(listaPacientes,sc);
					break;
					
				default:
					System.out.println("[ERROR] Oppcion introducida no valida.");
					break;
						
				}
				
				
				
			}
		}catch(Exception e) {
			fi.crearFichero(e.getMessage());
		}
		

	}

}
