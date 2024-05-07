package dtos;

import java.time.LocalDateTime;
import java.util.Date;

public class PacienteDto {
	
	//Atributos
	
	long idPaciente;
	

	String nombre;
	String apellidos;
	String dni;
	String especialidad;
	LocalDateTime fechaCita;
	boolean asistenciaCita;
	
	//Getters y Setters
	
	public long getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(long idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public LocalDateTime getFechaCita() {
		return fechaCita;
	}
	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}
	public boolean isAsistenciaCita() {
		return asistenciaCita;
	}
	public void setAsistenciaCita(boolean asistenciaCita) {
		this.asistenciaCita = asistenciaCita;
	}
	
	//Constructores
	
	public PacienteDto() {
		
	}
	
	public PacienteDto(long idPaciente, String nombre, String apellidos, String dni, String especialidad,
			LocalDateTime fechaCita, boolean asistenciaCita) {
		super();
		this.idPaciente = idPaciente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.especialidad = especialidad;
		this.fechaCita = fechaCita;
		this.asistenciaCita = asistenciaCita;
	}
	
	//ToString
	
	@Override
	public String toString() {
		return "PacienteDto [idPaciente=" + idPaciente + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni="
				+ dni + ", especialidad=" + especialidad + ", fechaCita=" + fechaCita + ", asistenciaCita="
				+ asistenciaCita + "]";
	}
	
	public String enseñarCitas() {
		
		String nombreCompleto=apellidos+" "+nombre;
		String texto="Nombre Completo: "+nombreCompleto+","+"Hora: "+fechaCita.getHour();
		
		return texto;
	}

}
