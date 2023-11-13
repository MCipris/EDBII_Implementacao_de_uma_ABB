package br.ufrn.imd.abb;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		ArvoresABB a = new ArvoresABB();

//		a.inserir(30);  
//		a.inserir(40);
//		a.inserir(60);
//		a.inserir(50);
//			
//		System.out.println(a.posicao(a.raiz, 40, 0));
		
		String path = System.getProperty("user.dir")+"/data/arquivo1.txt";
		int elemento = 0;
		File file = new File(path);
		Scanner scanner = new Scanner(file).useDelimiter(" ");		
		
		while (scanner.hasNext()) { 
			elemento = Integer.parseInt(scanner.next());
			a.inserir(elemento);
		}
		
		
//		a.iniciar();

//		System.out.println("Pré Ordem:");
//		a.preOrdem(a.raiz);
//		System.out.println(" ");
//		System.out.println("Simétrica:");
//		a.simetrica(a.raiz);
//		System.out.println(" ");
//
//
//		System.out.println("Pós Ordem:");
//		a.posOrdem(a.raiz);
//		System.out.println(" ");
//
//		System.out.println("Pré Ordem Iterativa:");
//		a.preOrdemIterativa(a.raiz);
//		System.out.println(" ");
//		
//		System.out.println("Pós Ordem Iterativa:");
//		a.posOrdemIterativa(a.raiz);
//		System.out.println(" ");
		 
//		CHEIA
//		COMPLETA
//		ENESIMO 3
//		INSIRA 36
//		CHEIA
//		PREORDEM
//		IMPRIMA 1
//		IMPRIMA 2
//		REMOVA 50
//		INSIRA 15
//		INSIRA 39
//		REMOVA 32
//		POSICAO 15
//		INSIRA 39
//		ENESIMO 5
//		MEDIANA
//		MEDIA 20
//		BUSCAR 36
//		INSIRA 25
//		MEDIANA
		
		}
}
