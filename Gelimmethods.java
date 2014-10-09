//John Devivo

//The purpose of this code is to outline the methods
//that will be performed when executing a gaussean
//elimination to solve for n variables in n equations
import java.lang.Math;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.*;


public class Gelimmethods
{

	private double[][] matrix;
	private double[] arr;

	// ---------------------
	public static void main(String[] args)
	{
		Textreader t= new Textreader(new File(args[0]));
		Gelimmethods g = new Gelimmethods(t.getMatrix());
		//g.printMatrix();
		for(int i=0; i<g.matrix.length; i++)
		{
			for(int j = (i+1); j<g.matrix.length; j++)
			{
				g.timesRow(i, ((g.matrix[j][i])/(g.matrix[i][i])));
				g.subRow(i, j);
				
				
			}
			if(i!=0)
			{
				for(int j=(i-1); j>= 0; j--)
				{
					g.timesRow(i, ((g.matrix[j][i])/(g.matrix[i][i])));
					g.subRow(i, j);
				}

			}
			//g.printMatrix();
			//System.out.println();
		}
		//g.printMatrix();
		//System.out.println();
		g.sum(t.getArr());




	}
	//----------------------------------------------


	public Gelimmethods(double[][] args)
	{
		matrix = args;
	//	printMatrix();
	//	swapRows(0,1);
	//	printMatrix();
	//	addRow(1,2);
	//	printMatrix();
	//	subRow(1,2);
	//	printMatrix();
	//	timesRow(0,2);
	//	printMatrix();
	}
	
	//this method prints out the matrix in its current state
	public void printMatrix()
	{
		System.out.println("Printing out Matrix in its Current Form");
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0; j<=matrix.length;j++)
			{
				//System.out.print(matrix[i][j]+ " ");
			}
			//System.out.println();
		}

	}

	//This method swaps two rows in the matrix
	public void swapRows(int i, int j)
	{
		//System.out.println("Swapping rows "+ (i) + " and " + (j));
		double[] temprow = new double[matrix[0].length];
		temprow = matrix[i];
		matrix[i] = matrix[j];
		matrix[j]= temprow;

	}

	//This method adds row matrix[p] to matrix[q]
	public void addRow(int p, int q)
	{
		//System.out.println("Adding row " + p + " to row " + q);
		for(int i=0;i<=matrix.length; i++)
		{
			matrix[q][i] = (matrix[q][i]+matrix[p][i]);
		}


	}	


	//This method subtracts row matrix[p] from matrix[q]
	public void subRow(int p, int q)
	{
		//System.out.println("Subtracting row " + p + " from row " + q);
		for(int i=0;i<=matrix.length; i++)
			{
				matrix[q][i] = (matrix[q][i]-matrix[p][i]);
			}

	}
	
	//This method multiplies a row matrix[p] by a constant factor c 
	public void timesRow(int p, double c)
	{
		//System.out.println("Multiplying row " + p +" by a constant factor " + c);
		for(int i=0;i<=matrix.length; i++)
		{
			matrix[p][i] = (matrix[p][i]*c);
		}
	}

	//returns the matrix
	public double[][] getMatrix()
	{
		return matrix;
	}

	//returns the sum as specified by the function in the input
	public int sum(int[] t)
	{

		int sum = 0;
		for(int i=0; i<matrix.length; i++)
		{
			sum +=(t[i] * Math.round(((matrix[i][matrix.length])/(matrix[i][i]))));
		}		

		System.out.println(sum);
		return sum;

	}

}