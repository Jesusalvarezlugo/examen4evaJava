package servicios;

import java.util.Scanner;

public class MenuImplementacion implements MenuInterfaz  {

	
	@Override
	public int mostrarMenuYSeleccionPrin(Scanner sc) {
		
		int opcion;
		
		System.out.println("######################");
		System.out.println("0. Salir de la aplicacion");
		System.out.println("1. Registro de llegada");
		System.out.println("2. Listado de consultas");
		System.out.println("######################");
		System.out.println("Elija una opcion: ");
		opcion=sc.nextInt();
		
		return opcion;
	}

	@Override
	public int mostrarMenuYSeleccionList(Scanner sc) {
		
int opcionL;
		
		System.out.println("######################");
		System.out.println("0. Volver al menu principal");
		System.out.println("1. Mostrar consultas");
		System.out.println("2. Imprimir consultas");
		System.out.println("######################");
		System.out.println("Elija una opcion: ");
		opcionL=sc.nextInt();
		
		return opcionL;
	}

	@Override
	public int mostrarMenuYSeleccionEsp(Scanner sc) {
		
		int opcionE;
		
		System.out.println("######################");
		System.out.println("0. Volver al menu de listados");
		System.out.println("1. Psicologia.");
		System.out.println("2. Traumatologia");
		System.out.println("3. Fisioterapia");
		System.out.println("######################");
		System.out.println("Elija una opcion: ");
		opcionE=sc.nextInt();
		
		return opcionE;
		
	}

	

}
