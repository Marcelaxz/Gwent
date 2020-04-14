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
            System.out.println("\t2. Atualizar Pontuação");
            System.out.println("\t3. Deletar Pontuação");
            System.out.println("\t4. Consultar Pontuações");
            System.out.println("\t5. Sair");
            System.out.print("Escolha uma opção:_ ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.update();
                    break;
                case 3:
                    this.delete();
                    break;
                case 4:
                    this.read();
                    break;
                case 5:
                    System.out.println("Operação finalizada");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        } while (opc != 5);
    }

    private void create() {
        Pontuacao p = new Pontuacao();
        System.out.println("\n----- Registro de Pontuação no Gwent -----");

        System.out.print("\nInforme o código do registro: ");
        p.setIdcodigo(in.nextInt());
        in.nextLine();

        System.out.print("Data da pontuação: ");
        p.setData(in.next());

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

    private void update(){
        Pontuacao p = new Pontuacao();
        while(true){
            read();
            System.out.println("\nPara cancelar a operação, digite 1: ");
            int cnl = in.nextInt();
            if (cnl == 1) {
                break;
            }
            System.out.print("\nInforme o código do registro: ");
            p.setIdcodigo(in.nextInt());
            in.nextLine();

            System.out.print("Data da pontuação: ");
            p.setData(in.next());

            System.out.print("1ª Rodada: ");
            p.setP_rodada(in.nextInt());

            System.out.print("2ª Rodada: ");
            p.setS_rodada(in.nextInt());

            System.out.print("3ª Rodada: ");
            p.setT_rodada(in.nextInt());

            if (dao.update(p)) {
                System.out.println("\nPontuação atualizada com sucesso!");
            } else {
                System.out.println("\nOcorreu um problema ao atualizar a pontuação");
            }
        }

    }

    private void delete() {
        while (true) {
            read();
            System.out.println("\nPara cancelar a operação, digite 1: ");
            int cnl = in.nextInt();
            if (cnl == 1) {
                break;
            }
            System.out.print("\nPara remover, digite o código do registro: ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc <= 0) {
                System.out.println("Esta opção não é válida!");
            } else {
                if (dao.delete(opc)) {
                    System.out.println("Pontuação " + opc +
                            " removida com sucesso");
                } else {
                    System.out.println("OPS: falha ao tentar remover");
                }
            }
        }
    }

    private void read() {
        System.out.println("\n ----- Pontuações Registradas -----");
        dao.read();
    }
}

