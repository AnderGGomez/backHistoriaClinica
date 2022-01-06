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
@Table(name = "ANT_PERSONAL")
public class PersonalEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Column(nullable = false)
    private String  descripcion;

    @Column(nullable = false)
    private String  estado;

    @Temporal(TemporalType.DATE)
    private Date    fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="historia_id")
    private HistoriaEntidad historia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id")
    private MedicoEntidad medico;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "PERSONAL_ENFERMEDAD",
            joinColumns = @JoinColumn(name="personal_id", nullable = false, referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "enfermedad_id", nullable = false, referencedColumnName = "ID")
    )
    private List<EnfermedadEntidad> enfermedades;
}
