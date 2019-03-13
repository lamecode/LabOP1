import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) {
        Team [] teams;
        int TeamNumber = 20;
        teams = getTeamsFromCsvFile(TeamNumber);
        sortTeamsByPoints(teams);
        writeCsvFile(teams);
    }

    public static Team[] getTeamsFromCsvFile(int TeamNumber) {
        Team[] teams = new Team[TeamNumber];
        int lineCounter = 0;
        String[][] rows = new String[20][];
        try {
            BufferedReader br = new BufferedReader(new FileReader("premier_league.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                rows[lineCounter] = line.split(",");
                teams[lineCounter] = new Team(rows[lineCounter]);
                lineCounter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return teams;
    }

    public static void sortTeamsByPoints(Team[] teams) { // Sorting algorithm Bubble sort
        Team tempTeam;
        for (int i = 0; i < teams.length; i++) {
            for (int j = 1; j < teams.length; j++) {
                if (teams[j].getPoints() > teams[j - 1].getPoints()) {
                    tempTeam = teams[j - 1];
                    teams[j - 1] = teams[j];
                    teams[j] = tempTeam;
                } else if (teams[j].getPoints() == teams[j - 1].getPoints()) {
                    if (teams[i].getGamesPlayed() > teams[i].getGamesPlayed()) {
                        tempTeam = teams[j - 1];
                        teams[j - 1] = teams[j];
                        teams[j] = tempTeam;
                    }
                }
            }
        }
    }

    public static void writeCsvFile(Team[] teams) {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("results.csv"));
            for(int i = 0; i < teams.length; i++) {
                pr.write(teams[i].getName() + "," + teams[i].getPoints() + "," + teams[i].getResults() + (i != teams.length - 1?"\n":""));
            }
            pr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }


}
