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
		
		path = System.getProperty("user.dir")+"/data/arquivo2.txt";
		file = new File(path);
		scanner = new Scanner(file);
		
		while (scanner.hasNextLine()) {
            String linhaComandos = scanner.nextLine();
            No noPrint;
            if(linhaComandos.equals("CHEIA")) {
            	if(!a.ehCheia(a.raiz)){
            		System.out.println("A árvore não é cheia");
            	} else {
            		System.out.println("A árvore é cheia");
            	}
            } else if(linhaComandos.equals("COMPLETA")) {
            	if(!a.ehCompleta()){
            		System.out.println("A árvore não é completa");
            	} else {
            		System.out.println("A árvore é completa");
            	}
            }  else if(linhaComandos.equals("PREORDEM")) {
            	a.preOrdem(a.raiz);
            	System.out.println();
            	
            }  else if(linhaComandos.equals("MEDIANA")) {
            	noPrint = a.mediana();
                System.out.println(noPrint.valor);       
            } else {
            	String[] comandos = linhaComandos.split(" ");
            	
              if (comandos[0].equals("ENESIMO")) {
              	noPrint = a.enesimoElemento(a.raiz, Integer.parseInt(comandos[1]));
              	System.out.println(noPrint.valor);
              	
              } else if (comandos[0].equals("POSICAO")) {
                  System.out.println(a.posicao(a.raiz, Integer.parseInt(comandos[1]), 0));
                  
              } else if (comandos[0].equals("MEDIA")) {
            	a.imprimirTracos(a.raiz, 0, 30);
              	System.out.println(a.media(Integer.parseInt(comandos[1])));
              	
              } else if (comandos[0].equals("IMPRIMA")) {
                  if (comandos[1].equals("1")) {
                  	a.imprimirTracos(a.raiz, 0, 30);
                  	
                  } else if (comandos[1].equals("2")) {
                  	System.out.println(a.imprimirParenteses(a.raiz));
                  	
                  }
              } else if (comandos[0].equals("INSIRA")) {
                  a.inserir(Integer.parseInt(comandos[1]));
                  
              } else if (comandos[0].equals("REMOVA")) {
                  a.delete(Integer.parseInt(comandos[1]));
                  
              } else if (comandos[0].equals("BUSCAR")) {
                  noPrint = a.busca(a.raiz, Integer.parseInt(comandos[1]));
                  
                  if(noPrint == null) {
                  	System.out.println("Chave não encontrada");
                  } else {
                  	System.out.println("Chave encontrada");
                  }
              }
            } 

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
