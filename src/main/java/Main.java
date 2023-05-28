import sudoku.Algoritm;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Algoritm sudoku = new Algoritm();
        int[][] table = new int[9][9];
        /*table[0] = new int[] {0,0,0,0,0,7,0,0,0};
        table[1] = new int[] {7,0,4,0,1,0,0,0,0};
        table[2] = new int[] {0,0,6,0,0,4,2,0,7};
        table[3] = new int[] {0,0,0,8,0,0,0,0,1};
        table[4] = new int[] {0,0,0,0,0,0,6,7,4};
        table[5] = new int[] {0,0,0,1,0,3,0,0,2};
        table[6] = new int[] {0,3,0,5,9,0,0,0,0};
        table[7] = new int[] {1,0,0,0,0,0,9,0,0};
        table[8] = new int[] {0,2,0,0,0,0,0,6,0};*/
        /*table[0] = new int[] {0,0,0,6,7,2,0,4,0};
        table[1] = new int[] {0,2,7,5,0,9,0,3,6};
        table[2] = new int[] {6,4,0,0,3,1,0,7,0};
        table[3] = new int[] {0,7,0,9,2,0,0,1,0};
        table[4] = new int[] {1,0,5,0,6,3,2,0,0};
        table[5] = new int[] {0,6,2,4,0,0,7,0,0};
        table[6] = new int[] {0,9,0,0,0,0,0,0,0};
        table[7] = new int[] {2,0,8,3,9,0,0,0,0};
        table[8] = new int[] {7,0,0,2,0,0,9,6,1};*/
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Введите команду: ");
            String line = scanner.nextLine();
            switch (line){
                case ("решить"):
                    System.out.println("введите поле построчно, между цифрами ставим пробел, пустое поле это 0");
                    for (int i =0;i<9;i++){
                        String str = scanner.nextLine();
                        String[] znach = str.split(" ");
                        int[] intZnach = new int[9];
                        for (int j =0;j<9;j++){
                            intZnach[j]=Integer.parseInt(znach[j]);
                        }
                        table[i] = intZnach;


                    }
                    sudoku.createMatrix(table);
                    sudoku.guess();
                    sudoku.printMatrix();
                    break;


                default:
                    break;
            }
        }
    }
}