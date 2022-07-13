/*
   Haikal Irfano 215150207111043
   Raditya Atmaja Satria Permadhi 215150207111042
   Yehezkiel Stephanus Austin 215150207111053
*/

import java.util.Scanner;

public class LCS{
 
  public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        // Title
        System.out.println("LCS\n");

        // Input
        System.out.print("Input X\t= ");
        String x = input.nextLine();
        String[] arrX = x.split(" ");
        System.out.print("Input Y\t= ");
        String y = input.nextLine();
        String[] arrY = y.split(" ");
        
        // LCS Object
        Table lcs = new Table(arrX, arrY);
        
        lcs.printTable();

        lcs.printResult();

        input.close();
    }
}

class Table{
  
    String[] arrX;
    String[] arrY;

    String[][] b;
    int[][] c;
 
    Table(String[] arrX, String[] arrY){

        this.arrX = arrX;
        this.arrY = arrY;

        int m = arrX.length;
        int n = arrY.length;

        // Make array
        b = new String[m + 1][n + 1];
        c = new int[m + 1][n + 1];

        // Fill array
        for (int i = 1; i <= m; i++) {
            
            c[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            
            c[0][j] = 0;
        }

        // Algorithm
        for (int i = 1; i <= m; i++) {
            
            for (int j = 1; j <= n; j++) {
                
                if(arrX[i - 1].equals(arrY[j - 1])){

                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = "\\";
                }
                else if(c[i - 1][j] >= c[i][j - 1]){

                    c[i][j] = c[i - 1][j];
                    b[i][j] = "|";
                }
                else{

                    c[i][j] = c[i][j - 1];
                    b[i][j] = "-";
                }
            }
        }
    }
 
    void printTable(){
        
        System.out.println("\nTabel C (Angka)");
        for (int i = 0; i < c.length; i++) {
            
            for (int j = 0; j < c[i].length; j++) {
                
                System.out.print(c[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("\nTabel B (Arah));
        for (int i = 0; i < b.length; i++) {
            
            for (int j = 0; j < b[i].length; j++) {
                
                System.out.print(b[i][j] + "\t");
            }
            System.out.println("");
        }
        System.out.println("");
    }
                           
    void printResult(){
        
        System.out.print("LCS\t= ");
        printResult(b, arrX, arrX.length, arrY.length);
    }
    
    void printResult(String[][] b, String[] arrX, int i, int j){
        
        if(i == 0 || j == 0){

            return;
        }
        else if(b[i][j].equals("\\")){

            printResult(b, arrX, i - 1, j - 1);
            System.out.print(arrX[i - 1] + " ");
        }
        else if(b[i][j].equals("|")){

            printResult(b, arrX, i - 1, j); 
        }
        else{

            printResult(b, arrX, i, j - 1);
        }
    }
}
