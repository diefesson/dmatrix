package com.diefesson.dmatrix.model;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class Registro implements Iterable<String>{

    private final Matriz MATRIZ;
    private final List<String> DESCRICOES = new LinkedList<>();
    
    public Registro(Matriz matriz){
        if(matriz == null){
            throw new NullPointerException("A matriz inicial não pode ser null");
        }
        MATRIZ = new Matriz(matriz);
    }
    
    public void adcionarDescricao(String descricao){
        if(descricao == null){
            throw new NullPointerException("A descrição não pode ser null");
        }
        DESCRICOES.add(descricao);
    }
    
    public Matriz obterMatriz(){
        return MATRIZ;
    }

    @Override
    public Iterator<String> iterator() {
        return DESCRICOES.iterator();
    }
    
}
