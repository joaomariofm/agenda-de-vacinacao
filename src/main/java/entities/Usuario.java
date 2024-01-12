package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private String birthDate;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "logradouro")
    private String street;

    @Column(name = "numero")
    private int number;

    @Column(name = "setor")
    private String sector;

    @Column(name = "cidade")
    private String city;

    @Column(name = "uf")
    private String uf;

    @ManyToMany
    @JoinTable(
        name = "Usuario_Alergia",
        joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "id_alergia", referencedColumnName = "id")
    )
    private List<Alergia> alergias;

    public Usuario() {}

    public Usuario(String name, String birthDate, String sexo, String street, int number, String sector, String city, String uf) {
        this.name = name;
        this.birthDate = birthDate;
        this.sexo = sexo;
        this.street = street;
        this.number = number;
        this.sector = sector;
        this.city = city;
        this.uf = uf;
        this.alergias = new ArrayList<Alergia>();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public String getSexo() {
        return this.sexo;
    }

    public String getStreet() {
        return this.street;
    }

    public int getNumber() {
        return this.number;
    }

    public String getSector() {
        return this.sector;
    }

    public String getCity() {
        return this.city;
    }

    public String getUf() {
        return this.uf;
    }

    public List<Alergia> getAlergias() {
        return this.alergias;
    }

    public void addAlergia(Alergia alergia) {
        this.alergias.add(alergia);
    }
}
