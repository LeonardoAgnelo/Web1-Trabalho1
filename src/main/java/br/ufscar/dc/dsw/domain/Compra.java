package br.ufscar.dc.dsw.domain;

import java.sql.Timestamp;

public class Compra {
    private Long id;
    private Cliente cliente;
    private PacoteTuristico pacoteTuristico;
    private Timestamp dataReuniao;
    private String linkReuniao;

    public Compra(Long id, Cliente cliente, PacoteTuristico pacoteTuristico, Timestamp dataReuniao,
            String linkReuniao) {
        this.setId(id);
        this.setCliente(cliente);
        this.setPacoteTuristico(pacoteTuristico);
        this.setDataReuniao(dataReuniao);
        this.setLinkReuniao(linkReuniao);
    }

    public Compra(Cliente cliente, PacoteTuristico pacoteTuristico, Timestamp dataReuniao,
            String linkReuniao) {
        super();
        this.setCliente(cliente);
        this.setPacoteTuristico(pacoteTuristico);
        this.setDataReuniao(dataReuniao);
        this.setLinkReuniao(linkReuniao);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PacoteTuristico getPacoteTuristico() {
        return pacoteTuristico;
    }

    public void setPacoteTuristico(PacoteTuristico pacoteTuristico) {
        this.pacoteTuristico = pacoteTuristico;
    }

    public Timestamp getDataReuniao() {
        return dataReuniao;
    }

    public void setDataReuniao(Timestamp dataReuniao) {
        this.dataReuniao = dataReuniao;
    }

    public String getLinkReuniao() {
        return linkReuniao;
    }

    public void setLinkReuniao(String linkReuniao) {
        this.linkReuniao = linkReuniao;
    }
}
