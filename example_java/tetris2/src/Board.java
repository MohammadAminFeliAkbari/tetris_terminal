import java.awt.font.TextHitInfo;
import java.lang.reflect.Array;
import java.util.*;

public class Board {
    private int satr = 15;
    private int soton = 10;
    private int score_game = 0;
    private int[][] arr;

    //______________constructor_____________________
    Board() {
        this.arr = new int[this.satr][this.soton];
        for (int i = 3; i < this.satr; i++) {
            for (int j = 0; j < this.soton; j++) {
                if (j == 0 || j == this.soton - 1)
                    this.arr[i][j] = 1;
                else this.arr[i][j] = 0;
                if (i == satr - 1)
                    this.arr[i][j] = 2;
            }
        }
    }

    //_________________method__________________________
    public void game_original() {
        for (int i = 0; i < this.satr; i++) {
            for (int j = 0; j < this.soton; j++) {
                if (arr[i][j] == 1 || arr[i][j] == 2 || arr[i][j] == 3)
                    System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
//        System.out.printf("your score = %d", this.score_game);
    }

    public void print_game_0_1() {
        for (int i = 0; i < this.satr; i++) {
            for (int j = 0; j < this.soton; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    public void arried_line_14() {

        boolean flag = true;
        for (int i = 1; i < this.soton - 1; i++) {
            if (arr[this.satr - 2][i] == 1) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            for (int j = 0; j < this.satr - 1; j++) {
                for (int k = 1; k < this.soton - 1; k++) {
                    if (arr[j][k] == 1)
                        arr[j][k] = 2;
                }
            }
            this.print_block();
        }
    }

    public void full_line() {

        ArrayList<Integer> vector = new ArrayList<>();

        for (int i = 0; i < 14; i++)
            if (arr[i][1] == 2 && arr[i][2] == 2 && arr[i][3] == 2 && arr[i][4] == 2 && arr[i][5] == 2 && arr[i][6] == 2 && arr[i][7] == 2 && arr[i][8] == 2) {
                vector.add(i);
                this.score_game += 100;
            }


        if (vector.size() != 0)
            for (int full_satr : vector) {
                for (int j = 1; j < this.soton - 1; j++)
                    arr[full_satr][j] = 0;

                for (int k = full_satr - 1; k > -1; k--)
                    for (int j = this.soton - 2; j > 0; j--)
                        if (arr[k][j] == 2) {
                            arr[k + 1][j] = 2;
                            arr[k][j] = 0;
                        }
            }
    }

    public void full_soton() {

        boolean flag = true;
        boolean counter = false;

        ArrayList<Integer> satr_hazf_shode = new ArrayList<>();

        while (flag) {
            int example = 0;
            for (int i = this.soton - 2; i > 0; i--) {
                if (arr[3][i] == 2)
                    example++;
            }

            if (example != 0) {
                counter = true;
//                this.score_game -= 10;
                for (int i = this.soton - 2; i > 0; i--) {
                    if (arr[3][i] == 2) {
                        satr_hazf_shode.add(i);
                        this.score_game -= 10;

                        for (int j = 3; j < this.satr - 1; j++)
                            arr[j][i] = 0;
                    }
                }
            } else flag = false;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.soton; j++) {
                arr[i][j] = 0;
            }
        }

        for (int l = 0; l < 20; l++)
            if (counter) {
                for (int i = this.satr - 2; i > -1; i--)
                    for (int j = this.soton - 2; j > 0; j--)
                        if (arr[i][j] == 2) {
                            if (arr[i + 1][j] != 2 && arr[i + 1][j + 1] != 2 && arr[i + 1][j - 1] != 2)
                                arr[i][j] = 1;
                        }
                this.down_for_full_satr();
            }

        //-------------------------------------------------------
//
//        int max_satr = 0;
//        for (Integer integer : satr_hazf_shode)
//            if (integer > max_satr)
//                max_satr = integer;
//
//        int min_satr = 0;
//        try {
//            min_satr = satr_hazf_shode.get(0);
//        } catch (Exception erro) {
//            min_satr = 0;
//        }
//        for (Integer integer : satr_hazf_shode)
//            if (min_satr > integer)
//                min_satr = integer;
//
//        ArrayList<Integer> empty_cell = new ArrayList<>();
//
//        for (int i = this.satr - 2; i > -1; i--)
//            for (int j = 1; j < min_satr; j++) {
//                if (arr[i][j] == 2)
//                    for (int k = 1; k < this.satr - i; k++)
//                        if (arr[i + k][j] == 2)
//                            empty_cell.add(k - 1);
//
//                int min_go_down = 100;
//
//                for (Integer integer : empty_cell)
//                    if (min_go_down > integer)
//                        min_go_down = integer;
//
//                for (int k = 1; k < min_satr; k++)
//                    if (arr[i][k] == 2) {
//                        arr[i + min_go_down][k] = 2;
//                        arr[i][k] = 0;
//                    }
//            }
    }

    public void print_block() {
        this.full_soton();
        this.full_line();
//        ____________________
        Random rnd = new Random();

        int counter = rnd.nextInt(3, 7);
        arr[0][counter] = 1;
        int num_star = rnd.nextInt(2, 7);

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j < this.satr - 8; j++) {
                int number = rnd.nextInt(3);
                if (num_star > 0)
                    switch (number) {
                        case 0:
                            if (arr[i][counter] == 1 && arr[i + 1][counter] == 0) {
                                arr[i + 1][counter] = 1;
                                i++;
                            }
                            num_star--;
                            break;
                        case 1:
                            if (arr[i][counter] == 1 && arr[i][counter - 1] == 0) {
                                arr[i][counter - 1] = 1;
                                counter--;
                            }
                            num_star--;
                            break;
                        case 2:
                            if (arr[i][counter] == 1 && arr[i][counter + 1] == 0) {
                                arr[i][counter + 1] = 1;
                                counter++;
                            }
                            num_star--;
                            break;
                    }
            }
        }
        arr[0][0] = 0;
        arr[1][0] = 0;
        arr[2][0] = 0;
        arr[0][9] = 0;
        arr[1][9] = 0;
        arr[2][9] = 0;


    }

    public void down_for_full_satr() {
        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1 && arr[i + 1][j] != 2) {
                    arr[i + 1][j] = 1;
                    arr[i][j] = 0;
                }
        for_2_block_for_full_satr();
    }

    public void for_2_block_for_full_satr() {
        boolean for_2 = false;
        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1 && arr[i + 1][j] == 2) {
                    for_2 = true;
                    break;
                }


        if (for_2)
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1) {
                        arr[i][j] = 2;
                    }
    }

    public void down() {
        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1 && arr[i + 1][j] != 2) {
                    arr[i + 1][j] = 1;
                    arr[i][j] = 0;
                }
        for_2_block();
    }

    public void right() {
        boolean flag = false;

        if (out_of_range_right())
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1 && right_right2()) {
                        flag = true;
                        break;
                    }

        if (flag)
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1) {
                        arr[i + 1][j + 1] = 1;
                        arr[i][j] = 0;
                    }
        for_2_block();
    }

    public boolean right_right2() {
        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1 && arr[i + 1][j + 1] == 2)
                    return false;
        return true;
    }

    public void left() {
        boolean flag = false;

        if (out_of_range_left())
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1 && left_left2()) {
                        flag = true;
                        break;
                    }
        if (flag)
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1) {
                        arr[i + 1][j - 1] = 1;
                        arr[i][j] = 0;
                    }

        for_2_block();
    }

    public boolean left_left2() {
        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1 && arr[i + 1][j - 1] == 2)
                    return false;
        return true;
    }

    //    public void left() {
