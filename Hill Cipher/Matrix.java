
// https://github.com/rchen8/Algorithms/blob/master/Matrix.java

public class Matrix {
	
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray(); 

	private static int determinant(int[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);

        int det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    public static int[][] inverse(int[][] matrix) {
        int[][] inverse = new int[matrix.length][matrix.length];
        
        if(matrix.length == 2)
        {
        	int det = determinant(matrix);
        	int temp = matrix[0][0];
        	matrix[0][0] = matrix[1][1];
        	matrix[1][1] = temp;
     		
        	matrix[0][1] = - matrix[0][1];
        	matrix[1][0] = - matrix[1][0];
     		
             for (int i = 0; i < inverse.length; i++) {
                 for (int j = 0; j < inverse.length; j++) {
                    matrix[i][j] /= det;
                 }
             }
             return matrix;
        }
        else
        {
        	   // minors and cofactors
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix[i].length; j++)
                    inverse[i][j] = (int) (Math.pow(-1, i + j)
                            * determinant(minor(matrix, i, j)));

            // adjugate and determinant
            int det = (int) (1.0 / determinant(matrix));
            for (int i = 0; i < inverse.length; i++) {
                for (int j = 0; j <= i; j++) {
                    int temp = inverse[i][j];
                    inverse[i][j] = inverse[j][i] * det;
                    inverse[j][i] = temp * det;
                }
            }
        }
        return inverse;
    }

    private static int[][] minor(int[][] matrix, int row, int column) {
        int[][] minor = new int[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    public static int[][] mod(int[][] matrix)
    {
    	for(int i=0;i<matrix.length;i++)
    	{
    		for(int j=0;j<matrix.length;j++)
    		{
    			matrix[i][j] %= alphabet.length;
    			if(matrix[i][j]<0)
    				matrix[i][j] += alphabet.length;
    		}
    	}
    	return matrix;
    }
    
    public static int[][] multiply(int key[][],int matrix[][])
	{
    	int dimension = key.length;
		int[][] multiply = new int[dimension][1];
		int sum=0;
		for(int i=0;i<dimension;i++)
		{
			for(int j=0;j<dimension;j++)
				sum += key[i][j] * matrix[j][0];
			
			multiply[i][0] = sum;
			sum=0;
		}
		return multiply;
	}
}
