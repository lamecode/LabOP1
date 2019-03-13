import java.util.Arrays;

public class Team {
    private String name;
    private String[] results;
    private int points;



    public Team(String[] row) {
        name = row[0];
        results = new String[row.length - 1];
        for(int i = 1; i < row.length; i++) {
            results[i - 1] = row[i];
        }
        countPoints();
    }



    public void countPoints() {
        for(int i = 0; i < results.length; i++) {
            int teamScore = Integer.valueOf(results[i].substring(0, results[i].indexOf(":")));
            int enemyScore = Integer.valueOf(results[i].substring(results[i].indexOf(":") + 1));
            if(teamScore > enemyScore) {
                points += 3;
            } else if(teamScore == enemyScore) {
                points +=1;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getResults() {
        String resultsString = "";
        for(int i = 0; i < results.length; i++) {
            resultsString += results[i] + (i != results.length - 1?",":"");
        }
        return resultsString;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "Team [name=" + name + ", results=" + Arrays.toString(results) + ", points=" + points + "]";
    }
}

