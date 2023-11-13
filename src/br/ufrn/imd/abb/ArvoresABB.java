package br.ufrn.imd.abb;
import java.util.Stack;

public class ArvoresABB {

No raiz;
int qntNos = 0;

public void iniciar() {
	raiz.left = new No(10);
	
	raiz.right = new No(45);
	
	raiz.left.right = new No(15); //filhode 10
	raiz.right.left = new No(40); //filhode 45
	raiz.right.right = new No(50); //filhode 45
	

}

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

}