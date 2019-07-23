
import java.util.*;

public class ColumnarCipher 
{
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static String encryption(String plainText,String key)
    {
        StringBuilder cipherText = new StringBuilder();
        int row = (int) Math.ceil((double) plainText.length() / key.length());
        Character[][] matrix = new Character[row][key.length()];
        int count = 0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<key.length();j++)
            {
                if(count >=plainText.length())
                    matrix[i][j] = 'j';
                else
                    matrix[i][j] = plainText.charAt(count);
                
                count++;
            }
        }
        
        System.out.println("Matrix = " + Arrays.deepToString(matrix));
       
        int[] indexs = getIndex(key);
        count = 0;

        for(int i=0;i<indexs.length;i++)
        {
        	if(indexs[i] == count)
        	{
        		for(int j=0;j<row;j++)
        		{
        			cipherText.append(matrix[j][i]);
        		}
        		
        		if(cipherText.length() != (matrix.length * matrix[0].length))
            		i=-1;
        		
        		count++;
        	}	
        }
        
        return cipherText.toString();
    } 
    
    public static String decryption(String cipherText,String key)
    {
        StringBuilder plainText = new StringBuilder();
        int row = (int) Math.ceil((double) cipherText.length() / key.length());
        Character[][] matrix = new Character[row][key.length()];
        int indexs[] = getIndex(key);
        int count = 0,count2=0;
        for(int i=0;i<indexs.length;i++)
        {
        	if(indexs[i] == count)
        	{
        		for(int j=0;j<cipherText.length()/key.length();j++)
        		{
        			matrix[j][i] = cipherText.charAt(count2++);
        		}
        		
        		if(cipherText.length() != count)
            		i=-1;
        		count++;
        	}	
        }
        
        System.out.println("Matrix = " + Arrays.deepToString(matrix));
        for(int i=0;i<matrix.length;i++)
        {
        	for(int j=0;j<matrix[0].length;j++)
        	{
        		plainText.append(matrix[i][j]);
        	}
        }
        
        return plainText.toString();
    } 
    
    public static int[] getIndex(String key)
    {
        int[] array = new int[key.length()];
        for(int i=0;i<key.length();i++)
        {
             for(int j=0;j<alphabet.length;j++)
            {
                if(alphabet[j] == key.charAt(i))
                    array[i] = j;
            }
        }
        
        int[] tempArray = Arrays.copyOf(array, array.length);
        
        Arrays.sort(array);

        for(int i=0;i<tempArray.length;i++)
        {
        	for(int j=0;j<array.length;j++)
        	{
        		if(tempArray[i] == array[j])
        		{
        			tempArray[i] = j;
        			break;
        		}
        	}
        }
       
        return tempArray;
    }

	public static void main(String[] args) 
	{
		String plainText = "can you hear me ? ";
		String key = "software";
		System.out.println("Acik metin : " + plainText);
		System.out.println("Anahtar : " + key);
		
		String cipherText = encryption(plainText,key);
		System.out.println("Sifreli Metin = " + cipherText);
		
		String decryptedText = decryption(cipherText,key);
		System.out.println("Acik Metin : " + decryptedText);
	}
}
