package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.model.Matriz;
import com.diefesson.dmatrix.view.DMatrixView;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class DMatrixController {
    
    private final Map<String, Matriz> matrizes = new HashMap<>();
    private final Map<String, Float> numeros = new HashMap<>();
    private final DMatrixView view;

    public DMatrixController(DMatrixView view) {
        this.view = view;
    }
    
    public void adcionarMatriz(String chave, Matriz matriz){
        if(chave == null || matriz == null){
            throw new NullPointerException("nem a chave nem a matriz podem ser nulas");
        }
        Matriz antiga = matrizes.put(chave, matriz);
        System.out.println(view);
        if(view != null){
            view.emMatrizAdcionada(chave, matriz, antiga);
        }
    }
    
    public Matriz obterMatriz(String chave){
        if(chave == null){
            throw new NullPointerException("a chave não pode ser nula");
        }
        return matrizes.get(chave);
    }
    
    public Matriz removerMatriz(String chave){
        if(chave == null){
            throw new NullPointerException("a chave não pode ser nula");
        }
        Matriz matriz = matrizes.remove(chave);
        if(view != null && matriz != null){
            view.emMatrizRemovida(chave, matriz);
        }
        return matriz;
    }
    
    public void adcionarMatriz(String chave, float numero){
        if(chave == null ){
            throw new NullPointerException("a chave não pode ser nula");
        }
        
        Float antigo =  numeros.put(chave, numero);
        if(view != null){
            view.emNumeroAdcionado(chave, numero, antigo);
        }
    }
    
    public Float obterNumero(String chave){
        if(chave == null){
            throw new NullPointerException("a chave não pode ser nula");
        }
        
        return numeros.get(chave);
    }
    
    public Float removerNumero(String chave){
        if(chave == null){
            throw new NullPointerException("a chave não pode ser nula");
        }
        
        Float numero = numeros.remove(chave);
        if(view != null && numero != null){
            view.emNumeroRemovido(chave, numero);
        }
        return numero;
    }

    /**
     * 
     * @param filtro A interface funcional que serve como filtro para selecionar matrizes
     * @return Um mapa contendo as chaves e as matrizes que passaram pelo filtro
     */
    public Map<String, Matriz> obterMatrizes(Function<Matriz, Boolean> filtro){
        Map<String, Matriz> resultados = new HashMap<>();
        for(Entry<String, Matriz> no : matrizes.entrySet()){
            if(filtro.apply(no.getValue())){
                resultados.put(no.getKey(), no.getValue());
            }
        }
        return resultados;
    }
    
}
