package handlers.payloads;

public class CreateAgendaPayload {
    private String date; 

    private String hour;

    private String situation;

    private String situationDate;

    private String observation;

    private int vacinaId;

    private int usuarioId;

    public CreateAgendaPayload() {}

    public CreateAgendaPayload(String date, String hour, String situation, String situationDate, String observation, int vacinaId, int usuarioId) {
        this.date = date;
        this.hour = hour;
        this.situation = situation;
        this.situationDate = situationDate;
        this.observation = observation;
        this.vacinaId = vacinaId;
        this.usuarioId = usuarioId;
    }

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public String getSituation() {
        return this.situation;
    }

    public String getSituationDate() {
        return this.situationDate;
    }

    public String getObservation() {
        return this.observation;
    }

    public int getVacinaId() {
        return this.vacinaId;
    }

    public int getUsuarioId() {
        return this.usuarioId;
    }
}
