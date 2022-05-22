import java.util.ArrayList;
import java.util.List;
/**
 * A classe EuropeanElection representa uma eleição europeia.
 * 
 * @author Grupo 4 Turma 7 
 * @version 14/05/2022
 */
public class EuropeanElection extends Election {
    private List <Candidate> candidates;
    private Candidate europeanParliamentRepresentative;
    private List <Vote> votes;
    private int numberOfMandates;
    private int numberOfVotesEuropean;
    private String electionType;
    private String timePeriod;
    
    /**
     * Construtor da classe EuropeanElection.
     * Instancia uma nova eleição europeia.
     * @param type - atributo da super classe
     * @param candidates - lista de candidatos
     * @param votes - lista de votos
     * @param timePeriod - período em que se realiza a eleição
     */
    public EuropeanElection(ElectionType type, List <Candidate> candidates, List <Vote> votes, String timePeriod) {
        super(type);
        electionType = "Europeia";
        this.timePeriod = timePeriod;
        numberOfVotesEuropean = votes.size();
        europeanParliamentRepresentative = null;
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
    
    public int getNumberOfVotesEuropean() {
        return numberOfVotesEuropean;
    }
    
    /**
     * Elege o representante.
     * @param candidates - lista de candidatos
     */
    public void electEuropeanRepresentative(List <Candidate> candidates) {
        if(candidates != null) {
            for(int i = 0; i < candidates.size(); i++) {
                if(candidates.get(i).getNumberOfVotesObtained() >= 0.5 * numberOfVotesEuropean &&
                candidates.get(i).getNumberOfVotesObtained() > candidates.get(i+1).getNumberOfVotesObtained()) {
                   europeanParliamentRepresentative  = candidates.get(i);
                }
                else if(candidates.get(i).getNumberOfVotesObtained() == 0.5 * numberOfVotesEuropean &&
                candidates.get(i+1).getNumberOfVotesObtained() == candidates.get(i).getNumberOfVotesObtained()){
                    
                    
                }
                else if(candidates.get(i).getNumberOfVotesObtained() < 0.5 * numberOfVotesEuropean) {
                   
                }
            }
        }
    }
    
    public Candidate getRepresentative(){
        return europeanParliamentRepresentative;
    }
    
    /**
     * Calcula o número de mandatos atribuídos de acordo com o Método de Hondt.
     */
    public void CalculateMandates() {
        
    }
    
    public int getNumberOfMandates(){
        return numberOfMandates;
    }
    
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       
       sb.append("+++ELEIÇÃO EUROPEIA+++");
       sb.append("\n");
       sb.append("Tipo de eleição: ");
       sb.append(electionType);
       sb.append("\n");
       sb.append("Período em que decorre a eleição: ");
       sb.append(timePeriod);
       sb.append("Informação sobre o representante eleito: ");
       sb.append(europeanParliamentRepresentative.toString());
       sb.append("Número de mandatos atribuídos: ");
       sb.append(numberOfMandates);
       sb.append("\n");
       sb.append("Informação sobre os candidatos às europeias: ");
       for(Candidate candidate : candidates) {
           sb.append(candidate.toString());
       }
       sb.append("\n");
       sb.append("Número de votos: ");
       sb.append(numberOfVotesEuropean);
       sb.append("\n");
       sb.append("++++++++++++++++++++++++++++++++++++++++++++++++++++");
       
       return sb.toString();
    }
}