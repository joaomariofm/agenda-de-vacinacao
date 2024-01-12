package handlers.payloads;

public class CreateUsuarioPayload {
    private String name;

    private String birthDate;

    private String sexo;

    private String street;

    private int number;

    private String sector;

    private String city;

    private String uf;

    private int[] alergias;

    public CreateUsuarioPayload() {}

    public CreateUsuarioPayload(String name, String birthDate, String sexo, String street, int number, String sector, String city, String uf, int[] alergias) {
        this.name = name;
        this.birthDate = birthDate;
        this.sexo = sexo;
        this.street = street;
        this.number = number;
        this.sector = sector;
        this.city = city;
        this.uf = uf;
        this.alergias = alergias;
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

    public int[] getAlergias() {
        return this.alergias;
    }
}
