package handlers.payloads;

public class UpdateAgendaPayload {
    private String situation;

    public UpdateAgendaPayload() {}

    public UpdateAgendaPayload(String situation) {
        this.situation = situation;
    }

    public String getSituation() {
        return this.situation;
    }
}
