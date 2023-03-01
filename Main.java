package tictactoe;

import java.util.*;

public class Main {

    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
    public static void main(String[] args) {

        char gameboard[][] = {{' ','|',' ','|',' '}, {'-','+','-','+','-'}, {' ','|',' ','|',' '}, {'-','+','-','+','-'}, {' ','|',' ','|',' '}};

        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter the user: ");
            String user = sc.next();

            int pos = decidePosition(user);

            placePiece(gameboard, pos, user);
            displayGameBoard(gameboard);

            String result = winner();
            System.out.println(result);
        }

    }

    private static <list> String winner() {

        List<Integer> topRow = Arrays.asList(1,2,3);
        List<Integer> middleRow = Arrays.asList(4,5,6);
        List<Integer> bottomRow = Arrays.asList(7,8,9);
        List<Integer> leftCol = Arrays.asList(1,4,7);
        List<Integer> middleCol = Arrays.asList(2,5,8);
        List<Integer> rightCol = Arrays.asList(3,6,9);
        List<Integer> crossOne = Arrays.asList(1,5,9);
        List<Integer> crossTwo = Arrays.asList(7,5,3);

        List<List> list = new ArrayList<>();

        list.add(topRow);
        list.add(middleRow);
        list.add(bottomRow);
        list.add(leftCol);
        list.add(middleCol);
        list.add(rightCol);
        list.add(crossOne);
        list.add(crossTwo );

        for(List x: list) {
            if(playerPositions.containsAll(x)) {
                return "congratulations! you won!";
            } else if(cpuPositions.containsAll(x)){
                return "cpu won! sorry :(";
            } else if(playerPositions.size() + cpuPositions.size() == 9) {
                return "its a tie!";
            }
        }

        return "";
    }

    private static int decidePosition(String user) {

        Scanner sc = new Scanner(System.in);
        int pos;
        System.out.println("enter the pos: ");

        if(user.equals("player")) {
             pos = sc.nextInt();
        } else if(user.equals("cpu")) {
            Random rand = new Random();
            pos = rand.nextInt(9)+1;
        } else {
            return -1;
        }

        return pos;
    }

    private static void placePiece(char[][] gameboard, int pos, String user) {

        char symbol;

        if(user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if(user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        } else {
            symbol = ' ';
        }

        switch(pos) {
            case 1: gameboard[0][0] = symbol;
                break;
            case 2: gameboard[0][2] = symbol;
                break;
            case 3: gameboard[0][4] = symbol;
                break;
            case 4: gameboard[2][0] = symbol;
                break;
            case 5: gameboard[2][2] = symbol;
                break;
            case 6: gameboard[2][4] = symbol;
                break;
            case 7: gameboard[4][0] = symbol;
                break;
            case 8: gameboard[4][2] = symbol;
                break;
            case 9: gameboard[4][4] = symbol;
                break;
            default:
                System.out.println("invalid position!");
        }

    }
    private static void displayGameBoard(char gameboard[][]) {

        for(int i=0;i<gameboard.length;i++) {
            for(int j=0;j<gameboard[i].length;j++) {
                System.out.print(gameboard[i][j]);
            }
            System.out.println();
        }
    }
}
