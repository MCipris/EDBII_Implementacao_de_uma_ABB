package br.ufrn.imd.abb;
import java.util.Stack;

public class ArvoresABB {

No raiz;
int qntNos;


public ArvoresABB() {
    raiz = null;
}


public void preOrdem(No no) {	
	System.out.print(no.valor + " ");
	
	if(no.left != null) {
		preOrdem(no.left);
	
	}
	
	if (no.right != null) {
		preOrdem(no.right);
	
	}

}

public void simetrica(No no) {
	if(no.left != null) {
		simetrica(no.left);
	
	}
	
	System.out.print(no.valor + " ");
	
	if (no.right != null) {
		simetrica(no.right);
		
	}
	
}

public int somaSimetrica(No no, int valor) {
	if(no.left != null) {
		valor = somaSimetrica(no.left, valor);
	
	}
	
	valor += no.valor;
	
	if (no.right != null) {
		valor = somaSimetrica(no.right, valor);
		
	}
	
	return valor;
}


public void posOrdem(No no) {
	if(no.left != null) {
		posOrdem(no.left);
	
	}
	
	if (no.right != null) {
		posOrdem(no.right);
	
	}
	
	System.out.print(no.valor + " ");

}


public void preOrdemIterativa(No no) {
	Stack <No> pilha = new Stack<>();
	pilha.push(no);
	
	while (!pilha.isEmpty()) {
		No atual = pilha.pop();
		System.out.print(atual.valor + " ");
		
		if (atual.right != null) {
			pilha.push(atual.right);
			
		}
		
		if (atual.left != null) {
			pilha.push(atual.left);
			
		}
	}
}

public void posOrdemIterativa(No No) {
    if (No == null) {
        return;
    }

    Stack<No> stack1 = new Stack<>();
    Stack<No> stack2 = new Stack<>();
    stack1.push(No);

    while (!stack1.isEmpty()) {
        No current = stack1.pop();
        stack2.push(current);

        if (current.left != null) {
            stack1.push(current.left);
        }

        if (current.right != null) {
            stack1.push(current.right);
        }
    }

    while (!stack2.isEmpty()) {
        No current = stack2.pop();
        System.out.print(current.valor + " ");
    }
}

/////////////////////

public void inserir(int valor) { //Apenas realiza a inserção se não encontrou o elemento; 
	
	if (busca(raiz, valor) == null) {
		raiz = privateInserir(raiz, valor); 
		qntNos++;
	}
//	if (qntNos == 1) {
//		raiz = 
//	}
}

private No privateInserir(No raiz, int valor) {
    if (raiz == null) {
        raiz = new No(valor); 
        return raiz;
    }

    if (valor < raiz.valor) {
        raiz.left = privateInserir(raiz.left, valor);
        raiz.qntNosEsq++;
        
    } else if (valor > raiz.valor) {
        raiz.right = privateInserir(raiz.right, valor);
        raiz.qntNosDir++;
        
    }
    
    raiz.altura = 1 + Math.max(calcAltura(raiz.left), calcAltura(raiz.right));

    return raiz; //Caso que o elemento já exista, apenas é retonado o próprio nó; 
}

public void delete(int valor) { //Apenas realiza a remoção se encontrou o elemento; 
	if (busca(raiz, valor) != null) {
		raiz = privateDeletar(raiz, valor);
		qntNos--;
		if (qntNos < 0) {qntNos = 0;}
	}
}

private No privateDeletar(No raiz, int valor) {
    if (raiz == null) {
        return raiz; //Caso raiz não exista;
    }

    if (valor < raiz.valor) {
        raiz.left = privateDeletar(raiz.left, valor);
        raiz.qntNosEsq--;
        
    } else if (valor > raiz.valor) {
        raiz.right = privateDeletar(raiz.right, valor);
        raiz.qntNosDir--;
        
    } else {
        // Nó com um filho ou nenhum filho
        if (raiz.left == null) {
            return raiz.right;
        } else if (raiz.right == null) {
            return raiz.left;
        }

        // Nó com dois filhos: encontre o sucessor in-order
        raiz.valor = valorMinimo(raiz.right);

        // Remova o sucessor
        raiz.right = privateDeletar(raiz.right, raiz.valor);
        
        // Atualiza a altura da árvore após remoção
        raiz.altura = 1 + Math.max(calcAltura(raiz.left), calcAltura(raiz.right));
    }
    
    // Atualize a altura do nó atual
    raiz.altura = 1 + Math.max(calcAltura(raiz.left), calcAltura(raiz.right));
    
    return raiz;
}

public int valorMinimo(No raiz) {
    int valorMinimo = raiz.valor;
    while (raiz.left != null) {
        valorMinimo = raiz.left.valor; 
        raiz = raiz.left;
    }
    return valorMinimo;
}

public No busca(No raiz, int valor) {
    if (raiz == null || raiz.valor == valor) {
        return raiz;
    }

    if (valor < raiz.valor) {
        return busca(raiz.left, valor);
    }

    return busca(raiz.right, valor);
}

private int calcAltura(No no) {
    if (no == null) {
        return 0; // Altura de um nó nulo é 0
    }
    return no.altura;
}

public boolean ehCompleta() {
	if (raiz == null) {return true;}
    int altura = raiz.altura;
    
    int minqntNos = (int) Math.pow(2, (altura - 1)); // (2^h-1)    min
    int maxqntNos = (int) Math.pow(2, altura) - 1; // (2^h) - 1  max
    
    return qntNos >= minqntNos && qntNos <= maxqntNos;
}

public boolean ehCheia(No raiz) {
    if (raiz == null) {
        return true; 
    }
    if (raiz.left == null && raiz.right == null) {
        return true;
    }

    if (raiz.left != null && raiz.left != null){
        return ehCheia(raiz.left) && ehCheia(raiz.right);
    }

    return false;
}

public float media(int valor) {
	No noAtual = busca(raiz, valor);
	int somaValores = somaSimetrica(noAtual, 0);
	int qntNosMedia = noAtual.qntNosEsq + noAtual.qntNosDir + 1;
	float media = (float) somaValores / qntNosMedia;
	return media;
	
}

public No mediana() {
	No mediana;
	if (qntNos % 2 == 0) { // é par
		No medianaesq = enesimoElemento(raiz, (qntNos/2));
		No medianadir = enesimoElemento(raiz, (qntNos/2) + 1);
		if (medianaesq.valor < medianadir.valor) {
			return medianaesq;
		}
		else {
			return medianadir;
		}
	} else {               // é ímpar
		mediana = enesimoElemento(raiz, (qntNos+1)/ 2);
	}
	return mediana;
}

public No enesimoElemento(No raiz, int pos) {
	No noPos;
	if(pos > qntNos || pos < 0) {
		return null;
	}
	if (pos <= raiz.qntNosEsq) {
		noPos = enesimoElemento(raiz.left, pos);
	} else if (pos == raiz.qntNosEsq + 1) {
		return raiz;
	} else {
		noPos = enesimoElemento(raiz.right, pos - ( 1 + raiz.qntNosEsq ));
	}
	
	return noPos;
}

public int posicao(No raiz, int elemento, int nosCortados) {
	int posicao = 0;
	if (elemento < raiz.valor) {
		posicao = posicao(raiz.left, elemento, nosCortados);
	} else if (elemento == raiz.valor) {
		return (raiz.qntNosEsq + 1)+nosCortados;
	} else {
		posicao = posicao(raiz.right, elemento, ( 1 + raiz.qntNosEsq ));
	}
	 
	return posicao;
}

public void imprimirTracos(No raiz, int vazios, int tamTotal) {
	if (raiz == null) {
		return;
	} else {
		String imprimir = "";
		for (int i = 0; i < vazios; i++) {
			imprimir += " ";
		}
		imprimir += Integer.toString(raiz.valor);
		int tracos = tamTotal - imprimir.length();
		for (int i = 0; i < tracos; i++) {
			imprimir += "-";
		}
		imprimir += "\n";
		System.out.print(imprimir);
		imprimirTracos(raiz.left, vazios+4, tamTotal);
		imprimirTracos(raiz.right, vazios+4, tamTotal);
	}
}

public String imprimirParenteses(No raiz) {
	if(raiz != null) {
		String impressao = "(";
		impressao += raiz.valor+" ";
		if(raiz.left != null) {
			impressao += imprimirParenteses(raiz.left);
		}
		if(raiz.right != null) {
			impressao += imprimirParenteses(raiz.right);
		}
		impressao+=")";
		return impressao;
	}
	return "";
}

}