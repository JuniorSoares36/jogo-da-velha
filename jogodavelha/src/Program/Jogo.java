package Program;

import java.util.Scanner;

import javax.swing.JOptionPane;

import entities.Tabuleiro;

public class Jogo {

	private Tabuleiro tabuleiro = new Tabuleiro();
	private boolean ganhou;
	Scanner sc = new Scanner(System.in);
	private int vez = 2;
	int linha;
	int coluna;

	public void iniciar() {
		while (!ganhou) {
			loop();
		}
	}

	private void loop() {
		if (vez == 2) {
			vez = 1;
		} else {
			vez = 2;
		}
		this.imprimeCabecalho();
		this.imprimeTabuleiro();
		this.pegarEntradaUsuario();
		this.marcarTabuleiro();
		this.validarGanhador();

	}

	private void imprimeCabecalho() {
		System.out.println(" ############# JOGO DA VELHA ##############\r\n\n");
		System.out.println(" ### JOGADOR 1 = X ");
		System.out.println(" ### JOGADOR 2 = O \n");
	}

	public void imprimeTabuleiro() {
		this.tabuleiro.imprimirTabuleiro();
	}

	public void pegarEntradaUsuario() {
		
		String jogador = vez == 1 ? "Jogador 1" : "Jogador 2";
		
		System.out.println("\n" + jogador + " Digite a linha\n");
		linha = sc.nextInt();
		System.out.println("\n" + jogador + " Digite a coluna\n");
		coluna = sc.nextInt();
	}

	private void marcarTabuleiro() {
		char sinal = vez == 1 ? 'x' : 'o';
		this.tabuleiro.marcar(sinal, linha, coluna);
	}

	public void validarGanhador() {
		boolean xGanhou = tabuleiro.verificarGanhador('x');
		boolean oGanhou = tabuleiro.verificarGanhador('o');

		if (xGanhou) {
			JOptionPane.showConfirmDialog(null, "Jogador 1 ganhou");
			this.ganhou = true;
		}

		if (oGanhou) {
			JOptionPane.showMessageDialog(null, "Jogador 2 ganhou");
			this.ganhou = true;
		}
	}

}
