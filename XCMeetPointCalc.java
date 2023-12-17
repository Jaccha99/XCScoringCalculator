import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class XCMeetPointCalc {
   public static void main(String[] args) {
      
      String teamName = "";
      int numTeams = 0;
      int numRunners = 0;
      ArrayList<String> teamNames = new ArrayList<String>();
      ArrayList<Integer> meetTimes = new ArrayList<Integer>();
      
      Scanner scan = new Scanner(System.in);
      System.out.print("How many teams are at your meet?: ");
      numTeams = scan.nextInt();
      System.out.println();

      System.out.print("How many runners are on each team?: ");
      numRunners = scan.nextInt();
      System.out.println();
      
      ArrayList<Team> teams = new ArrayList<>();
      for (int i = 0; i < numTeams; i++) {
         teams.add(new Team());
      }
      
      for (int i = 0; i < numTeams; i++) {
         System.out.println("What is the name of team " + (i + 1) + ": ");
         String name = scan.next();
         teams.get(i).setName(name);
         teams.get(i).setNumRunners(numRunners);

      }
      
      
      for (int i = 0; i < numTeams; i++) {
         for (int k = 0; k < numRunners; k++) {
            String tempTime = "";
            int tempInd = k + 1;
            System.out.print("What was " + teams.get(i).getName() + "'s #" + tempInd + " runners time: ");
            tempTime = scan.next();
            teams.get(i).setOneTimeMin(k, tempTime);
         }
      }
      
      for (int i = 0; i < numTeams; i++) {
         for (int k = 0; k < numRunners; k++) {
            teams.get(i).setSecs();
            meetTimes.add(teams.get(i).getOneTimeSec(k));
         }
      }
      
      Collections.sort(meetTimes);
      
      for (int i = 0; i < numTeams; i++) {
         for (int j = 0; j < numRunners; j++) {
            for (int k = 0; k < meetTimes.size(); k++) {
               if (teams.get(i).getOneTimeSec(j) == meetTimes.get(k)) {
                  int countDub = 0;
                  while ((k > 0) && (meetTimes.get(k) == meetTimes.get(k-1))) {
                     countDub++;
                  }
                  if (countDub > 0) {
                     for (int n = i + countDub; n < numTeams; n++) {
                        if (teams.get(n).getOneTimeSec(j) == meetTimes.get(k)) {
                           teams.get(n).addPoints(k + 1 - countDub);
                           break;
                        }
                     }
                  }
                                    
                  teams.get(i).addPoints(k + 1);
                  break;
               }
            }
         }
      }
      
      ArrayList<Integer> teamPoints = new ArrayList<Integer>();
      for (Team t : teams) {
         teamPoints.add(t.getPoints());
      }
      
      Collections.sort(teamPoints);
      
      for (int i = 0; i < numTeams; i++) {
         System.out.print("In " + (i + 1) + "st place with " + teamPoints.get(i) + " points, ");
         for (int k = 0; k < numTeams; k++) {
            if (teamPoints.get(i) == teams.get(k).getPoints()) {
               System.out.print(teams.get(k).getName());
            }
         }
         System.out.println(); 
      }
   }
}