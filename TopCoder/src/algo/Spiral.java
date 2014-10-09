package algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Spiral {
	public static void main(String args[]) throws Exception {

		BufferedReader stdin = new BufferedReader(new InputStreamReader(
				System.in));
		String test = stdin.readLine();
		String[] size = test.split(",");

		int numRows = Integer.parseInt(size[0]);
		int numCols = Integer.parseInt(size[1]);
		int totalRecords = numRows * numCols;
		int i = 0, j = 0;
		int[][] input = new int[numRows][numCols];
		String temp;
		while (i < numRows) {
			temp = stdin.readLine();
			size = temp.split(",");

			while (j < numCols) {
				input[i][j] = Integer.parseInt(size[j++]);
			}
			j = 0;
			i++;
		}
		int k = numCols;
		int l = numRows;

		int topRow = 0;
		int bottomRow = numRows - 1;
		int leftCol = 0;
		int rightCol = numCols - 1;

		while (topRow <=bottomRow && leftCol <=rightCol) {
			if(topRow ==bottomRow && leftCol ==rightCol)
				System.out.println(input[topRow][leftCol]);
			for (j = leftCol; j < rightCol; j++)
				System.out.print(input[topRow][j] + ",");
			for (i = topRow; i < bottomRow; i++)
				System.out.print(input[i][rightCol] + ",");
			for (i = rightCol; i > leftCol; i--)
				System.out.print(input[bottomRow][i] + ",");
			for (j = bottomRow; j > topRow; j--)
				System.out.print(input[j][leftCol] + ",");

			topRow++;
			bottomRow--;
			leftCol++;
			rightCol--;
		}
		
		
		
		
		
		

	}
}