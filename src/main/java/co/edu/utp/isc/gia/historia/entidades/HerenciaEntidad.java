package co.edu.utp.isc.gia.historia.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ANT_HEREDITARIO")
public class HerenciaEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Column(length = 15, nullable = false)
    private String  parentesco;

    @Column(nullable = false, length = 15)
    private String  nombre;

    @Column(length = 15)
    private String  segundoNombre;

    @Column(nullable = false, length = 15)
    private String  primerApellido;

    @Column(nullable = false, length = 15)
    private String  segundoApellido;
    @Temporal(TemporalType.DATE)
    private Date    fechaCreacion;

    //Foreing Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historia_id")
    private HistoriaEntidad    historia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private MedicoEntidad    medico;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="HERENCIA_ENFERMEDAD",
            joinColumns = @JoinColumn( name = "herencia_id",nullable = false, referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "enfermedad_id",nullable = false, referencedColumnName = "ID")
    )
    private List<EnfermedadEntidad> enfermedades;
}
