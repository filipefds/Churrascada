package pooa20171.iff.br.churrascada.realm;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by filipefds on 22/07/17.
 */

public class Evento extends RealmObject {

    @PrimaryKey
    int id;
    String cep;
    String logradouro;
    String complemento;
    String bairro;
    String localidade;
    String uf;
    String ibge;
    String numero;
    String nomeEvento;
    String homem;
    String mulher;
    String crianca;
    String totalGasto;
    String rateioH;
    String rateioM;


    public Evento() {}

    public Evento(int id, String cep, String logradouro, String complemento, String bairro, String localidade, String uf, String ibge, String numero, String nomeEvento, String homem, String mulher, String crianca, String totalGasto, String rateioH, String rateioM) {
        this.id = id;
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.ibge = ibge;
        this.numero = numero;
        this.nomeEvento = nomeEvento;
        this.homem = homem;
        this.mulher = mulher;
        this.crianca = crianca;
        this.totalGasto = totalGasto;
        this.rateioH = rateioH;
        this.rateioM = rateioM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getHomem() {
        return homem;
    }

    public void setHomem(String homem) {
        this.homem = homem;
    }

    public String getMulher() {
        return mulher;
    }

    public void setMulher(String mulher) {
        this.mulher = mulher;
    }

    public String getCrianca() {
        return crianca;
    }

    public void setCrianca(String crianca) {
        this.crianca = crianca;
    }

    public String getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(String totalGasto) {
        this.totalGasto = totalGasto;
    }

    public String getRateioH() {
        return rateioH;
    }

    public void setRateioH(String rateioH) {
        this.rateioH = rateioH;
    }

    public String getRateioM() {
        return rateioM;
    }

    public void setRateioM(String rateioM) {
        this.rateioM = rateioM;
    }

}
