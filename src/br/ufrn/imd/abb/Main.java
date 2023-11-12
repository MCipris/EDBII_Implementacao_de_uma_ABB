package br.ufrn.imd.abb;

public class Main {
	public static void main(String[] args) {

		ArvoresABB a = new ArvoresABB();

		a.raiz = new No (30);  

		a.iniciar();

		System.out.println("Pré Ordem:");
		a.preOrdem(a.raiz);
		System.out.println(" ");
		System.out.println("Simétrica:");
		a.simetrica(a.raiz);
		System.out.println(" ");


		System.out.println("Pós Ordem:");
		a.posOrdem(a.raiz);
		System.out.println(" ");

		System.out.println("Pré Ordem Iterativa:");
		a.preOrdemIterativa(a.raiz);
		System.out.println(" ");
		
		System.out.println("Pós Ordem Iterativa:");
		a.posOrdemIterativa(a.raiz);
		System.out.println(" ");
		 
		}
}
