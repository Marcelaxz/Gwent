package br.mack.ps2;
import br.mack.ps2.entidade.Pontuacao;
import br.mack.ps2.persistencia.PontuacaoDAO;

import java.util.*;

public class Menu {
    PontuacaoDAO dao;
    Scanner in;

    public Menu(PontuacaoDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n----- Gwent ------");
            System.out.println("\t1. Adicionar Pontuação");
            System.out.println("\t2. Consultar Pontuações");
            System.out.println("\t3. Sair");
            System.out.print("Escolha uma opção:_ ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    System.out.println("Operação finalizada");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 3);
    }

    private void create() {
        Pontuacao p = new Pontuacao();

        System.out.println("\n----- Pontuação no Gwent -----");

        System.out.print("\nInforme a data da pontuação: ");
        p.setData(in.next());
        in.nextLine();

        System.out.print("1ª Rodada: ");
        p.setP_rodada(in.nextInt());

        System.out.print("2ª Rodada: ");
        p.setS_rodada(in.nextInt());

        System.out.print("3ª Rodada: ");
        p.setT_rodada(in.nextInt());

        if (dao.create(p)) {
            System.out.println("\nPontuação adicionada com sucesso!");
        } else {
            System.out.println("\nOcorreu um problema ao adicionar a pontuação");
        }
    }

    private void read() {
        System.out.println("\n ----- Pontuações Registradas -----");
        dao.read();
    }
}
