package game.x.o;

import java.util.*;


public class GameXO {

    /**
     * @param args the command line arguments
     */
    static  Scanner input = new Scanner(System.in);
    static ArrayList<Integer> player1 = new ArrayList<Integer>();
    static ArrayList<Integer> player2 = new ArrayList<Integer>();
    public static  String  name1,name2;
    public static void main(String[] args) {
      
        System.out.println("Enter player1 name : ");
        name1=input.next();
        System.out.println("welcome " +name1+" you take x in game");
         System.out.println("Enter player2 name : ");
         name2=input.next();
        System.out.println("welcome "+name2+" you take o in game");
        
        char[][] gameboard = {{'1' , '|', '2', '|', '3'},
        {'-', '+', '-', '+', '-'},
        {'4', '|', '5', '|', '6'},
        {'-', '+', '-', '+', '-'},
        {'7', '|', '8', '|', '9'}};
        printgameboard(gameboard);
        while (true) {
             System.out.println("Enter located u want(1:9) player1 :");
            int num1 = input.nextInt();
            while (player1.contains(num1) || player2.contains(num1)){ 
                System.out.println("postion taken! enter correct postion");
                num1 = input.nextInt();
            }
            located(gameboard, num1, "player1");
            String result = checkwinner();
            if (result.length() > 0) {
                System.out.println(result);
               break;
            }
            
            System.out.println("Enter located u want(1:9) player2 :");
            int num2 = input.nextInt();
            while (player1.contains(num2) || player2.contains(num2)) {
                System.out.println("postion taken! enter correct postion");
                num2 = input.nextInt();
            }
            located(gameboard, num2, "player2");
             result = checkwinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
            
        }
    }

    public static void located(char[][] gameboard, int num, String user) {
        char var = ' ';
        if (user.equals("player1")) {
            var = 'x';
            player1.add(num);
        } else if (user.equals("player2")) {
            var = 'o';
            player2.add(num);
        }
        switch (num) {
            case 1:
                gameboard[0][0] = var;
                break;
            case 2:
                gameboard[0][2] = var;
                break;
            case 3:
                gameboard[0][4] = var;
                break;
            case 4:
                gameboard[2][0] = var;
                break;
            case 5:
                gameboard[2][2] = var;
                break;
            case 6:
                gameboard[2][4] = var;
                break;
            case 7:
                gameboard[4][0] = var;
                break;
            case 8:
                gameboard[4][2] = var;
                break;
            case 9:
                gameboard[4][4] = var;
                break;
        }
        printgameboard(gameboard);
        
        }
     
    public static void printgameboard(char[][] gameboard) {
        for (char[] row : gameboard) {
           for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static String checkwinner() {
        List uprow = Arrays.asList(1, 2, 3);
        List middlerow = Arrays.asList(4, 5, 6);
        List downrow = Arrays.asList(7, 8, 9);
        List firstcol = Arrays.asList(1, 4, 7);
        List secondcol = Arrays.asList(2, 5, 8);
        List thirdcol = Arrays.asList(3, 6, 9);
        List firstdiagonal = Arrays.asList(1, 5, 9);
        List seconddiagonal = Arrays.asList(7, 5, 3);

        List<List> Winning = new ArrayList<List>();
        Winning.add(uprow);
        Winning.add(middlerow);
        Winning.add(downrow);
        Winning.add(firstcol);
        Winning.add(secondcol);
        Winning.add(thirdcol);
        Winning.add(firstdiagonal);
        Winning.add(seconddiagonal);
        for (List y : Winning) {
            if (player1.containsAll(y)) {
                return "congratulation " + name1 + " you won";
            } else if (player2.containsAll(y)) {
                return "congratulation"+ name2 +" you won";
            } else if (player1.size() + player2.size() == 9) {
                return "failed play again";
            }
        }
        return "";
    }

}
