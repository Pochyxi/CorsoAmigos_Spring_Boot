package com.adienerlopez.CorsoAmigos.student;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private long id;
    private String name;
    private String email;
    private LocalDate dob;

    //  Due parole su Transient, nel momento in cui viene messa l'annotazione
    //  Transient possiamo notare che nel getter di age abbiamo messo il return
    // di un int che sono gli anni dello studente, nel momento in cui chiediamo
    // i dati degli studenti, verrà calcolata l'eta e messa nell'oggetto studente
    // nel database la proprietà age non viene inserita, e nella creazione di uno studente

    @Transient
    private Integer age;

    public Student( long id, String name, String email, LocalDate dob ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student( String name, String email, LocalDate dob ) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student() {

    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob( LocalDate dob ) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between( this.dob, LocalDate.now() ).getYears();
    }

    public void setAge( Integer age ) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
