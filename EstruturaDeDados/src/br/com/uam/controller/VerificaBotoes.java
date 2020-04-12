package br.com.uam.controller;

import javax.swing.JOptionPane;

public class VerificaBotoes {
	
	public static boolean verificaBotaoCancelar(String umaString, String umTitulo, String umaMensagem) {
		if(umaString == null) {
			JOptionPane.showMessageDialog(null, umaMensagem, umTitulo, JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		return false;
	}
}
