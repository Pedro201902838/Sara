import java.util.ArrayList;
import java.util.List;
/**
 * A classe PresidentialElection representa uma eleição presidencial.
 * 
 * @author Grupo 4 Turma 7
 * @version 14/05/2022
 */
public class PresidentialElection extends Election {
    private List <Candidate> candidates;
    private Candidate president;
    private List <Vote> votes;
    private int numberOfVotesPresidential;
    private String electionType;
    private String timePeriod;
    
    /**
     * Construtor da classe PresidentialElection.
     * Instancia uma nova eleição presidencial.
     * @param type - atributo da super classe
     * @param candidates - lista de candidatos
     * @param votes - lista de votos
     * @param timePeriod - período em que se realiza a eleição
     */
    public PresidentialElection(ElectionType type, List <Candidate> candidates, List <Vote> votes, String timePeriod) {
        super(type);
        electionType = "Presidencial";
        this.timePeriod = timePeriod;
        president = null;
        numberOfVotesPresidential = votes.size();
    }
    
    public List <Candidate> getCandidates() {
        return candidates;
    }
    
    public List <Vote> getVotes() {
        return votes;
    }
    
    public int getNumberOfVotesPresidential() {
        return numberOfVotesPresidential;
    }
    
     public Candidate getPresident(){
        return president;
    }
    
    @Override
    public String getElectionType() {
        return electionType;
    }
    
    @Override
    public String getTimePeriod() {
        return timePeriod;
    }
    
    /**
     * Elege o Presidente da República.
     * @param candidates - lista de candidatos à presidência
     */
    public void electPresident(List <Candidate> candidates) {
        int max=0;
        int SecMax=0;
        Candidate candidate;
        for(int i=0; i<candidates.size();i++){
            if(candidates.get(i).getNumberOfVotesObtained()>max && candidates.get(i).getNumberOfVotesObtained()>= 0.5 * numberOfVotesPresidential){
                max = candidates.get(i).getNumberOfVotesObtained();
                SecMax= candidates.get(i-1).getNumberOfVotesObtained();
                president = candidates.get(i);
                candidate = candidates.get(i-1);
            }
            else if(max < 0.5 * numberOfVotesPresidential || max == SecMax){
                clean();
                backSecond(president ,candidates.get(i-1));
            }
        }
        
    }
    
    /**
     * Método auxiliar para desempatar ou executar a segunda volta.
     */
    private void backSecond(Candidate candidate1, Candidate candidate2) {
        if(candidate1.getNumberOfVotesObtained() > candidate2.getNumberOfVotesObtained()){
            president = candidate1;
        }
    }
    
    private void clean(){
        votes.clear();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+++ELEIÇÃO PRESIDENCIAL+++");
        sb.append("\n");
        sb.append("Tipo de eleição: ");
        sb.append(electionType);
        sb.append("\n");
        sb.append("Período em que decorre a eleição: ");
        sb.append(timePeriod);
        sb.append("\n");
        sb.append("Informação sobre o presidente eleito: ");
        sb.append(president.toString());
        sb.append("\n");
        sb.append("Informação sobre os candidatos à presidência: ");
        for(Candidate candidate : candidates) {
            sb.append(candidate.toString());
        }
        sb.append("Número de votos: ");
        sb.append(numberOfVotesPresidential);
        sb.append("\n");
        sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        return sb.toString();
    }
}