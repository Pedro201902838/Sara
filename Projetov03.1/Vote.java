import java.time.LocalDate;
/**
 * A classe Vote representa um voto.
 * 
 * @author Grupo 4 Turma 7
 * @version 06/05/2022
 */
public class Vote {
    private Voter voter;
    private Parties partyVoted;
    private String selectedOption;
    private String voteType;
    private boolean voteAntecipated;
    private LocalDate date;
    
    /**
     * Construtor da classe Vote.
     * Instancia um voto normal.
     * @param voter - votante associado ao voto
     * @param partyVoted - o partido selecionado de acordo com o enumerado Parties
     */
    public Vote(Voter voter, Parties partyVoted) {
        if(voter.VOTES == 0) {
            this.partyVoted = partyVoted;
            switch(partyVoted) {
                case A:
                    this.selectedOption = "A";
                    break;
                case B:
                    this.selectedOption = "B";
                    break;
                case C:
                    this.selectedOption = "C";
                    break;
                case D:
                    this.selectedOption = "D";
                    break;
                case E:
                    this.selectedOption = "E";
                    break;
                case F:
                    this.selectedOption = "F";
                    break;
                case G:
                    this.selectedOption = "G";
                    break;
                case NULL:
                    this.selectedOption = null;
                    break;
                default:
                    this.selectedOption = "";
                    break;
            }
            date = date.now();
            voteAntecipated = false;
            if(selectedOption == null) {
                voteType = "Nulo";
            }
            else if(selectedOption == "") {
                voteType = "Branco";
            }
            else {
                voteType = "Válido";
            }
            voter.VOTES++;
        }
        else {
            System.out.println("Este votante já efetuou o seu voto.");
        }
    }
    
    /**
     * Construtor da classe Vote.
     * Instancia um voto antecipado.
     * @param voter - o votante associado ao voto
     * @param partyVoted - o partido selecionado
     * @param day - dia em que o voto foi guardado
     * @param month - mês em que o voto foi guardado
     * @param year - ano em que o voto foi guardado
     */
    public Vote(Voter voter, Parties partyVoted, int day, int month, int year) {
        if(voter.VOTES == 0) {
            this.partyVoted = partyVoted;
            switch(partyVoted) {
                case A:
                    selectedOption = "A";
                    break;
                case B:
                    selectedOption = "B";
                    break;
                case C:
                    selectedOption = "C";
                    break;
                case D:
                    selectedOption = "D";
                    break;
                case E:
                    selectedOption = "E";
                    break;
                case F:
                    selectedOption = "F";
                    break;
                case G:
                    selectedOption = "G";
                    break;
                case NULL:
                    selectedOption = null;
                    break;
                default:
                    selectedOption = "";
                    break;
            }
            date = LocalDate.of(day, month , year);
            voteAntecipated = true;
            if(selectedOption == null) {
                voteType = "Nulo";
            }
            else if(selectedOption == "") {
                voteType = "Branco";
            }
            else {
                voteType = "Válido";
            }
            voter.VOTES++;
        }
        else {
            System.out.println("Este votante já efetuou o seu voto.");
        }
    }
    
    public String getSelectedOption() {
        return selectedOption;
    }
    
    public String getVoteType() {
        return voteType;
    }
    
    private boolean isAntecipated() {
        return voteAntecipated;
    }
    
    private LocalDate getVoteDate() {
        return date;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+++VOTO+++");
        sb.append("\n");
        sb.append("Votante: ");
        sb.append(voter.toString());
        sb.append("\n");
        sb.append("Data do voto: ");
        sb.append(date);
        sb.append("\n");
        sb.append("Opção escolhida: ");
        sb.append(selectedOption);
        sb.append("\n");
        sb.append("Tipo do voto: ");
        sb.append(voteType);
        sb.append("Voto antecipado? ");
        if(voteAntecipated) {
            sb.append("Sim");
        }
        else {
            sb.append("Não");
        }
        sb.append("\n");
        sb.append("+++++++++++++++++++++++++++++++");
        return sb.toString();
    }
}