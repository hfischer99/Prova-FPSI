import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ViewCadastro {
	private Scanner teclado;
	
	public ViewCadastro() {
		teclado = new Scanner(System.in);
	}
	
	public String mostraMenu() {
		System.out.println("**********MENU**********");
		System.out.println("1 - Inserir");
		System.out.println("2 - Listar");
		System.out.println("3 - Alterar");
		System.out.println("4 - Excluir");
		System.out.println("5 - Pesquisar");
		System.out.println("6 - Sair");
		System.out.println("************************");
		System.out.println("Opção: ");
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
		
		return umCarro;
		
	}
	
	public void listar(List<Carro> estoque) {
		System.out.println("\n LISTA CADASTRADOS NO ESTOQUE ");
		for(int pos=0; pos < estoque.size(); pos ++) {
			System.out.println("Código Veículo : " + pos + " : " + estoque.get(pos).toString());
		}
		
	}
	
	public void alterar(List<Carro>estoque) {
		boolean continuar = true;
		int pos=0;
		do {
			System.out.println(" Digite o código do veículo que deseja alterar: ");
			try {
				pos =  Integer.parseInt(teclado.nextLine());
				if(pos >= 0 & pos< estoque.size()) {
					continuar = false;
				}else {
					System.out.println("Digite um código válido: ");
				}
				
			}catch(Exception e) {
				System.out.println("CÓDIGO DIGITADO INVÁLIDO!!!!");
				
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
	}
	
	public void excluir(List<Carro>estoque) {
		System.out.println("Digite o código do veículo que deseja excluir: ");
		int n = Integer.parseInt(teclado.nextLine());
		estoque.remove(n);
	}
	
	public void pesquisar(List<Carro>estoque) {
		System.out.println("Digite o modelo a ser pesquisado: ");
		String modelo = teclado.nextLine();
		boolean controle = true;
		for(int pos=0; pos< estoque.size(); pos++) {
			if(estoque.get(pos).getModelo().equals(modelo)) {
				System.out.println("Código do veículo: "+ pos + " : " + estoque.get(pos).toString());
				controle= false;
			}
		}
		if(controle==true) {
			System.out.println("Modelo não Encontrado!!");
		}
	}

}
