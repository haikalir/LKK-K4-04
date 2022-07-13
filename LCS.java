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

    }
 
    void printTable(){
        
    }
 
    void printResult(){
        
    }
    
    void printResult(String[][] b, String[] arrX, int i, int j){

    }
}
