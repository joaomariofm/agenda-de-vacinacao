package entities;

import javax.persistence.*;
import enums.Periodicidade;

@Entity
public class Vacina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @Column(name = "titulo")
    private String title;

    @Column(name = "descricao")
    private String description;

    @Column(name = "doses")
    private int doses;

    @Column(name = "periodicidade")
    private Periodicidade periodicity;

    @Column(name = "intervalo")
    private int interval;

    public Vacina() {}

    public Vacina(String title, String description, int doses, Periodicidade periodicity, int interval) {
        this.title = title;
        this.description = description;
        this.doses = doses;
        this.periodicity = periodicity;
        this.interval = interval;
    }

    public int getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getDoses() {
        return this.doses;
    }

    public Periodicidade getPeriodicity() {
        return this.periodicity;
    }

    public int getInterval() {
        return this.interval;
    }
}
