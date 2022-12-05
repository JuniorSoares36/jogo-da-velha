package entities;

import javax.swing.JOptionPane;

public class Tabuleiro {
	private char [] [] casas = new char [3] [3];
	
	public Tabuleiro() {
		initTabuleiro();
	}
	
	public void initTabuleiro() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				casas[i][j] = '.';
			}
		}
	}
	
	public void imprimirTabuleiro() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(casas[i][j] + "   ");
				
			}
			System.out.println("\n");
		}
	}
	
	public void marcar(char sinal, int linha, int coluna) {
		if(casas[linha][coluna] != '.') {
			JOptionPane.showMessageDialog(null, "Casa inválida");
		}else {
			casas[linha][coluna] = sinal;
		}
		
	}
	
	public boolean verificarGanhador(char sinal) {
		boolean horizontalLinha1 = casas[0][0] == sinal && casas[0][1] == sinal && casas[0][2] == sinal;
		boolean horizontalLinha2 = casas[1][0] == sinal && casas[1][1] == sinal && casas[1][2] == sinal;
		boolean horizontalLinha3 = casas[2][0] == sinal && casas[2][1] == sinal && casas[2][2] == sinal;
		
		boolean linhas = horizontalLinha1 || horizontalLinha2 || horizontalLinha3;
		
		boolean verticalColuna1 = casas[0][0] == sinal && casas[1][0] == sinal && casas[2][0] == sinal;
		boolean verticalColuna2 = casas[0][1] == sinal && casas[1][1] == sinal && casas[2][1] == sinal;
		boolean verticalColuna3 = casas[0][2] == sinal && casas[1][2] == sinal && casas[2][2] == sinal;
		boolean colunas = verticalColuna1 || verticalColuna2 || verticalColuna3;
		
		boolean diagonal1 = casas[0][0] == sinal && casas[1][1] == sinal && casas[2][2] == sinal;
		boolean diagonal2 = casas[2][0] == sinal && casas[1][1] == sinal && casas[0][2] == sinal;
		boolean diagonais = diagonal1 || diagonal2;
		
		if(linhas || colunas || diagonais) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Tabuleiro t = new Tabuleiro();
		
		t.marcar('x', 2, 0);
		t.marcar('x', 1, 1);
		t.marcar('x', 0, 2);
		t.imprimirTabuleiro();
		t.verificarGanhador('x');
	}
}
