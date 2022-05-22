import java.util.ArrayList;
import java.util.List;
/**
 * A classe Candidate representa um candidato.
 *
 * @author Grupo 4 Turma 7
 * @version 13/05/2022
 */
public class Candidate {
    private Voter voter;
    private List <Vote> obtainedVotes;
    private int numberOfVotesObtained;
    private ElectionType type;
    private Parties party;
    private String role;

    /**
     * Construtor da classe Candidate.
     * Instancia um novo candidato.
     */
    public Candidate(Voter voter, List <Vote> obtainedVotes, ElectionType type, Parties party,
    String role) {
        if(voter != null && voter.getAge() > 35 && obtainedVotes != null && role.equalsIgnoreCase("Presidente")) {
            this.role = role;
            this.numberOfVotesObtained = obtainedVotes.size();
        }
        else if(voter != null && obtainedVotes != null && role != "" && role != null) {
            this.role = role;
            this.numberOfVotesObtained = obtainedVotes.size();
        }
    }
    
    public Voter getVoter() {
        return voter;
    }
    
    public List <Vote> getObtainedVotes() {
        return obtainedVotes;
    }
    
    public int getNumberOfVotesObtained() {
        return numberOfVotesObtained;
    }
    
    public ElectionType getElectionType() {
        return type;
    }
    
    public Parties getPoliticalParty() {
        return party;
    }
    
    public String getRole() {
        return role;
    }
    
    public int resetNumberOfVotes(){
        return 0;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("+++CANDIDATO+++");
        sb.append("\n");
        sb.append("Informação sobre o candidato: ");
        sb.append(voter.toString());
        sb.append("\n");
        sb.append("Número de votos obtidos: ");
        sb.append(numberOfVotesObtained);
        sb.append("\n");
        sb.append("Está a candidatar-se para a eleição: ");
        sb.append(type);
        sb.append("\n");
        sb.append("Pertence ao partido: ");
        sb.append(party);
        sb.append("\n");
        sb.append("Está a candidatar-se para o seguinte cargo: ");
        sb.append(role);
        sb.append("\n");
        sb.append("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        return sb.toString();
    }
}