/**
 * A interface IContainerOperations guarda as operações de qualquer lista contida na classe ContainerListArray.
 *
 * @author Grupo 4 Turma 7 - código adaptado do código exemplificado na aula TP do dia 11/05/2022
 * @version 11/05/2022
 */
public interface IContainerOperations <E> {
    /**
     * Adiciona um elemento à lista.
     * @param e - elemento a adicionar à lista
     * @return sucesso ou insucesso da operação
     */
    boolean addElem(E e);
    
    /**
     * Remove um elemento da lista.
     * @param index - índice do elemento a remover da lista
     * @return sucesso ou insucesso da operação
     */
    boolean removeElem(int index);
    
    /**
     * Retorna o elemento numa determinada posição da lista.
     * @param index - índice do elemento pretendido
     * @return E - elemento pretendido
     */
    E getElem(int index);
    
    /**
     * Altera o elemento numa determinada posição da lista.
     * @param index - índice do elemento a alterar
     * @param e - elemento a alterar
     * @return sucesso ou insucesso da operação
     */
    boolean setElem(int index, E e);
    
    /**
     * Verifica se a lista está vazia ou não.
     * @return true se a lista está vazia ou false caso contrário
     */
    boolean isListEmpty();
    
    /**
     * Mostra a informação sobre os elementos da lista.
     */
    void showElemsInfo();
}