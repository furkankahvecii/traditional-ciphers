import java.util.*;

public class HillCipher {
	
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	static Map<Integer,String> otherCharacters = new HashMap<Integer,String>();
	
	public static String encryption(StringBuilder plainText,int[][] key) 
	{
		StringBuilder cipherText = new StringBuilder();
		int add = plainText.length() % key.length;
		while(add>0)
		{
			add--;
			plainText.append('x');
		}
		
		for(int i=0;i<plainText.length();i+=key.length)
		{
			int[][] matrix = new int[key.length][1];
			for(int j=i;j<i+key.length;j++)
			{
				if(Character.isLetter(plainText.charAt(j)))
					matrix[j-i][0] = turn(plainText.charAt(j));
				else
					otherCharacters.put(j,String.valueOf(plainText.charAt(j)));
			}

			int[][] finalMatrix = Matrix.multiply(key,matrix);
			String cipherTextPart = unturn(finalMatrix);
			cipherText.append(cipherTextPart);
		}
		
		return cipherText.toString();
	}
	
	
	public static String decryption(String cipherText,int[][] key)
	{
		StringBuilder plainText = new StringBuilder();
		int[][] inversionMatrix = Matrix.inverse(key);
		inversionMatrix = Matrix.mod(inversionMatrix);
		System.out.println("Anahtar Matrisinin Tersi :" +Arrays.deepToString(inversionMatrix));
		for(int i=0;i<cipherText.length();i+=key.length)
		{
			int[][] matrix = new int[key.length][1];
			for(int j=i;j<i+key.length;j++)
				matrix[j-i][0] = turn(cipherText.charAt(j));

			int[][] finalMatrix = Matrix.multiply(inversionMatrix,matrix);	
			String plainTextPart = unturn(finalMatrix);
			plainText.append(plainTextPart);
		}
		
		for(int a : otherCharacters.keySet())
		{
			plainText.replace(a,a,otherCharacters.get(a));
			plainText.deleteCharAt(a+1);
		}

		return plainText.toString();
	}
	
	public static int turn(char q)
	{
		for(int i=0;i<alphabet.length;i++)
		{
			if(alphabet[i] == q || alphabet[i] == Character.toLowerCase(q))
				return i;
		}
		return 0;
	}
	
	public static String unturn(int[][] sonuc)
	{
		StringBuilder answer = new StringBuilder();
		
		for(int i=0;i<sonuc.length;i++)
		{
			int q = (sonuc[i][0] % alphabet.length) + 'a';
			answer.append((char)q);
		}
		return answer.toString();
	}

	public static void main(String[] args) 
	{
		StringBuilder plainText = new StringBuilder("KLU YAZILIM MÜHENDİSLİGİ");
		System.out.println("Metnin Açık Hali :"+plainText);
		
		int[][] key2x = { { 1,2 } , { 0,1 } , { 5,6 } };
		
		int[][] key3x = { { 1,2,3 } , { 0,1,4 } , { 5,6,0 } };
		
		System.out.println("Anahtar Matrisi :"+Arrays.deepToString(key3x));

		String cipherText = encryption(plainText,key3x);
		System.out.println("Metnin Şifrelenmiş Hali :"+cipherText);
		
		String plainTextNew = decryption(cipherText, key3x);
		System.out.println("Metnin Çözülmüş Hali :"+plainTextNew);
	}
}
