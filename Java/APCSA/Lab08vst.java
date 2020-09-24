// Redacted Classmate, Redacted, Redacted Classmate
// Lab08vst.java
// This is the Student Starting file for Lab08.

import java.text.DecimalFormat;

public class Lab08vst
{
   public static int row = 0;
   public static int col = 0;
   public static int moves = 1;
   
   public static void main (String[] args)
   {
      int[][] board = new int[8][8];
      startBoard(board);
      for (int move = 0; move < 64; move++)
      {
          nextMove(board);
      }
      showBoard(board);
   } 
   
   public static boolean checkVisit(int[][] brd, int row, int col)
   {
      boolean noVisit = brd[row][col] == 0;
      return noVisit;
   } 
   
   // Finds the next move if possible
   public static void nextMove(int[][] brd)
   {
      if (row-2 >= 0 && col+1 <= 7)
      {
         if (checkVisit(brd,row-2,col+1))
         {
            row-=2; col+=1;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
      if (row-2 >= 0 && col-1 >= 0)
      {
         if (checkVisit(brd,row-2,col-1))
         {
            row-=2; col-=1;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
      if (row-1 >= 0 && col+2 <= 7)
      {
         if (checkVisit(brd,row-1,col+2))
         {
            row-=1; col+=2;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
      if (row+1 <= 7 && col+2 <= 7)
      {
         if (checkVisit(brd,row+1,col+2))
         {
            row+=1; col+=2;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
      if (row+2 <= 7 && col+1 <= 7)
      {
         if (checkVisit(brd,row+2,col+1))
         {
            row+=2; col+=1;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
      if (row+2 <= 7 && col-1 >= 0)
      {
         if (checkVisit(brd,row+2,col-1))
         {
            row+=2; col-=1;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
      if (row+1 <= 7 && col-2 >= 0)
      {
         if (checkVisit(brd,row+1,col-2))
         {
            row+=1; col-=2;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
      if (row-1 >= 0 && col-2 >= 0)
      {
         if (checkVisit(brd,row-1,col-2))
         {
            row-=1; col-=2;
            moves++;
            brd[row][col] = moves;
            return;
         } 
      }
   } 
   
   public static void startBoard(int[][] brd)
   {
      for (int r = 0; r <= 7; r++) {
         for (int c = 0; c <= 7; c++) {
            brd[r][c] = 0;
        }
      }
      brd[row][col] = 1;
   }
   
   public static void showBoard(int[][] brd)
   {
      DecimalFormat twoDigits = new DecimalFormat("00");
      for (int r = 0; r <=7; r++)
      {
         for (int c = 0; c <= 7; c++)
         {
            System.out.print(twoDigits.format(brd[r][c]) + "  ");
         }
         System.out.println();
      }
      System.out.println();
   }          
}