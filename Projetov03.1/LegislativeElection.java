import java.util.ArrayList;
import java.util.List;
/**
 * A classe LegislativeElection representa uma eleição legislativa.
 * 
 * @author Grupo 4 Turma 7
 * @version 14/05/2022
 */
public class LegislativeElection extends Election {
    private List <Candidate> candidates;
    private List <Vote> votes;
    private int numberOfMandates;
    private int numberOfVotesLegislatives;
    private Candidate representative;
    private String electionType;
    private String timePeriod;
    
    /**
     * Construtor da classe LegislativeElection.
     * Instancia uma nova eleição legislativa.
     * @param type - atributo da super classe
     * @param candidates - lista de candidatos
     * @param votes - lista de votos
     * @param timePeriod - período em que se realiza a eleição
     */
    public LegislativeElection(ElectionType type, List <Candidate> candidates, List <Vote> votes, String timePeriod) {
        super(type);
        electionType = "Legislativa";
        this.timePeriod = timePeriod;
        numberOfVotesLegislatives = votes.size();
        representative = null;
        numberOfMandates = 0;
     }
    
    @Override
    public String getElectionType() {
        return electionType;
    }
    
    @Override
    public String getTimePeriod() {
        return timePeriod; 
    }
    
    public List <Candidate> getCandidates() {
        return candidates;
    }
    
    public List <Vote> getVotes() {
        return votes;
    }
    
    public int getNumberOfVotesLegislatives() {
        return numberOfVotesLegislatives;
    }
    
    /**
     * Elege o representante.
     * @param candidates - lista de candidatos
     */
    public void electRepresentative(List <Candidate> candidates) {
        
    }
   
    public Candidate getRepresentative() {
        return representative;
    }
    
    /**
     * Calcula o número de mandatos atribuídos de acordo com o Método de Hondt.
     */
    public void CalculateMandates() {
        
    }
    
    public int getNumberOfMandates() {
        return numberOfMandates;
    }
    
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       
       sb.append("+++ELEIÇÃO LEGISLATIVA+++");
       sb.append("\n");
       sb.append("Tipo de eleição: ");
       sb.append(electionType);
       sb.append("\n");
       sb.append("Período em que decorre a eleição: ");
       sb.append(timePeriod);
       sb.append("Informação sobre o representante eleito: ");
       sb.append(representative.toString());
       sb.append("Número de mandatos atribuídos: ");
       sb.append(numberOfMandates);
       sb.append("\n");
       sb.append("Informação sobre os candidatos às legislativas: ");
       for(Candidate candidate : candidates) {
           sb.append(candidate.toString());
       }
       sb.append("\n");
       sb.append("Número de votos: ");
       sb.append(numberOfVotesLegislatives);
       sb.append("\n");
       sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++");
       
       return sb.toString();
    }
}