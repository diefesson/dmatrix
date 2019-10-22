package com.diefesson.dmatrix.control;

import com.diefesson.dmatrix.view.GroovyView;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.function.Consumer;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class GroovyControl {

    private final DMatrixControl dmControl;
    private final GroovyView view;

    private String script = "";
    private volatile boolean executando = false;
    private final Binding variaveis;
    private final GroovyShell shell;

    private final PipedReader saida;
    private final PipedWriter saidaShell;
    private final PipedWriter entrada;
    private final PipedReader entradaShell;

    public GroovyControl(DMatrixControl dmControl, GroovyView view) throws IOException {
        this.dmControl = dmControl;
        this.view = view;
        
        variaveis = new Binding();
        shell = new GroovyShell(variaveis);

        saida = new PipedReader();
        saidaShell = new PipedWriter(saida);
        entrada = new PipedWriter();
        entradaShell = new PipedReader(entrada);
        
        reiniciar();
    }

    public void reiniciar() {
        variaveis.getVariables().clear();
        variaveis.setVariable("dmControl", dmControl);
        variaveis.setVariable("output", saidaShell);
        variaveis.setVariable("input", entradaShell);
    }

    public void definirScript(String script) {
        if (script == null) {
            throw new NullPointerException("o script não pode ser null");
        }
        this.script = script;
    }

    public String obterScript() {
        return script;
    }

    public void executar(boolean async) {
        Thread thread = new Thread(() -> {
            executando = true;
            shell.evaluate(script);
            executando = false;
            if (view != null) {
                view.aoTerminar();
            }
        });

        if (async) {
            thread.start();
        } else {
            thread.run();
        }
    }

    public boolean executando() {
        return executando;
    }

    public Reader obterSaida() {
        return saida;
    }

    public Writer obterEntrada() {
        return entrada;
    }

    public static void main(String[] args) throws IOException {
        DMatrixControl dmc = new DMatrixControl(null);
        GroovyControl gc = new GroovyControl(dmc, null);

        String script = "import com.diefesson.dmatrix.model.Matriz\n"
                + "dmControl.adcionarMatriz(\"matriz 1\", new Matriz(2, 2))";
        gc.definirScript(script);
        gc.executar(false);

        System.out.println(dmc.obterMatriz("matriz 1"));
    }
}
