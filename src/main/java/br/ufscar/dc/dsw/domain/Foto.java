package br.ufscar.dc.dsw.domain;

public class Foto {
    private Integer idPacote;
    private String url;

    public Foto(Integer idPacote, String url) {
        this.setIdPacote(idPacote);
        this.setUrl(url);
    }

    public Integer getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Integer idPacote) {
        this.idPacote = idPacote;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
