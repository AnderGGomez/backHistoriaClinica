package co.edu.utp.isc.gia.historia.dto;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class PersonaDTO {
    /**
     * Esta clase define los atributos basicos para una persona.
     * @autor: Anderson Gomez Gomez
     * @param id identificador unico para cada persona.
     * @param nombre primer nombre de la persona, es obligatorio.
     * @param segundoNombre segundo nombre de la persona, es opcional.
     * @param primerApellido primer apellido de la persona, es obligatorio
     * @param segundoApellido segundo apellido de la persona, es obligatorio
     * @param identificacion define el numero de identificacion de una persona,este
     *                       puede ser CC para mayores de edad o TI para los menores
     *                       de edad, obligatorio y unico.
     * @param fechaNacimiento fecha de nacimiento de la persona.
     * @param email es el correo electronico de la persona, debe ser opcional, pero debe ser unico.
     * @param telefono es el numero de telefono de la persona, deber ser opcional, pero debe ser unico.
     * @param sexo es el sexo de la persona, M: masculino y F: femenino
     *
     * */
    private Long    id;
    private String  nombre;
    private String  segundoNombre;
    private String  primerApellido;
    private String  segundoApellido;
    private String  identificacion;
    private Date    fechaNacimiento;
    private String  email;
    private String  telefono;
    private char    sexo;
}
