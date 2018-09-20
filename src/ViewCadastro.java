import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ViewCadastro {
	private Scanner teclado;
	
	public ViewCadastro() {
		teclado = new Scanner(System.in);
	}
	
	public String mostraMenu(int tamanho) {
		System.out.println("**********MENU**********");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Excluir");
		System.out.println("5 - Pesquisar");
		System.out.println("6 - Sair");
		System.out.println("Quantidade de Carros Cadastrados: " + tamanho);
		System.out.println("************************");
		System.out.println("Op��o: ");
		return teclado.nextLine();
	}
	
	public Carro inserir() {
		Carro umCarro = new Carro();
		System.out.println("INSERIR");
		System.out.println("Modelo: ");
		umCarro.setModelo(teclado.nextLine());
		
		System.out.println("Fabricante: ");
		umCarro.setFabricante(teclado.nextLine());
		
		System.out.println("Cor: ");
		umCarro.setCor(teclado.nextLine());
		
		System.out.println("Ano: ");
		umCarro.setAno(teclado.nextLine());
		
		System.out.println("Valor: ");
		float x =Float.parseFloat( teclado.nextLine());
		
		umCarro.setValor(x);
		
		return umCarro;
		
	}
	
	public void listar(List<Carro> estoque) {
		System.out.println("\n LISTA CADASTRADOS NO ESTOQUE ");
		for(int pos=0; pos < estoque.size(); pos ++) {
			System.out.println("C�digo Ve�culo : " + pos + " : " + estoque.get(pos).toString());
		}
		
	}
	
	public void alterar(List<Carro>estoque) {
		boolean continuar = true;
		int pos=0;
		do {
			System.out.println(" Digite o c�digo do ve�culo que deseja alterar: ");
			try {
				pos =  Integer.parseInt(teclado.nextLine());
				if(pos >= 0 & pos< estoque.size()) {
					continuar = false;
				}else {
					System.out.println("Digite um c�digo v�lido: ");
				}
				
			}catch(Exception e) {
				System.out.println("C�DIGO DIGITADO INV�LIDO!!!!");
				
			}
			
		}while(continuar);
		
		System.out.println("Modelo (" + estoque.get(pos).getModelo()+ "): ");
		estoque.get(pos).setModelo(teclado.nextLine());
		
		System.out.println("Fabricante ("+ estoque.get(pos).getFabricante()+ "): ");
		estoque.get(pos).setFabricante(teclado.nextLine());
		
		System.out.println("Cor(" + estoque.get(pos).getCor()+ "): ");
		estoque.get(pos).setCor(teclado.nextLine());
		
		System.out.println("Ano ("+ estoque.get(pos).getAno()+ "): ");
		estoque.get(pos).setAno(teclado.nextLine());
		
		System.out.println("Valor ("+ estoque.get(pos).getValor() + "): ");
		float x =Float.parseFloat( teclado.nextLine());
		estoque.get(pos).setValor(x);
	}
	
	public void excluir(List<Carro>estoque) {
		System.out.println("Digite o c�digo do ve�culo que deseja excluir: ");
		int n = Integer.parseInt(teclado.nextLine());
		System.out.println("REALMENTE DESEJA EXCLUIR?");
		System.out.println("S ou N ?");
		String confere = teclado.nextLine();
		if(confere.equals("s")) {
			estoque.remove(n);
			System.out.println("Excluido com Sucesso");
		}if(confere.equals("n")){
			
		}if(!confere.equals("s") & !confere.equals("n")){
			System.out.println("DIGITE UMA OP��O V�LIDA!!");
		}
		
	}
	
	public void pesquisar(List<Carro>estoque) {
		System.out.println("Digite o modelo a ser pesquisado: ");
		String modelo = teclado.nextLine();
		boolean controle = true;
		for(int pos=0; pos< estoque.size(); pos++) {
			if(estoque.get(pos).getModelo().equals(modelo)) {
				System.out.println("C�digo do ve�culo: "+ pos + " : " + estoque.get(pos).toString());
				controle= false;
			}
		}
		if(controle==true) {
			System.out.println("Modelo n�o Encontrado!!");
		}
	}
	
	public void sair() {
		System.out.println("Voc� optou por sair do sistema! At� a pr�xima...");
		System.exit(0);
	}
	
	public void invalido() {
		System.out.println("\nOP��O INV�LIDA!!!!\n");
		System.out.println("Selecione umas das op��es v�lidas, conforme o MENU\n");
	}

}
