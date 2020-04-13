package br.mack.ps2.persistencia;

import br.mack.ps2.entidade.Pontuacao;

public interface PontuacaoDAO {
    boolean create(Pontuacao pontuacao);
    void read();
}
