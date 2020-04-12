package br.com.uam.model;

import javax.swing.JOptionPane;

import br.com.uam.controller.MenuController;
import br.com.uam.controller.VerificaBotoes;

public class Menu {

    public static void menuPrincipal() {
        String menu;

        do {
            menu = JOptionPane.showInputDialog(null,
                     "1 - Criar Playlist\n"
                    + "2 - Tamanho da Playlist\n"
                    + "3 - Inserir M�sica\n"
                    + "4 - Remover M�sica\n"
                    + "5 - Listar M�sicas\n"
                    + "6 - Reproduzir M�sica\n"
                    + "0 - Sair\n\n"
                    + "                     Escolha uma op��o:", "PLAYLIST", JOptionPane.PLAIN_MESSAGE);

            if(VerificaBotoes.verificaBotaoCancelar(menu, "PLAYER", "Fim do Programa!")) {
            	return;
            }

            switch (menu) {
                case "1":
                	MenuController.interacaoCriarPlaylist();
                	break;
                case "2":
                	MenuController.retornaTamanhoPlaylist();
                	break;
                case "3":
                	MenuController.interacaoInserirMusica();
                	break;
                case "4":
                	MenuController.interacaoRemoverMusica();
                    break;
                case "5":
                	MenuController.listarMusicas();
                    break;
                case "6":
                	MenuController.interacaoReproduzirMusica();
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Fim do Programa", "PLAYLIST", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Op��o inv�lida", "PLAYLIST", JOptionPane.ERROR_MESSAGE);
            }
        } while (!menu.equals("0"));
    }
}