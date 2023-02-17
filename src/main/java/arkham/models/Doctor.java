package arkham.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "doctor_id_gen")
    @SequenceGenerator(name = "doctor_id_gen",sequenceName = "doctor_id_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firsName;
    @Column(name = "last_name")
    private String lastName;

    private String position;

    private String email;

    @ManyToMany(mappedBy = "doctors",fetch = LAZY)
    private List<Department> departments = new ArrayList<>();

    @OneToMany(mappedBy = "doctor", fetch = LAZY, cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();
}
