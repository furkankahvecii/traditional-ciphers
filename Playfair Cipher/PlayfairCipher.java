
public class PlayfairCipher {
	
	static char playfairTable[][] = new char[5][5];
	static char[] alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ".toCharArray(); 
	
	/* Sifrelenecek metin 2’lik bloklara (katar) bölünür. Her blok için bir şifreli metin karşılığı 5×5 boyutlarındaki matristen şu şekilde bulunur:
	   ● Şayet aynı kolonda iki harf tesadüf ediyorsa, hemen altlarındaki harfleri al
	   ● Şayet aynı satırda iki harf tesadüf ediyorsa, hemen sağlarındaki harfi al
	   ● Şayet bu iki harf ne aynı kolon ne de aynı satırda değilse bir dikdörtgen gibi düşünüp ters köşelerini al
	 */
	static String encryption(String plainText,String key) 
	{
		fill(key);
		if(plainText.length() % 2 !=0)
			plainText+="X";
		
		StringBuilder cipherText = new StringBuilder();
		for(int i=0;i<plainText.length();i+=2)
		{
			int[] dizi =getIndex(plainText.charAt(i));
			int row1 =dizi[0];
			int column1 =dizi[1];
			int[] dizi2=getIndex(plainText.charAt(i+1));
			int row2 = dizi2[0];
			int column2 = dizi2[1];
			
			if(row1 == row2)
			{
				if(column1 == 4) column1 =-1;
				if(column2 == 4) column2 =-1;
				
				cipherText.append(playfairTable[row1][++column1]);
				cipherText.append(playfairTable[row2][++column2]);
			}
			else if (column1 == column2)
			{
				if(row1 == 4) row1 =-1;
				if(row2 == 4) row2 =-1;
				
				cipherText.append(playfairTable[++row1][column1]);
				cipherText.append(playfairTable[++row2][column2]);
			}
			else
			{
				cipherText.append(playfairTable[row1][column2]);
				cipherText.append(playfairTable[row2][column1]);
			}
				
		}
		return cipherText.toString();
	}
	
	/* Şifreleme işleminde gerçekleştirilen yöntemlerin tersi izlenir.
	 * ● Şayet aynı kolonda iki harf tesadüf ediyorsa, hemen üstlerindeki harfleri al
	 * ● Şayet aynı satırda iki harf tesadüf ediyorsa, hemen sollarındaki harfi al
	 * ● Şayet bu iki harf ne aynı kolon ne de aynı satırda değilse bir dikdörtgen gibi düşünüp ters köşelerini al
	 */
	public static String decryption(String cipherText,String key) 
	{
		fill(key);
		StringBuilder plainText = new StringBuilder();
		for(int i=0;i<cipherText.length();i+=2)
		{
			int[] dizi =getIndex(cipherText.charAt(i));
			int row1 =dizi[0];
			int column1 =dizi[1];
			int[] dizi2=getIndex(cipherText.charAt(i+1));
			int row2 = dizi2[0];
			int column2 = dizi2[1];
			
			if(row1 == row2)
			{
				if(column1 == 0) column1 =5;
				if(column2 == 0) column2 =5;
				
				plainText.append(playfairTable[row1][--column1]);
				plainText.append(playfairTable[row2][--column2]);
			}
			else if (column1 == column2)
			{
				if(row1 == 0) row1 =5;
				if(row2 == 0) row2 =5;
				
				plainText.append(playfairTable[--row1][column1]);
				plainText.append(playfairTable[--row2][column2]);
			}
			else
			{
				plainText.append(playfairTable[row1][column2]);
				plainText.append(playfairTable[row2][column1]);
			}
				
		}
		return plainText.toString();
	}
	
	/* Playfair Şifrelemesi için seçilen anahtarın 5x5 matrisine entegre edilmesi. 
	 * Bu matris bizim şifreleme ve şifreyi açmak için kullanacağımız matrisimiz.
	 */
	static void fill(String key)
	{
		int i=0,j=0;
		for(char q:key.toCharArray())
		{
			if(j==5)
			{
				i++;
				j=0;
			}
			if(getIndex(q) == null)
				playfairTable[i][j++]=q;
		}
		
		for(char q: alphabet)
		{
			if(j==5)
			{
				i++;
				j=0;
			}
			if(getIndex(q) == null)
				playfairTable[i][j++]=q;
		}
	
	}
	
	/* Bu metot içerisine aldığı harf değerinin matrisdeki satir ve sütün karşılığını döndürür.  */	
	
	static int[] getIndex(char q)
	{
		for(int i=0;i<playfairTable.length;i++)
		{
			for(int j=0;j<playfairTable[0].length;j++)
			{
				if(q==playfairTable[i][j])
					return new int[] {i,j};
			}
		}
		return null;
	}
	
	public static void main(String[] args) 
	{
		String plainText = "KIRKLARELIUNIVERSITESIYAZILIMMUHENDISLIGI";
		String key = "PASSWORD";
		System.out.println("Anahtar :"+key);
		System.out.println("Metnin Acik Hali :"+plainText);
		
		String cipherText = encryption(plainText,key);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText,key);
		System.out.println("Metnin Cozulmus Hali :"+plainText);	
		
		System.out.println("Anahtarın matrise entegresi : ");
		for(int z=0;z<5;z++)
		{
			for(int x=0;x<5;x++)
			{
				System.out.print(playfairTable[z][x]+" ");
			}
			System.out.println();	
		}
	}

}
