package br.mack.ps2.entidade;

public class Pontuacao {
    private int idcodigo;
    private String data;
    private int p_rodada;
    private int s_rodada;
    private int t_rodada;
    private int total;

    public void setIdcodigo(int idcodigo) {
        this.idcodigo = idcodigo;
    }

    public int getIdcodigo() {
        return idcodigo;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setP_rodada(int p_rodada) {
        this.p_rodada = p_rodada;
    }

    public int getP_rodada() {
        return p_rodada;
    }

    public void setS_rodada(int s_rodada) {
        this.s_rodada = s_rodada;
    }

    public int getS_rodada() {
        return s_rodada;
    }

    public void setT_rodada(int t_rodada) {
        this.t_rodada = t_rodada;
    }

    public int getT_rodada() {
        return t_rodada;
    }

    public int getTotal(){
        int tt = p_rodada+s_rodada+t_rodada;
        return tt;
    }
}
