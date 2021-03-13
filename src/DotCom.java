import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;
    
    public void setLocationCells(ArrayList<String> loc){
        locationCells=loc;
    }
    public void setName(String n){
        name=n;
    }
    public String check(String userInput){
        String result="miss";
        int index = locationCells.indexOf(userInput);
        if(index>=0){
            locationCells.remove(index);
            if(locationCells.isEmpty()){
                result="kill";
                GameHelper.prettyPrint(ConsoleColors.GREEN, "Good shot. You sunk "+name+" :)");
            }
            else{
                result="hit";
            }
        }
        return result;
    }
}
