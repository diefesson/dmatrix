package com.diefesson.dmatrix.model;

import java.util.Random;

/**
 *
 * @author Diefesson de Sousa Silva
 */
public class Matriz {

    private double[][] valores;
    private Matriz ampliada;
    private Historico historico;

    /**
     *
     * @param m a altura da matriz
     * @param n a largura da matriz
     */
    public Matriz(int m, int n) {
        if (m <= 0 || n <= 0) {
            throw new IllegalArgumentException(String.format("Tamanho da matriz inválido %dx%d", m, n));
        }
        valores = new double[m][n];
    }

    public Matriz(int ordem) {
        this(ordem, ordem);
    }

    /**
     * OBS: esse construtor não copia a matriz dada
     *
     * @param valores os valores que serão usados nessa matriz
     */
    public Matriz(double[][] valores) {
        verificarValores(valores);
        this.valores = valores;
    }

    /**
     * Cria uma cópia de uma matriz já existente, não copia a matriz ampliada
     *
     * @param original A matriz original que será copiada
     */
    public Matriz(Matriz original) {
        this(original, false);
    }

    public Matriz(Matriz original, boolean ampl) {
        valores = new double[original.obterAltura()][original.obterLargura()];

        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores[0].length; j++) {
                valores[i][j] = original.valores[i][j];
            }
        }

        if (ampl && original.ampliada != null) {
            ampliada = new Matriz(original.ampliada);
        }

        if (original.obterHistorico() != null) {
            iniciarHistorico();
        }
    }

    /**
     * *
     * Define a matriz double[][] interna usada para guardar os valores
     *
     * @param valores A nova matriz de valores
     */
    public void definirValores(double[][] valores) {
        this.valores = valores;
    }

    /**
     * *
     *
     * @return A matriz double[][] interna dessa classe
     */
    public double[][] obterValores() {
        return valores;
    }

    public void definirAmpliada(Matriz ampliada) {
        this.ampliada = ampliada;
    }

    public Matriz obterAmpliada() {
        return ampliada;
    }

    public Historico obterHistorico() {
        return historico;
    }

    public void removerHistorico() {
        historico = null;
    }

    public void iniciarHistorico() {
        historico = new Historico(this);
    }

    public void definirValor(double valor, int i, int j) {
        valores[i][j] = valor;
    }

    /**
     *
     * @param i a linha do elemento na matriz
     * @param j a coluna do elemento na matriz
     * @return o valor do elemente na posição (i, j)
     */
    public double obterValor(int i, int j) {
        return valores[i][j];
    }

    /**
     *
     * @return a altura dessa matriz
     */
    public int obterAltura() {
        return valores.length;
    }

    /**
     *
     * @return a largura dessa matriz
     */
    public int obterLargura() {
        return valores[0].length;
    }

    /**
     * Verifica se uma certa matriz double[][] é válida para ser usada em uma
     * matriz
     *
     * @param valores A matriz que será verificada
     * @throws IllegalArgumentException Caso a matriz não seja válida
     */
    public void verificarValores(double[][] valores) {
        int m = valores.length;
        if (m == 0) {
            throw new IllegalArgumentException("A altura da matriz não pode ser igual a zero");
        }
        int n = valores[0].length;
        if (n == 0) {
            throw new IllegalArgumentException("A largura da matriz não pode ser igual zero");
        }

        for (int i = 1; i < valores.length; i++) {
            if (valores[i].length != n) {
                throw new IllegalArgumentException("O tamanho das colunas devem ser todos iguais");
            }
        }
    }

    /**
     *
     * @return true se essa matriz for quadrada
     */
    public boolean verificarQuadrada() {
        return obterAltura() == obterLargura();
    }

    /**
     *
     * @return true se todos os elementos dessa matriz forem iguais a zero
     */
    public boolean verificarNula() {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obterValor(i, j) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Uma matriz identidade é aquela em que para todos os elementos, se i == j
     * o valor do elemento é 1, caso contrário 0
     *
     * @return true se essa matriz for uma matriz identidade
     */
    public boolean verificarIdentidade() {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obterValor(i, j) != ((i == j) ? 1 : 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * OBS: por coveniência esse método também chega se o caso de matriz
     * diagonal
     *
     * @return um enumerador para o tipo de triangularidade
     */
    public TipoTriangularidade verificarTriangularidade() {
        if (!verificarQuadrada()) {
            return TipoTriangularidade.NAO_TRIANGULAR;
        }

        int tamanho = obterAltura();//altura == largura...
        boolean inferior = true, superior = true;

        loopSuperior:
        for (int i = 0; i < tamanho; i++) {
            for (int j = i - 1; j > -1; j--) {
                if (obterValor(i, j) != 0) {
                    superior = false;
                    break loopSuperior;
                }
            }
        }

        loopInferior:
        for (int i = 0; i < tamanho; i++) {
            for (int j = i + 1; j < tamanho; j++) {
                if (obterValor(i, j) != 0) {
                    inferior = false;
                    break loopInferior;
                }
            }
        }

        if (superior && inferior) {
            return TipoTriangularidade.DIAGONAL;
        } else if (superior) {
            return TipoTriangularidade.TRIANGULAR_SUPERIOR;
        } else if (inferior) {
            return TipoTriangularidade.TRIANGULAR_INFERIOR;
        } else {
            return TipoTriangularidade.NAO_TRIANGULAR;
        }
    }

    /**
     * Realiza uma soma escalar(não sei se esse é o correto dessa operação)
     *
     * @param escalar o valor a ser somados a todas as células dessa matriz
     */
    public void soma(double escalar) {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valores[i][j] += escalar;
            }
        }
        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("soma com escalar: " + escalar);
        }
    }

    /**
     * OBS: A matriz alterada é a usada para chamar esse método
     *
     * @param outra A outra matriz para a operação de soma matricial
     * @throws IllegalArgumentException caso as matrizes não posssam ser somadas
     */
    public void soma(Matriz outra) {
        int m = obterAltura();
        int n = obterLargura();
        if (m != outra.obterAltura() || n != outra.obterLargura()) {
            throw new IllegalArgumentException("O tamanho das matrizes deve ser igual(" + m + "x" + n + " " + outra.obterAltura() + "x" + outra.obterLargura() + ")");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valores[i][j] += outra.obterValor(i, j);
            }
        }
        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("soma com matriz");
        }
    }

    public void subtrair(Matriz outra) {
        int m = obterAltura();
        int n = obterLargura();
        if (m != outra.obterAltura() || n != outra.obterLargura()) {
            throw new IllegalArgumentException("O tamanho das matrizes deve ser igual(" + m + "x" + n + " " + outra.obterAltura() + "x" + outra.obterLargura() + ")");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valores[i][j] -= outra.obterValor(i, j);
            }
        }
        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("soma com matriz");
        }
    }

    /**
     *
     * @param escalar O escalar a qual está matriz será multiplicado
     */
    public void multiplicar(double escalar) {
        int m = obterAltura();
        int n = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                valores[i][j] *= escalar;
            }
        }

        if (ampliada != null) {
            ampliada.multiplicar(escalar);
        }
        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("multiplicação com escalar: " + escalar);
        }
    }

    /**
     *
     * @param outra O segundo operando da multipliicao de matrizes
     * @return O resultado da multiplicacao de matrizes
     * @throws IllegalArgumentException Caso as matrizes não sejam
     * multiplicaveis
     */
    public Matriz multiplicar(Matriz outra) {
        Matriz saida = matrizParaMultiplicacao(outra);

        int m = saida.obterAltura();
        int n = saida.obterLargura();
        int o = obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double valor = 0;
                for (int k = 0; k < o; k++) {
                    valor += obterValor(i, k) * outra.obterValor(k, j);
                }
                saida.definirValor(valor, i, j);
            }
        }

        if (historico != null) {
            saida.iniciarHistorico();
            saida.obterHistorico().adcionarDescricao("multiplicação com matriz");
        }

        return saida;
    }

    /**
     *
     * @param outra A segundo operando, usado para estimar o tamanho
     * @return Uma matriz do tamanho correto para ser usada na sáida da
     * multiplição dessa por outra
     * @throws IllegalArgumentException Caso as matrizes não possam não sejam
     * multiplicaveis entre si
     */
    public Matriz matrizParaMultiplicacao(Matriz outra) {
        if (!verificarMultiplicacao(outra)) {
            throw new IllegalArgumentException("A largura de m1 deve ser igual a altura de m2");
        }
        return new Matriz(obterAltura(), outra.obterLargura());
    }

    /**
     *
     * @param outra O segundo operando da multiplicação
     * @return true, se as matrizes forem multiplicaveis entre si
     */
    public boolean verificarMultiplicacao(Matriz outra) {
        return obterLargura() == outra.obterAltura();
    }

    /**
     * obtém a linha processado i e j da sequinte forma i = i % m, j = j % n
     * útil para o teorema de Sarrus
     *
     * @param i a linha do valor
     * @param j a coluna do fator
     * @return O valor em i e j da matriz extendida
     */
    public double obterValorExtendido(int i, int j) {
        i %= obterAltura();
        j %= obterLargura();
        return valores[i][j];
    }

    public Matriz obterMatrizComplemento() {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para que tenha uma matriz complemento");
        }

        int ordem = obterAltura();
        Matriz m = new Matriz(ordem, ordem);
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                m.definirValor(obterMenorComplemento(i, j), i, j);
            }
        }

        return m;
    }

    public Matriz obterMatrizCofator() {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para que tenha uma matriz cofator");
        }

        int ordem = obterAltura();
        Matriz m = new Matriz(ordem, ordem);
        for (int i = 0; i < ordem; i++) {
            for (int j = 0; j < ordem; j++) {
                m.definirValor(obterCofator(i, j), i, j);
            }
        }
        return m;
    }

    public double obterDeterminante() {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para que tenha um determinate");
        }

        int ordem = obterAltura();

        switch (ordem) {
            case 1:
                return valores[0][0];
            case 2:
                return valores[0][0] * valores[1][1] - valores[0][1] * valores[1][0];
            case 3:
                double determinante = 0;
                for (int k = 0; k < 3; k++) {//diagonais principais
                    double multiplicado = 1;
                    for (int l = 0; l < 3; l++) {
                        multiplicado *= obterValorExtendido(l, k + l);
                    }
                    determinante += multiplicado;
                }
                for (int k = 0; k < 3; k++) {//diagonais oposta
                    double multiplicado = 1;
                    for (int l = 0; l < 3; l++) {
                        multiplicado *= obterValorExtendido(2 - l, k + l);
                    }
                    determinante -= multiplicado;
                }
                return determinante;
        }

        //aqui o coisa começa a ficar interresante, usando método de Laplace
        //vou utilizar a primeira linha no cálculo do determinante
        double determinante = 0;
        for (int j = 0; j < ordem; j++) {
            determinante += valores[0][j] * obterCofator(0, j);
        }

        return determinante;
    }

    public double obterCofator(int i, int j) {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para ter um cofator");
        }
        int ordem = obterAltura();
        if (ordem == 1) {
            throw new IllegalStateException("a matriz deve ser de pelo menos ordem 2 para ter um cofator");
        }

        return sinalCofator(i, j) * obterMenorComplemento(i, j);
    }

    public double obterMenorComplemento(int i, int j) {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para ter um menor complemento");
        }

        int ordem = obterAltura();
        if (ordem == 1) {
            throw new IllegalStateException("a matriz deve ser de pelo menos ordem 2 para ter um menor complemento");
        }

        Matriz menor = new Matriz(ordem - 1, ordem - 1);
        for (int k = 0, y = 0; k < ordem; k++) {
            if (k != i) {
                for (int l = 0, x = 0; l < ordem; l++) {
                    if (l != j) {
                        menor.definirValor(valores[k][l], x, y);
                        x++;
                    }
                }
                y++;
            }
        }

        return menor.obterDeterminante();
    }

    /**
     * Cria uma nova matriz de tamanho diferente, e copia os valores dessa
     * matriz para a nova
     *
     * @param m a altura da nova matriz
     * @param n a largura da nova matriz
     */
    public void redimensionar(int m, int n) {
        int ml = Math.min(m, obterAltura());
        int nl = Math.min(n, obterLargura());

        double[][] original = valores;
        valores = new double[m][n];

        for (int i = 0; i < ml; i++) {
            for (int j = 0; j < nl; j++) {
                valores[i][j] = original[i][j];
            }
        }

        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("redimensionado para " + m + "x" + n);
        }
    }

    /**
     * Obtém a matriz transposta
     *
     * @return Uma nova matriz que é a transposta desta
     */
    public Matriz obterTransposta() {
        int m = obterAltura();
        int n = obterLargura();

        Matriz matriz = new Matriz(n, m);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz.definirValor(obterValor(i, j), j, i);
            }
        }

        if (historico != null) {
            matriz.iniciarHistorico();
            matriz.obterHistorico().adcionarDescricao("transposta");
        }
        return matriz;
    }

    public Matriz obterAdjunta() {
        Matriz matriz = obterMatrizCofator().obterTransposta();
        if (historico != null) {
            matriz.iniciarHistorico();
            matriz.obterHistorico().adcionarDescricao("adjunta");
        }
        return matriz;
    }

    public Matriz obterInversa() {
        double determinante = obterDeterminante();
        if (determinante == 0) {
            return null;
        }

        Matriz inversa = obterAdjunta();
        inversa.multiplicar(1 / determinante);

        if (historico != null) {
            inversa.iniciarHistorico();
            inversa.obterHistorico().adcionarDescricao("inversa");
        }

        return inversa;
    }

    /**
     * Tado um filtro, realiza uma busca até que esse filtro retorne true
     *
     * @param filtro o filtro que será usado para procurar o valor
     * @return a posicao do elemento econtrado
     */
    public Posicao procurar(FiltroMatriz filtro) {
        int m = obterAltura();
        int n = obterLargura();

        percorrer:
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Posicao pos = new Posicao(i, j);
                if (filtro.apply(pos, obterValor(i, j))) {
                    return pos;
                }
            }
        }
        return null;
    }

    /**
     * arredonta qualquer número cuja distância de seu valor arredontado seja
     * menor ou igual a 0.00001
     */
    public void arredontarImprecisao() {
        arredontarImprecisao(0.00001);
    }

    /**
     * Arredonta qualquer qualquer valor cuja distância de seu valor arrendotado
     * seja menor ou igual a delta
     *
     * @param delta a distância usada nos calculos
     */
    public void arredontarImprecisao(double delta) {
        for (int i = 0; i < valores.length; i++) {
            for (int j = 0; j < valores[i].length; j++) {
                double arredontado = Math.round(valores[i][j]);
                if (Math.abs(valores[i][j] - arredontado) <= delta) {
                    valores[i][j] = arredontado;
                }
            }
        }
        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("arredontado com delta: " + delta);
        }
    }

    /**
     * Prepara a matriz para que tenha 1 no canto superior esquerdo
     *
     * @return Caso a matriz seja quadrada, este valor representará o
     * multiplicador do determinante para se obter o determinante original, caso
     * este valor seja 0, significa que não foi possivel preparar a matriz
     */
    public double prepararMatriz() {
        double multiplicador = 1;
        Posicao p = procurar(new FiltroMatriz.FiltroDeValor(1));
        if (p == null) {
            p = procurar(new FiltroMatriz.FiltroDeDiferente(0));
            if (p == null) {//a matriz é nula, não tem como se obter 1 dela
                return 0;
            }
        }

        if (p.obterI() != 0) {
            trocarLinha(1, p.obterI());
            multiplicador *= -1;
        }
        if (p.obterJ() != 0) {
            trocarColuna(1, p.obterJ());
            multiplicador *= -1;
        }

        if (valores[0][0] != 1) {
            double d = 1 / valores[0][0];
            multiplicador *= d;
            for (int j = 0; j < valores[0].length; j++) {
                valores[1][j] *= d;
            }
        }
        return multiplicador;
    }

    public void trocarColuna(int a, int b) {
        if (a == b) {
            return;
        }
        for (int i = 0; i < valores.length; i++) {
            double t = valores[i][a];
            valores[i][a] = valores[i][b];
            valores[i][b] = t;
        }

        if (ampliada != null) {
            ampliada.trocarColuna(a, b);
        }

        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("troca de coluna: " + a + " <-> " + b);
        }
    }

    public void trocarLinha(int a, int b) {
        if (a == b) {
            return;
        }
        for (int j = 0; j < valores[0].length; j++) {
            double t = valores[a][j];
            valores[a][j] = valores[b][j];
            valores[b][j] = t;
        }

        if (ampliada != null) {
            ampliada.trocarLinha(a, b);
        }

        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("troca de linha: " + a + " <-> " + b);
        }
    }

    /**
     *
     * @param a a linha de origem
     * @param b a linha de destino
     * @param multiplicador um valor a qual multiplicar a linha a antes de somar
     * a b
     */
    public void somarLinha(int a, int b, double multiplicador) {
        for (int j = 0; j < valores[0].length; j++) {
            valores[b][j] += multiplicador * valores[a][j];
        }

        if (ampliada != null) {
            ampliada.somarLinha(a, b, multiplicador);
        }

        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("soma de linhas: L" + b + " += " + multiplicador + "L" + a);
        }
    }

    /**
     *
     * @param a a coluna de origem
     * @param b a coluna de destino
     * @param multiplicador um valor a qual multiplicar a coluna a antes de
     * somar a b
     */
    public void somarColuna(int a, int b, double multiplicador) {
        for (int i = 0; i < valores.length; i++) {
            valores[i][b] += multiplicador * valores[i][a];
        }

        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("soma de colunas: C" + a + " += " + multiplicador + "C" + b);
        }
    }

    /**
     * *
     * Realiza uma operação de multiplicação de matrizes
     *
     * @param exp O expoente da multiplicação
     * @return A matriz resultante
     */
    public Matriz potencia(int exp) {
        if (!verificarQuadrada()) {
            throw new IllegalStateException("a matriz deve ser quadrada para a operação de potência");
        } else if (exp < 0) {
            throw new IllegalArgumentException("o expoente deve ser >= 0");
        }

        if (exp == 0) {
            return Matriz.gerarIdentidade(obterAltura());
        }

        Matriz m = this;
        for (int i = 1; i < exp; i++) {
            m = m.multiplicar(this);
        }

        if (historico != null) {
            m.iniciarHistorico();
            m.obterHistorico().adcionarDescricao("potencia: " + exp);
        }

        return m;
    }

    public int linhasNaoNulas() {
        int n = 0;
        for (int i = 0, m = obterAltura(); i < m; i++) {
            if (!linhaNula(i)) {
                n++;
            }
        }
        return n;
    }

    public boolean linhaNula(int i) {
        if (i >= obterAltura()) {
            throw new IllegalArgumentException("a linha " + i + "não existe");
        }
        for (int j = 0, n = obterLargura(); j < n; j++) {
            if (valores[i][j] != 0) {
                return false;
            }
        }
        return true;
    }

    public int zerosInicioLinha(int i) {
        int j = 0;
        for (int m = obterAltura(); j < m; j++) {
            if (valores[i][j] != 0) {
                break;
            }
        }
        return j;
    }

    public Matriz[] gauss(boolean jordan, boolean lu) {
        int m = obterAltura();
        int n = obterLargura();

        DirecaoEliminacao direcao = (jordan) ? DirecaoEliminacao.AMBAS : DirecaoEliminacao.BAIXO;

        if (ampliada != null) {
            if (ampliada.obterLargura() != 1) {
                throw new IllegalStateException("a largura da matriz ampliada deve ser igual a 1");
            } else if (ampliada.obterAltura() != m) {
                throw new IllegalStateException("a altura da matriz ampliada deve ser igual");
            }
        }

        Matriz p = null;
        Matriz l = null;

        if (lu) {
            p = Matriz.gerarIdentidade(m);
            l = Matriz.gerarIdentidade(m, n);
        }

        if (historico != null) {
            if (lu) {
                p.iniciarHistorico();
                p.obterHistorico().adcionarDescricao("matriz P");
                l.iniciarHistorico();
                l.obterHistorico().adcionarDescricao("matriz L");
            }
            historico.adcionarDescricao("inicio do método de Gauss");
        }

        for (int i = 0, j = 0; i < m && j < n; j++) {
            int pivo = linhaPivo(j);//A linha do pivô
            if (pivo != -1) {
                trocarLinha(i, pivo);//Traz esses valores até a linha correta
                if (lu) {
                    p.trocarLinha(i, pivo);
                }
                if (jordan) {
                    multiplicarLinha(i, 1 / valores[i][j]);//divide a linha pelo valor do pivo
                }
                eliminacaoGaussiana(i, j, direcao, l);
                i++;//avança para a próxima linha
            }
        }

        if (historico != null) {
            historico.adcionarDescricao("fim do método de Gauss");
        }

        return new Matriz[]{l, p};
    }

    /**
     * Este método assume que o processo de Gauss ou Gauss-Jordan já tenha sido
     * aplicado
     *
     * @return
     */
    public TipoSistema classificarSistema() {
        int m = obterAltura();
        if (ampliada == null) {
            throw new IllegalStateException("a ampliada deve existir");
        } else if (ampliada.obterAltura() != m || ampliada.obterLargura() != 1) {
            throw new IllegalStateException("o tamanho da ampliada é inválido");
        }

        for (int i = 0; i < m; i++) {
            if (classificarEquacao(i) == TipoEquacao.DEGENERADA) {
                System.out.println("linha " + i);
                return TipoSistema.IMPOSSIVEL;
            }
        }

        int posto = linhasNaoNulas();
        int incognitas = obterIncognitas();

        if (posto < incognitas) {
            System.out.println("posto " + posto + " incognitas " + incognitas);
            return TipoSistema.POSSIVEL_INDERMINADO;
        }

        return TipoSistema.POSSIVEL_DETERMINADO;
    }

    public int obterIncognitas() {
        int incognitas = 0;
        for (int j = 0, n = obterLargura(); j < n; j++) {
            for (int i = 0, m = obterAltura(); i < m; i++) {
                if (valores[i][j] != 0) {
                    incognitas++;
                    break;
                }
            }
        }
        return incognitas;
    }

    /**
     * Esse método assume que o processo de Gauss ou Gauss-Jordan já foi
     * aplicado e que o sistema tenha solucão determinada
     *
     * @return A matriz solução
     */
    public Matriz solucionarSistema() {
        int m = obterAltura();

        Matriz solucao = new Matriz(m, 1);

        for (int i = m - 1; i >= 0; i--) {
            if (classificarEquacao(i) != TipoEquacao.NULA) {//Salta equações nulas
                solucionarEquacao(i, solucao);
            }
        }

        return solucao;
    }

    /**
     * Este método assume que o sistema tenha solução
     *
     * @param i A linha da equação a ser solucionada
     * @param solucao A matriz contento os valores anteriores já solucionados, o
     * resultado será colocado nessa matriz
     */
    private void solucionarEquacao(int i, Matriz solucao) {
        int pivo = zerosInicioLinha(i);//A coluna do termo a ser solucionado
        int n = obterLargura();

        //Os valores do termo dependente e do termo indenpendente
        double dependente = valores[i][pivo];
        double independente = ampliada.valores[i][0];

        for (int j = pivo + 1; j < n; j++) {
            independente -= valores[i][j] * solucao.valores[j][0];//soma, acho que está errado...
        }

        double s = independente / dependente;
        solucao.valores[pivo][0] = s;
    }

    /**
     * Retorna o tipo de equação de uma determinada linha Esse método assume que
     * a ampliada existe e seu tamanho seja válido
     *
     * @param i A linha da equação
     * @return O tipo da equação
     */
    public TipoEquacao classificarEquacao(int i) {
        for (int j = 0, n = obterLargura(); j < n; j++) {
            if (valores[i][j] != 0) {
                return TipoEquacao.NORMAL;
            }
        }
        //Se chegou até aqui então todos os termos dependentes são zero
        if (ampliada.valores[i][0] == 0) {
            return TipoEquacao.NULA;
        } else {
            return TipoEquacao.DEGENERADA;
        }
    }

    public void multiplicarLinha(int i, double multiplicador) {
        int n = obterLargura();

        for (int j = 0; j < n; j++) {
            valores[i][j] *= multiplicador;
        }

        if (ampliada != null) {
            ampliada.multiplicarLinha(i, multiplicador);
        }

        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("multiplicar linha: L" + i + " *= " + multiplicador);
        }
    }

    public void multiplicarColuna(int j, double multiplicador) {
        int m = obterAltura();

        for (int i = 0; i < m; i++) {
            valores[i][j] *= multiplicador;
        }

        if (ampliada != null) {
            ampliada.multiplicarColuna(j, multiplicador);
        }

        if (historico != null) {
            historico.registrar(this);
            historico.adcionarDescricao("multiplicar coluna: C" + j + " *= " + multiplicador);
        }
    }

    public void eliminacaoGaussiana(int i, int j, DirecaoEliminacao direcao, Matriz l) {
        if (valores[i][j] == 0) {
            throw new IllegalArgumentException("o pivo não pode ser nulo");
        } else if (direcao == null) {
            throw new NullPointerException("a direção não pode ser null");
        }

        int m = obterAltura();

        if (direcao.baixo()) {
            for (int k = i + 1; k < m; k++) {
                double razao = valores[k][j] / valores[i][j];
                somarLinha(i, k, -razao);
                valores[k][j] = 0;//Garante que o valor seja zerado
                if (l != null) {
                    l.valores[k][j] = razao;
                    l.obterHistorico().registrar(l);
                    if (l.obterHistorico() != null) {
                        l.obterHistorico().registrar(l);
                    }
                }
            }
        }

        if (direcao.cima()) {
            for (int k = 0; k < i; k++) {
                double razao = valores[k][j] / valores[i][j];
                somarLinha(i, k, -razao);
                valores[k][j] = 0;
                if (l != null) {
                    l.valores[k][j] = razao;
                    if (l.obterHistorico() != null) {
                        l.obterHistorico().registrar(l);
                    }
                }
            }
        }
    }

    private int linhaPivo(int coluna) {
        for (int i = 0, m = obterAltura(); i < m; i++) {
            if (zerosInicioLinha(i) == coluna) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @return Uma representação textual da matriz
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] linhas : valores) {
            for (double coluna : linhas) {
                sb.append(coluna);
                sb.append(" ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /**
     *
     * @param ordem a ordem da matriz, levando em conta que toda matriz
     * identidade é uma matriz quadrada
     * @return uma nova matriz identidade
     */
    public static Matriz gerarIdentidade(int ordem) {
        return gerarIdentidade(ordem, ordem);
    }

    /**
     *
     * @param m a altura da nova matriz
     * @param n a largura da nova matriz
     * @return A identidade redimensionada de acordo com m e n
     */
    public static Matriz gerarIdentidade(int m, int n) {
        Matriz identidade = new Matriz(m, n);
        for (int k = 0, l = Math.min(m, n); k < l; k++) {
            identidade.valores[k][k] = 1;
        }
        return identidade;
    }

    public static void preencherIdentidade(Matriz matriz) {
        int m = matriz.obterAltura();
        int n = matriz.obterLargura();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matriz.valores[i][j] = 0;
            }
        }

        for (int k = 0, l = Math.min(m, n); k < l; k++) {//Usa um loop extra mas evita m*n verificações de i == j
            matriz.valores[k][k] = 1;
        }
    }

    /**
     * O sinal cofator definido como (-1)^(i + j)
     *
     * @param i a linha
     * @param j a coluna
     * @return 1 ou -1
     */
    public static double sinalCofator(int i, int j) {
        return ((i + j) % 2 == 0) ? 1f : -1f;
    }

    /**
     *
     * @param matriz a matriz a ser preechida
     * @param min o valor mínimo(inclusivo)
     * @param max o valor máximo(exclusivo)
     * @param arredontar arredonta para menor os valores gerados
     */
    public static void PreencherAleatorio(Matriz matriz, double min, double max, boolean arredontar) {
        if (min > max) {
            double t = min;
            min = max;
            max = t;
        }

        double delta = max - min;
        Random r = new Random();
        int m = matriz.obterAltura();
        int n = matriz.obterLargura();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                double v = r.nextDouble() * delta + min;
                if (arredontar) {
                    v = Math.floor(v);
                }
                matriz.definirValor(v, i, j);
            }
        }
    }
}
