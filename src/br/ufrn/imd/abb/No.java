package br.ufrn.imd.abb;

public class No {
	int valor;
	No left;
	No right;
	int qntNosEsq = 0;
	int qntNosDir = 0;
	int altura = 1;  
    
    public No(int valor) {
        this.valor = valor;
        left = null;
        right = null;
    }
}