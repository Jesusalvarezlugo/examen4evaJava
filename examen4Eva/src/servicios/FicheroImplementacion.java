package servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import dtos.PacienteDto;

public class FicheroImplementacion implements FicheroInterfaz {

	@Override
	public void escribirFichero(String ruta,List<PacienteDto> listaPacientesAnt) {
		
		try {
			FileWriter escritor = new FileWriter(ruta);
			
			
			for(PacienteDto paciente:listaPacientesAnt) {
				
				String contenido=paciente.getNombre()+";"+paciente.getApellidos();
				escritor.write(contenido);
			}
			
			escritor.close();
			
		}catch(IOException e) {
			
			System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
		}
		
		
	}

	@Override
	public void leerFichero(String ruta,List<PacienteDto> listaPacientesAnt) {
		
		try {
			
			FileReader lector = new FileReader(ruta);
			BufferedReader bf = new BufferedReader(lector);
			String linea;
			DateTimeFormatter formater=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			while((linea=bf.readLine())!=null) {
				String[] paciente = linea.split(";");
				PacienteDto pac =  new PacienteDto();
				pac.setDni(paciente[0]);
				pac.setNombre(paciente[1]);
				pac.setApellidos(paciente[2]);
				pac.setEspecialidad(paciente[3]);
				pac.setFechaCita(LocalDateTime.parse(paciente[4],formater));
				pac.setAsistenciaCita(Boolean.parseBoolean(paciente[5]));
				
				listaPacientesAnt.add(pac);
			}
		}catch(IOException  ex) {
			System.out.println("Error al leer las listas");
            ex.printStackTrace();
		}
		
	}
	
	public void crearFichero(String texto) {
		
		try {
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
			LocalDate fechaActual= LocalDate.now();
			String nombreFichero="log-";
			nombreFichero=nombreFichero.concat(fechaActual.format(formatter)).concat(".txt");
			
			
			FileWriter escritor= new FileWriter(nombreFichero,true);
			
			escritor.write(texto.concat("\n"));
			
			escritor.close();
		}catch(IOException e) {
			
		}
		
		
	}
}
