import java.util.ArrayList;
import java.util.List;
/**
 * A classe ContainerListArray guarda uma lista de elementos.
 *
 * @author Grupo 4 Turma 7 - código adaptado do código exemplificado na aula TP do dia 11/05/2022
 * @version 11/05/2022
 */
public class ContainerListArray <E> implements IContainerOperations <E> {
    private List <E> elements;
    private int numElements;

    /**
     * Construtor da classe ContainerListArray.
     * Instancia uma nova lista de elementos.
     */
    public ContainerListArray() {
        elements = new ArrayList <> ();
        this.numElements = elements.size();
    }

    @Override
    public boolean addElem(E e) {
        if(e != null) {
            elements.add(e);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean removeElem(int index) {
        if(index >= 0) {
            elements.remove(index);
            return true;
        }
        return false;
    }
    
    @Override
    public E getElem(int index) {
        if(index >= 0) {
            return elements.get(index);
        }
        return null;
    }
    
    @Override
    public boolean setElem(int index, E e) {
        if(index >= 0 && e != null) {
            elements.set(index, e);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean isListEmpty() {
        return elements.isEmpty();
    }
    
    @Override
    public void showElemsInfo() {
        for(E e : elements) {
            System.out.println(e.toString());
        }
    }
}