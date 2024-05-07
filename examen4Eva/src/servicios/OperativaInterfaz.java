package servicios;

import java.util.List;
import java.util.Scanner;

import dtos.PacienteDto;

public interface OperativaInterfaz {
	
	public void registroPacientes(List<PacienteDto> listaPacientesAntg);
	
	public void listadoPacientes(List<PacienteDto> listaPacientesAntg,Scanner sc);

}
