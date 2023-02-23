package arkham.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.EAGER;
import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.*;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "appointment_id_gen")
    @SequenceGenerator(name = "appointment_id_gen", sequenceName = "appointment_id_seq", allocationSize = 1)
    private Long id;

    private LocalDate date;


    @ManyToOne(cascade = {REFRESH,DETACH,MERGE, PERSIST})
    private Patient patient;

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Doctor doctor;

    @ManyToOne(cascade = {REFRESH, DETACH, MERGE, PERSIST})
    private Department department;


    @Transient
    private Long patientId;
    @Transient
    private Long doctorId;

    @Transient
    private Long departmentId;


}
