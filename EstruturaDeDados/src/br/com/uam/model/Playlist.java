package br.com.uam.model;

public class Playlist {
	
	private static Playlist playlistSingleton;
	private String[] playlist;
	private int tamanho;
	private int posicaoPlaylist = 0;

	
	public static synchronized Playlist getPlaylistSingleton() {
		if (playlistSingleton == null) 
			 playlistSingleton = new Playlist();
        
		return playlistSingleton;
    }

	public void criarPlaylist(int umTamanho) {
		if(umTamanho > 0) {
			this.tamanho = umTamanho;				
			playlist = new String[tamanho];
		}
	}
	public boolean naoExistePlaylist() {
		if (this.playlist != null)
			return false;
		else {
			return true;
		}
	}
	
	
	public boolean inserirMusica(String umaMusica) {
		if(posicaoPlaylist < tamanho) {
			playlist[posicaoPlaylist] = umaMusica.toUpperCase();
			posicaoPlaylist++;
			return true;
		} else {
			return false;
		}
	}
	
		
	public boolean removerMusica(String umaMusica) {
		for(int i = 0; i < this.posicaoPlaylist; i++) {
			if(playlist[i].equalsIgnoreCase(umaMusica)) {
				playlistSingleton.redimensionarPlaylist(i);
				posicaoPlaylist--;
				return true;
			}
		}
		return false;
		}
	
	private void redimensionarPlaylist(int umIndice) {
		String musicaTemporaria;
		int contadorAuxiliar = 0;
		
		for(int i = 0; i < this.posicaoPlaylist; i++) {
			musicaTemporaria = playlist[i];
			if(umIndice < i) {
				contadorAuxiliar = i - 1;
				playlist[contadorAuxiliar] = musicaTemporaria;
				playlist[i] = null;
			}
		}	
	}
	
	public String listarTodasMusicas() {
		String listaMusica = "";
		int i = 1;
		for(String musica : playlist) {
			if (musica != null) {
				listaMusica = listaMusica + i + " - " + musica + "\n";
				i++;
			}
		}
		return listaMusica;
	}
	
	public String[] getPlaylist() {
		return playlist;
	}
	
	public String getPlaylist(int indice) {
		return playlist[indice];
	}
	
	public int getPosicaoPlaylist() {
		return posicaoPlaylist;
	}

	public void setPlaylist(String[] umaPlaylist) {
		this.playlist = umaPlaylist;
	}
	
	public void setTamanho(int umTamanho) {
		this.tamanho = umTamanho;
	}
	
	public int getTamanho() {
		return tamanho;
	}
}
