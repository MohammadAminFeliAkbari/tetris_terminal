import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner input = new Scanner(System.in);

        System.out.println("""
                hello!! 
                welcome to tetris game
                                
                guide game :
                ( [r] or [R] = rotate 180)
                ( [e] or [E] = rotate 90 )
                ( [f] or [F] = right     )
                ( [d] or [D] = down      )
                ( [s] or [s] = left      )
                                
                do you want to play?? ( Y or N )
                                
                """);

        String game_option = input.next();
        if (game_option.charAt(0) == 'n' || game_option.charAt(0) == 'N')
            System.exit(0);

        board.for_game_main_meno();
        if (board.getScore_game() < 0)
            ClearConsole.clearConsole();
        System.out.println("""
                you lost
                are you play again??
                                    
                1-new game
                2-exit
                """);
        int number = input.nextInt();

        switch (number) {
            case 1:
                Board board1 = new Board();
                board1.for_game_main_meno();
                break;
            case 2:
                break;
        }
//        Board board = new Board();
//        {
//            board.print_block();
//            board.print_game_0_1();
////        board.game_original();
//        }
//        Scanner input = new Scanner(System.in);
//        boolean flag = true;
//        while (flag) {
//            board.arried_line_14();
//            String n = input.next();
//            board.full_line();
//            if (n.charAt(0) == 'f' || n.charAt(0) == 'F')
//                board.right();
//            else if (n.charAt(0) == 's' || n.charAt(0) == 'S')
//                board.left();
//            else if (n.charAt(0) == 'r' || n.charAt(0) == 'R')
//                board.rotate();
//            else if (n.charAt(0) == 'd' || n.charAt(0) == 'D')
//                board.down();
//            else if (n.charAt(0) == 'e' || n.charAt(0) == 'E')
//                flag = false;
//            else {board.print_game_0_1();
////                board.game_original();
//            }
//            {
//                System.out.println();
//                board.arried_line_14();
//                System.out.println("----------------------------------------");
//                board.print_game_0_1();
////            board.game_original();}
//            }
//        }
    }
}
