package arkham.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

/**
 * @author :ЛОКИ Kelsivbekov
 * @created 17.02.2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = SEQUENCE,generator = "hospital_id_gen")
    @SequenceGenerator(name = "hospital_id_gen", sequenceName = "hospital_id_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String address;



    @OneToMany(cascade = {ALL}, fetch = LAZY)
    private List<Doctor> doctors = new ArrayList<>();

    @OneToMany(mappedBy = "hospital", fetch = LAZY)
    private List<Patient> patients = new ArrayList<>();

    @OneToMany(cascade = {ALL}, fetch = LAZY)
    private List<Department> departments = new ArrayList<>();


    @OneToMany(cascade = {ALL}, fetch = LAZY)
    private List<Appointment> appointments = new ArrayList<>();
}
