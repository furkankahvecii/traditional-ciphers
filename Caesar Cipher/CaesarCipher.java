
public class CaesarCipher {
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();  // Sifreleme isleminde kullanilan alfabe
	
	public static String encryption(String plainText,int shift) 
	{
		assert(shift>= -(alphabet.length) && shift<=alphabet.length); // Kaydirma alfabe uzunlugu ve negatifi kadar olmalidir.
		plainText = plainText.trim();
		plainText=plainText.toLowerCase();
		if(shift<0) shift=alphabet.length+shift; // Kaydirma negatif girilirse , ornegin -5 ; Bu 26(alfabe toplami) + (-5) = 21 kere shift gerekir.
		StringBuilder cipherText=new StringBuilder();
		int j=0;
		for(char q:plainText.toCharArray())
		{
			if(!Character.isLetter(q)) // Metnin karakterlerinden biri harf degil ise o karakteri sifreli metine aktar.
			{
				cipherText.append(q);
				continue;
			}
			while(j<shift) 
			{
				if(q=='z') //Alfabenin sonuna gelindiyse tekrar basina don.
				{
					q='a';
					q--;
				}
				q++;
				j++;
			}
			cipherText.append(q);
			j=0;
		}
		return cipherText.toString();
	}
	
	public static StringBuilder[] decryption(String cipherText)
	{
		cipherText = cipherText.trim();
		StringBuilder[] sb=new StringBuilder[alphabet.length]; // Tum ihtimaller icin bir dizi olusturdum.

		for (int i = 0; i < sb.length; i++) {
		    sb[i] = new StringBuilder("");
		}
		
		int j=0;
		for(int i =0;i<alphabet.length;i++)
		{
			for(char q: cipherText.toCharArray())
			{
				if(!Character.isLetter(q)) 
				{
					sb[i].append(q);
					continue;
				}
				while(j<i)
				{
					if(q=='a')
					{
						q='z';
						q++;
					}
					q--;
					j++;
				}
				sb[i].append(q);
				j=0;
			}
		}
		return sb;
	}
	
	public static void main(String[] args) 
	{
		String plainText = "kirklareli universitesi yazilim muhendisligi";
		System.out.println("Metnin Acik Hali :"+plainText);
		
		String cipherText = encryption(plainText,26);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		StringBuilder[] possibilityPlainTexts = decryption(cipherText);
		System.out.println("Desifre Edilmis Metin Ihtimalleri");
		System.out.println("---------------------------------");
		
		for(StringBuilder text : possibilityPlainTexts)
		{
			if(plainText.equals(text.toString())) System.out.println(text +"  <<<<<<<<<<<<<<<<<<<<<");
			else
				System.out.println(text);
		}
	}
}
