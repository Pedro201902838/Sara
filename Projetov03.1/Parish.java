/**
 * A classe Parish representa uma freguesia.
 *
 * @author Grupo 4 Turma 7
 * @version 04/05/2022
 */
public class Parish {
    private int parishId;
    private String parishName;

    /**
     * Construtor da classe Parish.
     * Instancia uma nova freguesia.
     * @param parishId - id da freguesia
     * @param parishName - nome da freguesia
     */
    public Parish(int parishId, String parishName) {
        this.parishId = parishId;
        this.parishName = parishName;
    }

    public int getParishId() {
        return parishId;
    }
    
    public String getParishName() {
        return parishName;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+++FREGUESIA+++");
        sb.append("\n");
        sb.append("ID: ");
        sb.append(parishId);
        sb.append("\n");
        sb.append("Nome: ");
        sb.append(parishName);
        sb.append("\n");
        sb.append("++++++++++++++++++++++++++++++++");
        return sb.toString();
    }
}