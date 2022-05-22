import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A classe LocalElection representa uma eleição autárquica.
 * 
 * @author Grupo 4 Turma 7
 * @version 14/05/2022
 */
public class LocalElection extends Election {
    private List <Candidate> candidates;
    private Candidate townHallRepresentative;
    private Candidate cityCouncilRepresentative;
    private Candidate parishAssembliesRepresentative;
    private List <Vote> votes;
    private int numberOfMandates;
    private int numberOfVotesLocal;
    private String electionType;
    private String timePeriod;
    
    /**
     * Construtor da classe LocalElection.
     * Instancia uma nova eleição autárquica.
     * @param type - atributo da super classe
     * @param candidates - lista de candidatos
     * @param votes - lista de votos
     * @param timePeriod - período em que se realiza a eleição
     */
    public LocalElection(ElectionType type, List <Candidate> candidates, List <Vote> votes, String timePeriod) {
        super(type);
        electionType = "Autárquica";
        this.timePeriod = timePeriod;
        numberOfVotesLocal = votes.size();
        townHallRepresentative = null;
        cityCouncilRepresentative = null;
        parishAssembliesRepresentative = null;
        numberOfMandates = 0;
    }
    
    @Override
    public String getElectionType(){
        return electionType;
    }
    
    @Override
    public String getTimePeriod(){
        return timePeriod; 
    }
    
    public List <Candidate> getCandidates(){
        return candidates;
    }
    
    public List <Vote> getVotes(){
        return votes;
    }
    
    public int getNumberOfVotesLocal(){
        return numberOfVotesLocal;
    }
    
    /**
     * Calcula o número de mandatos atribuídos de acordo com o Método de Hondt.
     */
    public void CalculateMandates() {
        
    }
    
    public int getNumberOfMandates(){
        return numberOfMandates;
    }
    
    /**
     * Elege o representante para a câmara municipal.
     */
    public void electHallRepresentative(List <Candidate> candidates) {
        if(candidates != null) {
            for(int i = 0; i < candidates.size(); i++) {
                if(candidates.get(i).getNumberOfVotesObtained() >= 0.5 * numberOfVotesLocal &&
                candidates.get(i).getNumberOfVotesObtained() > candidates.get(i+1).getNumberOfVotesObtained()) {
                   townHallRepresentative  = candidates.get(i);
                }
                else if(candidates.get(i).getNumberOfVotesObtained() == 0.5 * numberOfVotesLocal &&
                candidates.get(i+1).getNumberOfVotesObtained() == candidates.get(i).getNumberOfVotesObtained()){
                    
                    
                }
                else if(candidates.get(i).getNumberOfVotesObtained() < 0.5 * numberOfVotesLocal) {
                   
                }
            }
        }
    }
    
    public Candidate getTownHallRepresentative(){
        return townHallRepresentative;
    }
    
    /**
     * Elege o representante para a assembleia municipal.
     * @param candidate - lista de candidatos
     */
    public void electCouncilRepresentative(List <Candidate> candidates) {
        if(candidates != null) {
            for(int i = 0; i < candidates.size(); i++) {
                if(candidates.get(i).getNumberOfVotesObtained() >= 0.5 * numberOfVotesLocal &&
                candidates.get(i).getNumberOfVotesObtained() > candidates.get(i+1).getNumberOfVotesObtained()) {
                   townHallRepresentative  = candidates.get(i);
                }
                else if(candidates.get(i).getNumberOfVotesObtained() == 0.5 * numberOfVotesLocal &&
                candidates.get(i+1).getNumberOfVotesObtained() == candidates.get(i).getNumberOfVotesObtained()){
                    
                    
                }
                else if(candidates.get(i).getNumberOfVotesObtained() < 0.5 * numberOfVotesLocal) {
                   
                }
            }
        }
    }
    
    public Candidate getCityRepresentative(){
        return cityCouncilRepresentative;
    }
    
    /**
     * Elege o representante para as assembleia de freguesia.
     * @param candidates - lista de candidatos
     */
    public void electAssembliesRepresentative(List <Candidate> candidates) {
    
    }
    
    public Candidate getParishAssembliesRepresentative(){
        return parishAssembliesRepresentative;
    }
    
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       
       sb.append("+++ELEIÇÃO AUTÁRQUICA+++");
       sb.append("\n");
       sb.append("Tipo de eleição: ");
       sb.append(electionType);
       sb.append("\n");
       sb.append("Período em que decorre a eleição: ");
       sb.append(timePeriod);
       sb.append("Informação sobre os representantes eleitos: ");
       sb.append(townHallRepresentative.toString());
       sb.append("\n");
       sb.append(cityCouncilRepresentative.toString());
       sb.append("\n");
       sb.append(parishAssembliesRepresentative.toString());
       sb.append("\n");
       sb.append("Número de mandatos atribuídos: ");
       sb.append(numberOfMandates);
       sb.append("\n");
       sb.append("Informação sobre os candidatos às autárquicas: ");
       for(Candidate candidate : candidates) {
           sb.append(candidate.toString());
       }
       sb.append("\n");
       sb.append("Número de votos: ");
       sb.append(numberOfVotesLocal);
       sb.append("\n");
       sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
       
       return sb.toString();
    }
}