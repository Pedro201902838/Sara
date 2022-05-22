import java.util.ArrayList;
import java.util.List;
/**
 * A classe District representa um distrito.
 *
 * @author Grupo 4 Turma 7
 * @version 04/05/2022
 */
public class District {
    private String districtName;
    private List <County> counties;
    private int numberOfCounties;

    /**
     * Construtor da classe District.
     * Instancia um novo distrito.
     */
    public District(String districtName) {
        if(districtName != null && districtName != "") {
            this.districtName = districtName;
            counties = new ArrayList <> ();
            numberOfCounties = counties.size();
        }
    }
    
    public String getDistrictName() {
        return districtName;
    }
    
    public List <County> getCounties() {
        return counties;
    }
    
    public int getNumberOfCounties() {
        return numberOfCounties;
    }
    
    /**
     * Adiciona um concelho à lista.
     * @param county - o concelho a adicionar à lista
     * @return sucesso ou insucesso da operação
     */
    public boolean addCounty(County county) {
        if(county != null) {
            counties.add(county);
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Remove um concelho da lista.
     * @param index - índice do concelho a remover da lista
     * @return sucesso ou insucesso da operação
     */
    public boolean removeCounty(int index) {
        if(index >= 0) {
            counties.remove(index);
            return true;
        }
        return false;
    }
    
    /**
     * Retorna o concelho numa determinada posição da lista.
     * @param index - índice do concelho pretendida
     * @return county - concelho pretendida
     */
    public County getCounty(int index) {
        if(index >= 0) {
            return counties.get(index);
        }
        return null;
    }
    
    /**
     * Altera o concelho numa determinada posição da lista.
     * @param index - índice do concelho a alterar
     * @param county - concelho a alterar
     * @return sucesso ou insucesso da operação
     */
    public boolean setCounty(int index,County county) {
        if(index >= 0 && county != null) {
            counties.set(index, county);
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+++DISTRITO+++");
        sb.append("\n");
        sb.append("Nome: ");
        sb.append(districtName);
        sb.append("\n");
        sb.append("Número de concelhos: ");
        sb.append(numberOfCounties);
        sb.append("\n");
        sb.append("Informação dos concelhos que fazem parte do distrito: ");
        sb.append("\n");
        for(County county : counties) {
            sb.append(counties.toString());
        }
        return sb.toString();
    }
}