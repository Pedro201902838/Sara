import java.util.ArrayList;
import java.util.List;
/**
 * A classe County representa um concelho.
 *
 * @author Grupo 4 Turma 7
 * @version 04/05/2022
 */
public class County {
    private String countyName;
    private List <Parish> parishes;
    private int numberOfParishes;

    /**
     * Construtor da classe County.
     * Instancia um novo concelho.
     */
    public County(String countyName) {
        if(countyName != null && countyName != "") {
            this.countyName = countyName;
            parishes = new ArrayList <> ();
            numberOfParishes = parishes.size();
        }
    }
    
    public String getCountyName() {
        return countyName;
    }
    
    public List <Parish> getParishes() {
        return parishes;
    }
    
    public int getNumberOfParishes() {
        return numberOfParishes;
    }
    
    /**
     * Adiciona uma freguesia à lista.
     * @param parish - a freguesia a adicionar à lista
     * @return sucesso ou insucesso da operação
     */
    public boolean addParish(Parish parish) {
        if(parish != null) {
            parishes.add(parish);
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Remove uma freguesia da lista.
     * @param index - índice da freguesia a remover da lista
     * @return sucesso ou insucesso da operação
     */
    public boolean removeParish(int index) {
        if(index >= 0) {
            parishes.remove(index);
            return true;
        }
        return false;
    }
    
    /**
     * Retorna a freguesia numa determinada posição da lista.
     * @param index - índice da freguesia pretendida
     * @return parish - freguesia pretendida
     */
    public Parish getParish(int index) {
        if(index >= 0) {
            return parishes.get(index);
        }
        return null;
    }
    
    /**
     * Altera a freguesia numa determinada posição da lista.
     * @param index - índice da freguesia a alterar
     * @param parish - freguesia a alterar
     * @return sucesso ou insucesso da operação
     */
    public boolean setParish(int index, Parish parish) {
        if(index >= 0 && parish != null) {
            parishes.set(index, parish);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+++CONCELHO+++");
        sb.append("\n");
        sb.append("Nome: ");
        sb.append(countyName);
        sb.append("\n");
        sb.append("Número de freguesias: ");
        sb.append(numberOfParishes);
        sb.append("\n");
        sb.append("Informação das freguesias que fazem parte do concelho: ");
        sb.append("\n");
        for(Parish parish : parishes) {
            sb.append(parish.toString());
        }
        return sb.toString();
    }
}