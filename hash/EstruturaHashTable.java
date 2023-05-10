package hashColisao;

public class EstruturaHashTable implements EstruturaDeDados {
    private Integer tabela[];
    private Integer porao[];

    public EstruturaHashTable() {
        tabela = new Integer[1000]; // tabela Hashing é implementada como um array de 1000 elementos, com cada
                                    // elemento sendo um número inteiro.
        porao = new Integer[100]; // O tratamento de colisão por porão é implementado por um segundo array de 100
                                  // elementos.
    }

    @Override
    public boolean insert(int chave) {
        int indice = chave % 1000;
        if (tabela[indice] == null) {
            tabela[indice] = chave;
            return true;
        } else {
            int indicePorao = indice % 100;
            for (int i = 0; i < 100; i++) {
                if (porao[(indicePorao + i) % 100] == null) {
                    porao[(indicePorao + i) % 100] = chave;
                    return true;
                }
            }
            return false;
        }
    }

    // O algoritmo calcula o índice da tabela utilizando o resto da divisão da chave
    // por 1000.
    // Se a posição na tabela estiver vazia, a chave é inserida nessa posição. Caso
    // contrário, a chave é inserida no porão,
    // em uma posição calculada a partir do índice da tabela e do índice do porão.

    @Override
    public boolean delete(int chave) {
        int indice = chave % 1000;
        if (tabela[indice] != null && tabela[indice] == chave) {
            tabela[indice] = null;
            return true;
        } else {
            int indicePorao = indice % 100;
            for (int i = 0; i < 100; i++) {
                if (porao[(indicePorao + i) % 100] != null && porao[(indicePorao + i) % 100] == chave) {
                    porao[(indicePorao + i) % 100] = null;
                    return true;
                }
            }
            return false;
        }
    }

    // O algoritmo procura pela chave tanto na tabela quanto no porão. Se a chave
    // for encontrada, o elemento correspondente
    // é removido. Caso contrário, a função retorna false.

    @Override
    public int search(int chave) {
        int indice = chave % 1000;
        if (tabela[indice] != null && tabela[indice] == chave) {
            return indice;
        } else {
            int indicePorao = indice % 100;
            for (int i = 0; i < 100; i++) {
                if (porao[(indicePorao + i) % 100] != null && porao[(indicePorao + i) % 100] == chave) {
                    return indicePorao + i + 1000;
                }
            }
            return -1;
        }
    }

    

}
