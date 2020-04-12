package br.com.uam.controller;

import javax.swing.JOptionPane;

import br.com.uam.model.Playlist;

public class MenuController {

	public static void interacaoCriarPlaylist() {

		if (Playlist.getPlaylistSingleton().naoExistePlaylist()) {
			String umTamanho = JOptionPane.showInputDialog(null, "Quantas m�sicas você quer adicionar?", "CRIAR PLAYLIST",
					JOptionPane.PLAIN_MESSAGE);

			if (umTamanho == null || !umTamanho.matches("[0-9]+")) {
				JOptionPane.showMessageDialog(null, "Valor inv�lido.", "TAMANHO DA PLAYLIST",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				Playlist.getPlaylistSingleton().setTamanho(Integer.parseInt(umTamanho));
				Playlist.getPlaylistSingleton().criarPlaylist(Playlist.getPlaylistSingleton().getTamanho());
			}

		} else {
			JOptionPane.showMessageDialog(null, "J� existe uma playlist criada! \nSó � poss�vel criar uma Playlist",
					"CRIAR PLAYLIST", JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void retornaTamanhoPlaylist() {

		if (Playlist.getPlaylistSingleton().naoExistePlaylist())
			MenuController.avisoNaoHaPlaylist("TAMANHO DA PLAYLIST");

		else {
			JOptionPane
					.showMessageDialog(null,
							"Sua playlist tem capacidade para " + Playlist.getPlaylistSingleton().getTamanho() + " m�sicas.",
							"TAMANHO DA PLAYLIST", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void interacaoInserirMusica() {

		if (Playlist.getPlaylistSingleton().naoExistePlaylist())
			MenuController.avisoNaoHaPlaylist("INSERIR MÚSICA");

		else {
			String umaMusica = JOptionPane.showInputDialog(null, "Digite o nome da m�sica para adicionar na Playlist",
					"INSERIR M�SICA", JOptionPane.PLAIN_MESSAGE);
			
			if(!VerificaBotoes.verificaBotaoCancelar(umaMusica, "INSERIR MUSICA", "Operação Cancelada")) {

			while (umaMusica.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Caixa vazia. \nDigite o nome da m�sica", "INSERIR M�SICA",
						JOptionPane.INFORMATION_MESSAGE);
				umaMusica = JOptionPane.showInputDialog(null, "Digite o nome da m�sica para adicionar na Playlist",
						"INSERIR M�SICA", JOptionPane.PLAIN_MESSAGE);
				VerificaBotoes.verificaBotaoCancelar(umaMusica, "INSERIR MUSICA", "Operação Cancelada");
			}

			if (Playlist.getPlaylistSingleton().inserirMusica(umaMusica))
				JOptionPane.showMessageDialog(null, "M�sica inserida com sucesso!", "INSERIR M�SICA",
						JOptionPane.INFORMATION_MESSAGE);
			else {
				JOptionPane.showMessageDialog(null, "Playlist cheia!", "INSERIR M�SICA",
						JOptionPane.INFORMATION_MESSAGE);
			}
			}
		}

	}

	public static void interacaoRemoverMusica() {

		if (Playlist.getPlaylistSingleton().naoExistePlaylist())
			MenuController.avisoNaoHaPlaylist("REMOVER MÚSICA");

		else if (Playlist.getPlaylistSingleton().getPosicaoPlaylist() == 0) {
			JOptionPane.showMessageDialog(null, "N�o h� elementos para remover, lista vazia.", "REMOVER M�SICA",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			String umaMusica = JOptionPane.showInputDialog(null, "Digite o nome da m�sica que você deseja remover da Playlist",
					"REMOVER M�SICA", JOptionPane.PLAIN_MESSAGE);
			VerificaBotoes.verificaBotaoCancelar(umaMusica, "INSERIR MUSICA", "Operação Cancelada");
			
			if (Playlist.getPlaylistSingleton().removerMusica(umaMusica)) {
				JOptionPane.showMessageDialog(null, "M�sica removida com sucesso!", "REMOVER M�SICA",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "M�sica n�o encontrada", "REMOVER M�SICA",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}
	

	public static void listarMusicas() {

		if (Playlist.getPlaylistSingleton().naoExistePlaylist()) {
			MenuController.avisoNaoHaPlaylist("LISTA DE MÚSICAS");

		}
		if (Playlist.getPlaylistSingleton().getPosicaoPlaylist() == 0) {
			JOptionPane.showMessageDialog(null, "Lista vazia", "LISTA DE M�SICAS",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, Playlist.getPlaylistSingleton().listarTodasMusicas(),
					"LISTA DE M�SICAS", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public static void interacaoReproduzirMusica() {
		if (Playlist.getPlaylistSingleton().naoExistePlaylist()) {
			MenuController.avisoNaoHaPlaylist("REPRODUZIR MÚSICA");

		}
		else if (Playlist.getPlaylistSingleton().getPosicaoPlaylist() == 0)
			JOptionPane.showMessageDialog(null, "Lista vazia!",
					"REPRODUZIR MÚSICA", JOptionPane.INFORMATION_MESSAGE);

		else {
			JOptionPane.showMessageDialog(null, Playlist.getPlaylistSingleton().listarTodasMusicas(),
					"LISTA DE MÚSICAS", JOptionPane.INFORMATION_MESSAGE);
			String num = JOptionPane.showInputDialog(null, "Insira o número da música para reproduzir",
					"REPRODUZIR MÚSICA", JOptionPane.PLAIN_MESSAGE);
			
			if(!VerificaBotoes.verificaBotaoCancelar(num, "REPRODUZIR MÚSICA", "Operação Cancelada")) {
			
				if(num == null || !num.matches("[0-9]+") || num.isEmpty()){
						JOptionPane.showMessageDialog(null, "Número inválido", "REPRODUZIR MÚSICA",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
	
					if (Integer.parseInt(num) <= 0 || Integer.parseInt(num) > Playlist.getPlaylistSingleton().getTamanho()) {
	
						JOptionPane.showMessageDialog(null, "Número inválido", "REPRODUZIR MÚSICA",
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, Playlist.getPlaylistSingleton().getPlaylist(Integer.parseInt(num) - 1), "REPRODUZINDO MÚSICA",
									JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		}

	}

	private static void avisoNaoHaPlaylist(String umMetodo) {
		JOptionPane.showMessageDialog(null, "N�o foi criada uma playlist", umMetodo, JOptionPane.INFORMATION_MESSAGE);
	}
}
