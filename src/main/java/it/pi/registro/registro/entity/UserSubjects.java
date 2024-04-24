package it.pi.registro.registro.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user_subjects")
@Getter
@Setter
public class UserSubjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private double vote;

    @Column
    private LocalDateTime vote_date;

    @Column
    private String notes;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("userSubjects") // Ignore serialization of User's userSubjects reference
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    @JsonIgnoreProperties("userSubjects") // Ignore serialization of Subject's userSubjects reference
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnoreProperties("userSubjects") // Ignore serialization of User's userSubjects reference
    private User teacher;

    @PrePersist
    public void prePersist(){
        this.vote_date = LocalDateTime.now();
        this.notes = this.notes != null && !this.notes.isEmpty() ? this.notes : "Nessuna Nota Inserita";
    }
}