//        for (int i = this.satr - 2; i > -1; i--)
//            for (int j = this.soton - 2; j > 0; j--)
//                if (arr[i][j] == 2 && arr[i - 1][j] == 1) {
//                    arr[i - 1][j] = 2;
//                }
//        if (this.out_of_range_left())
//            for (int i = this.satr - 2; i > -1; i--)
//                for (int j = this.soton - 2; j > 0; j--)
//                    if (arr[i][j] == 1) {
//                        arr[i + 1][j - 1] = 1;
//                        arr[i][j] = 0;
//                    }
//    }
//    public void left() {
//        boolean flag = true;
//        boolean for_2 = false;
//        if (this.out_of_range_left()) {
//            for (int i = this.satr - 2; i > -1; i--) {
//                for (int j = this.soton - 2; j > 0; j--) {
//                    if (flag) {
//                        if (arr[i][j] == 1) {
//                            if (j > 1 && i < 12 && arr[i + 2][j - 2] == 2 && arr[i][j] == 1) {
//                                flag = false;
//                            }
//                            if (flag) {
//                                arr[i + 1][j - 1] = 1;
//                                arr[i][j] = 0;
//                            }
//                        }
//                        if (j > 1 && i < 12 && arr[i + 2][j - 2] == 2 && arr[i][j] == 1)
//                            for_2 = true;
//                    }
//                }
//            }
//
//            if (for_2) {
//                for (int i = this.satr - 2; i > -1; i--) {
//                    for (int j = this.soton - 2; j > 0; j--) {
//                        if (arr[i][j] == 1 && arr[i + 1][j] == 2) {
//                            arr[i + 1][j - 1] = 2;
//                            arr[i][j] = 0;
//                        }
//                    }
//                }
//                this.print_block();
//            }
//        }
//    }
//
//
//    public void right() {
//        boolean flag = true;
//        boolean for_2 = false;
//
//        if (this.out_of_range_right()) {
//            for (int i = this.satr - 2; i > -1; i--) {
//                for (int j = this.soton - 2; j > 0; j--) {
//                    if (flag) {
//                        if (arr[i][j] == 1) {
//                            if (j < 8 && i < 12 && arr[i + 2][j + 2] == 2 && arr[i][j] == 1) {
//                                flag = false;
//                                for_2 = true;
//                            }
//                            if (flag) {
//                                arr[i + 1][j + 1] = 1;
//                                arr[i][j] = 0;
//                            }
//                        }
//                    }
//                }
//            }
//
//            if (for_2) {
//                for (int i = this.satr - 2; i > -1; i--) {
//                    for (int j = this.soton - 2; j > 0; j--) {
//                        if (arr[i][j] == 1) {
//                            arr[i + 1][j + 1] = 2;
//                            arr[i][j] = 0;
//                        }
//                    }
//                }
//                this.print_block();
//            }
//        }
//
//            boolean left = false;
//            boolean down = false;
//            int total_1 = 0;
//            int sum_left = 0;
//            int sum_down = 0;
//
//            for (int i = this.satr - 2; i > -1; i--) {
//                for (int j = this.soton - 2; j > 0; j--) {
//                    if (arr[i][j] == 1)
//                        total_1++;
//                }
//            }
//            if (for_2) {
//                for (int i = this.satr - 2; i > -1; i--) {
//                    for (int j = this.soton - 2; j > 0; j--) {
//                        if (j > 2 && i > 1 && arr[i][j] == 1 && arr[i - 1][j - 1] == 0)
//                            sum_left++;
//                        if (sum_left == total_1)
//                            left = true;
//
//                        if (i < 13 && arr[i][j] == 1 && arr[i + 1][j] == 0)
//                            sum_down++;
//                        if (sum_down == total_1)
//                            down = true;
//                    }
//                }
//
//                if (down == false && left == false) {
//                    for (int i = this.satr - 2; i > -1; i--) {
//                        for (int j = this.soton - 2; j > 0; j--) {
//                            if (arr[i][j] == 1 && arr[i + 1][j + 1] == 0) {
//                                arr[i + 1][j + 1] = 1;
//                                arr[i][j] = 0;
//                            }
//                        }
//                    }
//                    this.print_block();
//                }
//            }
//        }
//    public void down() {
//        boolean flag = true;
//        boolean for_2 = false;
//
//        for (int i = this.satr - 2; i > -1; i--) {
//            for (int j = this.soton - 2; j > 0; j--) {
//                if (flag) {
//                    if (arr[i][j] == 1) {
//                        if (j < 8 && i < 12 && arr[i + 2][j] == 2 && arr[i][j] == 1) {
//                            flag = false;
//                            for_2 = true;
//                        }
//                        if (flag) {
//                            arr[i + 1][j] = 1;
//                            arr[i][j] = 0;
//                        }
//                    }
//                }
//            }
//        }
//
//        if (for_2) {
//            for (int i = this.satr - 2; i > -1; i--) {
//                for (int j = this.soton - 2; j > 0; j--) {
//                    if (arr[i][j] == 1) {
//                        arr[i + 1][j] = 2;
//                        arr[i][j] = 0;
//                    }
//                }
//            }
//            this.print_block();
//        }
//
//    }
//    public void left() {
//        for (int i = this.satr - 2; i > -1; i--)
//            for (int j = this.soton - 2; j > 0; j--)
//                if (arr[i][j] == 2 && arr[i - 1][j] == 1) {
//                    arr[i - 1][j] = 2;
//                }
//        if (this.out_of_range_left())
//            for (int i = this.satr - 2; i > -1; i--)
//                for (int j = this.soton - 2; j > 0; j--)
//                    if (arr[i][j] == 1) {
//                        arr[i + 1][j - 1] = 1;
//                        arr[i][j] = 0;
//                    }
//    }
//    public void left() {
//        boolean flag = true;
//        boolean for_2 = false;
//        if (this.out_of_range_left()) {
//            for (int i = this.satr - 2; i > -1; i--) {
//                for (int j = this.soton - 2; j > 0; j--) {
//                    if (flag) {
//                        if (arr[i][j] == 1) {
//                            if (j > 1 && i < 12 && arr[i + 2][j - 2] == 2 && arr[i][j] == 1) {
//                                flag = false;
//                            }
//                            if (flag) {
//                                arr[i + 1][j - 1] = 1;
//                                arr[i][j] = 0;
//                            }
//                        }
//                        if (j > 1 && i < 12 && arr[i + 2][j - 2] == 2 && arr[i][j] == 1)
//                            for_2 = true;
//                    }
//                }
//            }
//
//            if (for_2) {
//                for (int i = this.satr - 2; i > -1; i--) {
//                    for (int j = this.soton - 2; j > 0; j--) {
//                        if (arr[i][j] == 1 && arr[i + 1][j] == 2) {
//                            arr[i + 1][j - 1] = 2;
//                            arr[i][j] = 0;
//                        }
//                    }
//                }
//                this.print_block();
//            }
//        }
//    }
    public void for_2_block() {
        boolean for_2 = false;
        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1 && arr[i + 1][j] == 2) {
                    for_2 = true;
                    break;
                }


        if (for_2)
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1) {
                        arr[i][j] = 2;
                    }
        if (for_2)
            this.print_block();
    }

    public boolean out_of_range_right() {
        for (int i = 0; i < this.satr - 1; i++) {
            if (arr[i][8] == 1)
                return false;
        }
        return true;
    }

    public boolean out_of_range_left() {
        for (int i = 0; i < this.satr - 1; i++) {
            if (arr[i][1] == 1)
                return false;
        }
        return true;
    }

    public void rotate_180() {

        int[][] arr_test = new int[15][10];

        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1)
                    arr_test[i][j] = 1;

        try {
            int[] str_rotate = new int[15];
            int l = 0;

            for (int i = 0; i < this.satr - 1; i++)
                for (int j = 1; j < this.soton - 1; j++)
                    if (arr[i][j] == 1) {
                        str_rotate[l] += i;
                        i++;
                        l++;
                    }

            for (int i = 0; i < this.satr - 1; i++) {
                for (int j = 1; j < this.soton - 1; j++) {
                    if (arr[i][j] == 1)
                        if (i != str_rotate[0]) {
                            int k = i - str_rotate[0];
                            arr[Math.abs(i - (2 * k))][j] = arr[i][j];
                            arr[i][j] = 0;
                        }
                }
            }
        } catch (Exception er) {
            System.out.println("error for rotate 180");
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--) {
                    if (arr_test[i][j] == 1)
                        arr[i][j] = 1;
                }
        }
    }

    public void rotate_90() {
        int[][] arr_test = new int[15][10];

        for (int i = this.satr - 2; i > -1; i--)
            for (int j = this.soton - 2; j > 0; j--)
                if (arr[i][j] == 1)
                    arr_test[i][j] = 1;

        try {
            ArrayList<Integer> satr = new ArrayList<>();
            ArrayList<Integer> soton = new ArrayList<>();

            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1) {
                        satr.add(i);
                    }

            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 1) {
                        soton.add(j);
                    }

            int mid_satr = 0;
            int mid_soton = 0;

            for (int integer : satr) {
                mid_satr += integer;
            }
            mid_satr /= satr.size();

            for (int integer : soton) {
                mid_soton += integer;
            }
            mid_soton /= soton.size();

            for (int i = 0; i < satr.size(); i++)
                if (arr[satr.get(i)][soton.get(i)] == 1 || arr[satr.get(i)][soton.get(i)] == 3) {
                    if (arr[satr.get(i)][soton.get(i)] != 3)
                        arr[satr.get(i)][soton.get(i)] = 0;
                    arr[mid_satr - mid_soton + soton.get(i)][mid_satr + mid_soton - satr.get(i)] = 3;

                }

            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--)
                    if (arr[i][j] == 3)
                        arr[i][j] = 1;
        } catch (Exception er) {
            System.out.println("error for rotate 90");
            for (int i = this.satr - 2; i > -1; i--)
                for (int j = this.soton - 2; j > 0; j--) {
                    if (arr[i][j] == 3)
                        arr[i][j] = 0;
                    if (arr_test[i][j] == 1)
                        arr[i][j] = 1;
                }
        }
    }

    public void for_game_main_meno() {
        {
            this.print_block();
//            this.print_game_0_1();
            this.game_original();
            if (this.getScore_game() >= 0)
                System.out.println("score game = " + this.score_game);
            else System.out.println("score game = " + 0);

        }
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            this.arried_line_14();
            String n = input.next();
            ClearConsole.clearConsole();
            this.full_line();
            if (n.charAt(0) == 'f' || n.charAt(0) == 'F')
                this.right();
            else if (n.charAt(0) == 's' || n.charAt(0) == 'S')
                this.left();
            else if (n.charAt(0) == 'r' || n.charAt(0) == 'R')
                this.rotate_180();
            else if (n.charAt(0) == 'd' || n.charAt(0) == 'D')
                this.down();
            else if (n.charAt(0) == 'e' || n.charAt(0) == 'E')
                this.rotate_90();
            else {
                this.print_game_0_1();
//                this.game_original();
                if (this.getScore_game() >= 0)
                    System.out.println("score game = " + this.score_game);
                else System.out.println("score game = " + 0);

            }
            {
                System.out.println();
                this.arried_line_14();
//                System.out.println("----------------------------------------");
//                this.print_game_0_1();
                this.game_original();
            }
            if (this.getScore_game() >= 0)
                System.out.println("score game = " + this.score_game);
            else System.out.println("score game = " + 0);

            if (this.score_game < 0) {
                flag = false;
            }
        }
    }

    public int getScore_game() {
        return score_game;
    }
}