import java.util.ArrayList;
import java.util.List;
/**
 * A classe PollingTable representa uma mesa de voto.
 *
 * @author Grupo 4 Turma 7
 * @version 05/05/2022
 */
public class PollingTable {
    private int tableId;
    private Parish parish;
    private int tableNumber;
    private List <Voter> voters;
    private int numberOfVoters;
    private List <Vote> votes;
    private int numberOfVotesTable;
    private static final int OPENING_TIME = 8;
    private static final int CLOSING_TIME = 19;

    /**
     * Construtor da classe PollingTable.
     * Instancia uma nova mesa de voto.
     * @param tableId - id da mesa de voto
     * @param parish - freguesia onde a mesa de voto se encontra
     * @param tableNumber - número da mesa de voto
     * @param voters - lista de votantes
     * @param votes - lista de votos
     */
    public PollingTable(int tableId, Parish parish, int tableNumber, List <Voter> voters, List <Vote> votes ) {
       if(tableId > 0 && parish != null && tableNumber > 0 && voters != null && votes != null) {
           this.tableId = tableId;
           this.parish = parish;
           this.tableNumber = tableNumber;
           this.voters = voters;
           this.votes = votes;
           numberOfVoters = voters.size();
           numberOfVotesTable = votes.size();
       }
    }
    
    public int getTableId() {
        return tableId;
    }
    
    public Parish getParish() {
        return parish;
    }
    
    public int getTableNumber() {
        return tableNumber;
    }
    
    public List <Voter> getVoters() {
        return voters;
    }
    
    public int getNumberOfVoters() {
        return numberOfVoters;
    }
    
    public List <Vote> getVotes() {
        return votes;
    }
    
    public int getNumberOfVotesTables() {
        return numberOfVotesTable;
    }
    
    /**
     * Retorna o intervalo de tempo em que as urnas estão abertas para votar.
     * @return intervalo de tempo em forma de String
     */
    public String getVotingTime() {
        StringBuilder sb = new StringBuilder();
        sb.append("As urnas estão abertas para votar entre as ");
        sb.append(OPENING_TIME);
        sb.append(" h e as ");
        sb.append(CLOSING_TIME);
        sb.append(" h");
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+++MESA DE VOTO+++");
        sb.append("\n");
        sb.append(getVotingTime());
        sb.append("\n");
        sb.append("ID da mesa: ");
        sb.append(tableId);
        sb.append("\n");
        sb.append("Informação da freguesia associada à mesa: ");
        sb.append(parish.toString());
        sb.append("\n");
        sb.append("Número da mesa: ");
        sb.append(tableNumber);
        sb.append("\n");
        sb.append("Informação dos votantes associados à mesa: ");
        sb.append("\n");
        sb.append(voters.toString());
        sb.append("\n");
        sb.append("Número de votantes associados à mesa: ");
        sb.append(numberOfVoters);
        sb.append("\n");
        sb.append("Informação dos votoss guardados na mesa: ");
        sb.append("\n");
        sb.append(votes.toString());
        sb.append("\n");
        sb.append("Número de votos guardados na mesa: ");
        sb.append(numberOfVotesTable);
        sb.append("\n");
        sb.append("++++++++++++++++++++++++++++++++++++++++++++");
        return sb.toString();
    }
}