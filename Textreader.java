//John Devivo
//The purpose of this program is to read in a text file
//and create a two dimensional array of doubles.

//Input: Text File of a format specified by Prof. Duncan

//Output: nxm two dimensional array to be used to perform 
//Elimination

import java.lang.Math;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Textreader
{
		private Scanner fileinput;
		private File file;
		private int degree;
		private double[][] matrix;
		private int[] arr; 


	//temporary test main ------------------------------
	//public static void main(String[] args){
	//	Textreader a = new Textreader(new File(args[0]));

	//}
	//-------------------------------------------------

	//Constructor takes text file as input and copies its data into
	//the matrix.
	public Textreader(File infile)
	{
		file = infile;
		//System.out.println("Opening the file and Copying it into a Matrix");

		try
		{
			//Scanner for file set up
			fileinput = new Scanner(file);

			degree = fileinput.nextInt();

			//creates array of size [degree][degree+1]
			matrix = new double[degree][(degree+1)];

			//reads values in imput file and copies
			//them into the matrix
			fileinput.nextLine();
			for(int i =0;i<degree;i++)
			{
				for(int j = 0; j<=degree;j++)
				{
					matrix[i][j]=fileinput.nextDouble();
					//System.out.print(matrix[i][j] + " ");
				}
				fileinput.nextLine();
				//System.out.println(); 
			}
			arr = new int[degree];
			for(int i = 0; i<degree; i++)
			{
				arr[i] = fileinput.nextInt();
			}


		}

		catch(FileNotFoundException e)
		{
			System.out.println(e);
			System.exit(1);		// i/o error, exit program
		}
	}



	//returns the completed, copied matrix
	double[][] getMatrix()
	{
		return matrix;

	}


	//Returns the array of doubles that represent the end
	//expression that is to be evaluated after the gaussean
	//elimination
	int[] getArr()
	{
		return arr;
	}

}