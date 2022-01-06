package co.edu.utp.isc.gia.historia.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public abstract class PersonaEntidad {
    /**
     * Esta clase define los atributos basicos para una persona.
     * @autor: Anderson Gomez Gomez
     * @param id identificador unico y autogenerado que permite identificar a cada persona.
     *           -Not Null.
     *           -Unique.
     * @param nombre primer nombre de la persona, es obligatorio.
     *           -Not Null.
     *           -Max length: 15.
     * @param segundoNombre segundo nombre de la persona, es opcional.
     *           -Null.
     *           -Max length: 15.
     * @param primerApellido primer apellido de la persona, es obligatorio
     *           -Not Null
     *           -Max length: 15
     * @param segundoApellido segundo apellido de la persona, es obligatorio
     *           -Not Null
     *           -Max length: 15
     * @param identificacion define el numero de identificacion de una persona,este
     *                       puede ser CC para mayores de edad o TI para los menores
     *                       de edad, obligatorio y unico
     *           -Not Null
     *           -Max length: 11
     * @param fechaNacimiento fecha de nacimiento de la persona.
     *           -Not Null
     * @param email es el correo electronico de la persona, debe ser opcional, pero debe ser unico.
     *           -default Null
     *           -Max length: 40
     * @param telefono es el numero de telefono de la persona, deber ser opcional, pero debe ser unico.
     *           -Null
     *           -Max length: 11
     * @param sexo es el sexo de la persona, M: masculino y F: femenino
     *           -Not Null
     *           -Max length: 1
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Column(nullable = false, length = 15)
    private String  nombre;

    @Column(length = 15)
    private String  segundoNombre;

    @Column(nullable = false, length = 15)
    private String  primerApellido;

    @Column(nullable = false, length = 15)
    private String  segundoApellido;

    @Column(nullable = false, unique = true, length = 11)
    private String  identificacion;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date    fechaNacimiento;

    @Column(nullable = true, unique = true, length = 40)
    private String  email;

    @Column(nullable = true, unique = true, length = 11)
    private String  telefono;

    @Column(nullable = false, length = 1)
    private char    sexo;
}
