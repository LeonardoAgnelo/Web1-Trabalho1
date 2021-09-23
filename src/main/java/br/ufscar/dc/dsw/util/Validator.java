package br.ufscar.dc.dsw.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator<T> {
    private final String nomeCampo;
    private final T valor;
    private final List<String> erros;

    public Validator(String nomeCampo, T valor) {
        this.nomeCampo = nomeCampo;
        this.valor = valor;
        erros = new ArrayList<String>();
    }

    public Validator<T> required() {
        if (valor == null || valor.toString().isEmpty()) {
            erros.add(nomeCampo + " não informado!");
        }

        return this;
    }

    public Validator<T> email() {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = java.util.regex.Pattern.compile(ePattern);
        Matcher m = p.matcher(valor.toString());
        
        if (!m.matches()) {
            erros.add("Email inválido!");
        }

        return this;
    }

    public Validator<T> compare(String value) {
        if (!value.equals(valor)) {
            erros.add(nomeCampo + " diferente!");
        }

        return this;
    }

    public Boolean validate() {
        if (!erros.isEmpty()) {
            return false; 
        }

        return true;
    }

    public String getErro() {
        if (!erros.isEmpty()) {
            return erros.get(0); 
        }

        return "";
    }

    public Erro addErro(Erro erro) {
        if (!validate()) {
            erro.add(getErro());
        }

        return erro;
    }
}
