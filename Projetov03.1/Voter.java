/**
 * A classe Voter representa um votante.
 *
 * @author Grupo 4 Turma 7
 * @version 03/05/2022
 */
public class Voter {
    private String name;
    private int age;
    PollingTable pollingTable;
    private String voterOrIdNumber;
    private boolean inPortugal;
    public static int VOTES = 0;

    /**
     * Construtor da classe Voter.
     * Instancia um novo votante.
     * @param name - nome do votante
     * @param age - idade do votante
     * @param pollingTable - mesa de Voto associada ao votante
     * @param voterOrIdNumber - número de eleitor ou número do CC
     * @param inPortugal - indica se o votante está ou não em Portugal
     */
    public Voter(String name, int age, PollingTable pollingTable, String voterOrIdNumber, boolean inPortugal) {
        if(name != null && name != "" && age >= 18 && pollingTable != null && voterOrIdNumber.length() == 8) {
            this.name = name;
            this.age = age;
            this.pollingTable = pollingTable;
            this.voterOrIdNumber = voterOrIdNumber;
            this.inPortugal = inPortugal;
        }
        else {
            System.out.println("Votante inválido.");
        }
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if(name != null && name != "") {
        this.name = name;
        }
    }
    
    public int getAge() {
        return age;
    }
    
    public PollingTable getPollingTable() {
        return pollingTable;
    }
    
    public String getNumber() {
        return voterOrIdNumber;
    }
    
    public boolean isInPortugal() {
        return inPortugal;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+++VOTANTE+++");
        sb.append("\n");
        sb.append("Nome: ");
        sb.append(name);
        sb.append("\n");
        sb.append("Idade: ");
        sb.append(age);
        sb.append("\n");
        sb.append("Mesa de Voto: ");
        sb.append(pollingTable);
        sb.append("\n");
        sb.append("Número de eleitor/CC: ");
        sb.append(voterOrIdNumber);
        sb.append("\n");
        sb.append("Está em Portugal? ");
        sb.append(inPortugal);
        sb.append("\n");
        sb.append("++++++++++++++++++++++++++");
        return sb.toString();
    }
}