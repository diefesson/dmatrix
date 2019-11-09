package com.diefesson.dmatrix.model;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class Registro implements Iterable<String>{

    private final Matriz matriz;
    private final List<String> descricoes = new LinkedList<>();
    
    public Registro(Matriz matriz){
        if(matriz == null){
            throw new NullPointerException("A matriz inicial não pode ser null");
        }
        this.matriz = new Matriz(matriz, true);
    }
    
    public void adcionarDescricao(String descricao){
        if(descricao == null){
            throw new NullPointerException("A descrição não pode ser null");
        }
        descricoes.add(descricao);
    }
    
    public Matriz obterMatriz(){
        return matriz;
    }

    @Override
    public Iterator<String> iterator() {
        return descricoes.iterator();
    }
    
}
