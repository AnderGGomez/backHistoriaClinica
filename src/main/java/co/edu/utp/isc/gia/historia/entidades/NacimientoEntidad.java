package co.edu.utp.isc.gia.historia.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Entity
@Table(name = "ANT_NACIMIENTO")
public class NacimientoEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(length = 15, nullable = false)
    private String tipoParto;

    @Column(length = 15, nullable = false)
    private String tipoNacimiento;

    //FK
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private MedicoEntidad medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "historia_id")
    private HistoriaEntidad historia;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name= "NACIMIENTO_ENFERMEDAD",
    joinColumns = @JoinColumn(name = "nacimiento_id", nullable = false, referencedColumnName = "ID"),
    inverseJoinColumns = @JoinColumn(name = "enfermedad_id", nullable = false, referencedColumnName = "ID"))
    private List<EnfermedadEntidad> enfermedades;
}
