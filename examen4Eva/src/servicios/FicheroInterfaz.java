package servicios;

import java.util.List;

import dtos.PacienteDto;

public interface FicheroInterfaz {
	
	public void escribirFichero(String ruta,List<PacienteDto> listaPacientesAnt);
	
	public void leerFichero(String ruta,List<PacienteDto> listaPacientesAnt);
	
	public void crearFichero(String texto);

}
