package br.mack.ps2;

import br.mack.ps2.persistencia.PontuacaoDAOMySQL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PontuacaoDAOMySQL mysqlDAO = new PontuacaoDAOMySQL();
        Menu menu = new Menu(mysqlDAO);
        menu.iniciar();
    }
}
