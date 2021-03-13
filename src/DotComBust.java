import java.util.*;

public class DotComBust{
    private GameHelper helper=new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numGuesses=0;

    private void setUpGame(){
        // Creating BattleShips and giving them locations
        DotCom one = new DotCom();
        one.setName("Ship 1");
        DotCom two = new DotCom();
        two.setName("Ship 2");
        DotCom three = new DotCom();
        three.setName("Ship 3");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        GameHelper.prettyPrint(ConsoleColors.CYAN, "Your goal is to sink three battleships.");
        GameHelper.prettyPrint(ConsoleColors.CYAN, "Ships are Ship 1,Ship 2 and Ship 3");;
        String structure=
        "+====+====+====+====+====+====+====+\n"+
        "| A0 | A1 | A2 | A3 | A4 | A5 | A6 |\n"+
        "+====+====+====+====+====+====+====+\n"+
        "| B0 | B1 | B2 | B3 | B4 | B5 | B6 |\n"+
        "+====+====+====+====+====+====+====+\n"+
        "| C0 | C1 | C2 | C3 | C4 | C5 | C6 |\n"+
        "+====+====+====+====+====+====+====+\n"+
        "| D0 | D1 | D2 | D3 | D4 | D5 | D6 |\n"+
        "+====+====+====+====+====+====+====+\n"+
        "| E0 | E1 | E2 | E3 | E4 | E5 | E6 |\n"+
        "+====+====+====+====+====+====+====+\n"+
        "| F0 | F1 | F2 | F3 | F4 | F5 | F6 |\n"+
        "+====+====+====+====+====+====+====+\n"+
        "| G0 | G1 | G2 | G3 | G4 | G5 | G6 |\n"+
        "+====+====+====+====+====+====+====+\n";
        GameHelper.prettyPrint(ConsoleColors.CYAN, "The cell structure is\n"+structure);
        GameHelper.prettyPrint(ConsoleColors.CYAN, "The ships are of dimensions 3x1 arranged horizontally or vertically");
        GameHelper.prettyPrint(ConsoleColors.CYAN, "Start sinking them! To battle! To victory! UUURRRRRAAAAAA!");

        for ( DotCom dotcomToSet: dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotcomToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess=helper.getUserInput(ConsoleColors.BLUE+"Enter cell number guess"+ConsoleColors.RESET);
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void checkUserGuess(String userString){
        numGuesses++;
        String result="miss";
        for(DotCom dotComtoTest:dotComsList){
            result = dotComtoTest.check(userString);
            if(result.equals("hit")){
                break;
            }
            if(result.equals("kill")){
                dotComsList.remove(dotComtoTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame(){
        GameHelper.prettyPrint(ConsoleColors.GREEN, "All targets are destroyed");
        if(numGuesses<=18){
            GameHelper.prettyPrint(ConsoleColors.GREEN, "Good job! You are an ace soldier.");
        }
        if(numGuesses>40){
            GameHelper.prettyPrint(ConsoleColors.RED, "You have been relieved from your service. Reason: Poor use of naval resources");
        }
        else{
            GameHelper.prettyPrint(ConsoleColors.YELLOW, "You need accuracy soldier! You got out easy this time. Days are not always this fortunate");
        }
        System.out.println("Rounds used="+numGuesses);
    }

    public static void main(String[] args)
    {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}