package entities;

import java.sql.Date;
import javax.persistence.*;
import enums.Situacao;

@Entity
public class Agenda {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
   private int id;

    @Column(name = "data")
    private String date;

    @Column(name = "hora")
    private String hour;

    @Column(name = "situacao")
    private Situacao situation;

    @Column(name = "data_situacao")
    private String situationDate;

    @Column(name = "observacao")
    private String observation;

    @ManyToOne
    @JoinColumn(name = "id_vacina", referencedColumnName = "id")
    private Vacina vacina;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    public Agenda() {}

    public Agenda(String date, String hour, Situacao situation, String situationDate, String observation, Vacina vacina, Usuario usuario) {
        this.date = date;
        this.hour = hour;
        this.situation = situation;
        this.situationDate = situationDate;
        this.observation = observation;
        this.vacina = vacina;
        this.usuario = usuario;
    }

    public int getId() {
        return this.id;
    }

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public Situacao getSituation() {
        return this.situation;
    }

    public String getSituationDate() {
        return this.situationDate;
    }

    public String getObservation() {
        return this.observation;
    }

    public Vacina getVacina() {
        return this.vacina;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }
}
