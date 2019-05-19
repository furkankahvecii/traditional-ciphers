import java.util.ArrayList;
import java.util.Arrays;

public class TrifidCipher {
	
	static char alphabetsMatrix[][][] = {  {{'A','B','C'} , {'D','E','F'} , {'G','H','I'}} , 
										   {{'J','K','L'} , {'M','N','O'} , {'P','Q','R'}} ,
										   {{'S','T','U'} , {'V','W','X'} , {'Y','Z',' '}} };
	
		       							 
	// Sifreleme metodu
	public static String encryption(String plainText)
	{
		if(plainText.length()%alphabetsMatrix.length!=0)
		{
			for(int i=0;i<plainText.length()%3;i++)
				plainText+="Q";
		}
		StringBuilder cipherText = new StringBuilder();
		Integer[][] cipherTextMatrix = new Integer[alphabetsMatrix.length][plainText.length()];
		for(int i=0;i<plainText.length();i++)
		{
			String indexs = turn(plainText.charAt(i));
			cipherTextMatrix[0][i] = Integer.parseInt(String.valueOf(indexs.charAt(0))); 
			cipherTextMatrix[1][i] = Integer.parseInt(String.valueOf(indexs.charAt(1))); 
			cipherTextMatrix[2][i] = Integer.parseInt(String.valueOf(indexs.charAt(2))); 
		}
		for(int i=0;i<cipherTextMatrix.length;i++)
		{
			for(int j=0;j<plainText.length();j++)
			{
				cipherText.append(alphabetsMatrix[cipherTextMatrix[i][j]][cipherTextMatrix[i][++j]][cipherTextMatrix[i][++j]]);
			}
		}
		return cipherText.toString();
	}
	
	// Sifre cozme metodu
	public static String decryption(String cipherText)
	{
		StringBuilder plainText = new StringBuilder();
		Integer[][] plainTextMatrix = new Integer[alphabetsMatrix.length][cipherText.length()];
		int column=0;
		for(int i=0;i<plainTextMatrix.length;i++)
		{
			for(int j=0;j<cipherText.length();j++)
			{
				String a = turn(cipherText.charAt(column++));
				plainTextMatrix[i][j] = Integer.parseInt(String.valueOf(a.charAt(0))); 
				plainTextMatrix[i][++j] = Integer.parseInt(String.valueOf(a.charAt(1))); 
				plainTextMatrix[i][++j] = Integer.parseInt(String.valueOf(a.charAt(2))); 
			}
		}
		
		for(int i=0;i<cipherText.length();i++)
		{
			plainText.append(alphabetsMatrix[plainTextMatrix[0][i]][plainTextMatrix[1][i]][plainTextMatrix[2][i]]);
		}
		
		return plainText.toString();
	}
	
	// Metod icerisine gelen harfin index karsiligini dondurur.
	public static String turn(char c)
	{
		for(int i=0;i<alphabetsMatrix.length;i++)
		{
			for(int j=0;j<alphabetsMatrix[0].length;j++)
			{
				for(int k=0;k<alphabetsMatrix[1].length;k++)
				{
					if(alphabetsMatrix[i][j][k]==c)
						return i+""+j+""+k;
				}			
			}
		}
		return "";
	}
	
	// Acik metni turkce karakterlerden arindiran metod.
	public static String turkce(String metin)
	{
		metin = metin.toUpperCase();
		ArrayList<Character> aranan = new ArrayList<Character>();
		aranan.addAll(Arrays.asList('ç','Ç','ð','Ð','ý','Ý','ö','Ö','þ','Þ','ü','Ü'));
		ArrayList<Character> yerine = new ArrayList<Character>();
		yerine.addAll(Arrays.asList('c','C','g','G','i','I','o','O','s','S','u','U'));
		StringBuilder str = new StringBuilder();
		for(int i=0;i<metin.length();i++)
		{
			if(aranan.indexOf(metin.charAt(i))!=-1)
				str.append(yerine.get(aranan.indexOf(metin.charAt(i))));
			else
				str.append(metin.charAt(i));
		}
		return str.toString().toUpperCase();
	}

	public static void main(String[] args) 
	{
		String plainText = "KLU YAZILIM MUHENDISLIGI";
		plainText= turkce(plainText);
		System.out.println("Metnin Acik Hali :"+plainText);
		
		String cipherText = encryption(plainText);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText);
		System.out.println("Metnin Cozulmus Hali :"+plainText);
	}
}
