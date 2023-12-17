import java.util.ArrayList;

public class Team {
   
   private String name;
   private int numRunners;
   private ArrayList<String> timesMin = new ArrayList<String>();
   private ArrayList<Integer> timesSec = new ArrayList<Integer>();
   private int points;
   
   
   public Team(String teamName, int numTeamRunners) {
      name = teamName;
      numRunners = numTeamRunners;
      for (int i = 0; i < numRunners; i++) {
         timesSec.add(1);
         timesMin.add("");
      }
   }
      
   public Team() {
      name = "Unknown";
      numRunners = 7;
   }
      
   public String getName() {
      return name;
   }
      
   public int getNumRunners() {
      return numRunners;
   }
      
   public String getOneTimeMin(int index) {
      return timesMin.get(index);
   }
      
   public int getOneTimeSec(int index) {
      return timesSec.get(index);
   }
   
   public void setName(String newName) {
      name = newName;
   }
   
   public void setNumRunners(int newNumRunners) {
      numRunners = newNumRunners;
      for (int i = 0; i < numRunners; i++) {
         timesSec.add(1);
         timesMin.add("");
      }
   }
   
   public void setSecs() {
      for (int i = 0; i < timesMin.size(); i++) {
         int step1 = Integer.parseInt(timesMin.get(i).substring(0, timesMin.get(i).indexOf(":")));
         int colonIndex = timesMin.get(i).indexOf(":");
         int step2 = step1 * 60;
         int step3 = Integer.parseInt(timesMin.get(i).substring(colonIndex + 1));
         int totalSecs = step2 + step3;
         timesSec.set(i, totalSecs);
      }
   }
   
   public void setOneTimeMin(int index, String time) {
      timesMin.set(index, time);
   }
   
   public void setOneTimeSec(int index, int time) {
      timesSec.set(index, time);
   }
   
   public void addPoints(int pointsAdded) {
      points += pointsAdded;
   }
   
   public int getPoints() {
      return points;
   }
}