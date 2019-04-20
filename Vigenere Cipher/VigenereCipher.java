
public class VigenereCipher {
	
	static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	
	/* Sifrelenecek mesajin ve anahtar kelimenin index degerleri toplanir.
	 * Toplama islemi sirasinda elde edilen sonuclarin alfabe sayisindan buyuk olma ihtimaline karsi mod alma islemi uygulanir.
	*/
	public static String encryption(String plainText,String key)
	{
		StringBuilder cipherText = new StringBuilder();
		plainText=plainText.toLowerCase();
		int count=0;
		for(char q:plainText.toCharArray())
		{
			if(!Character.isLetter(q))
			{
				cipherText.append(q);
				continue;
			}	
			count=count==key.length() ? 0:count;
			
			int now = getIndex(q);
			int shift = getIndex(key.charAt(count));	
			int target = (now+shift) % alphabet.length;
			cipherText.append(alphabet[target]);
			
			count++;
		}
		
		return cipherText.toString();
	}
	
	
	/* Sifreli mesajin index degerinden anahtar kelimenin index degeri cikarilir.
	 * Cikarma islemi sirasinda elde edilen sonuclar arasinda 0'dan kucuk olan degerlerin uzerine mod alma isleminde kullanilan sayi degeri eklenir.
	*/
	public static String decryption(String cipherText,String key)
	{
		StringBuilder plainText = new StringBuilder();
		int count=0;
		for(char q:cipherText.toCharArray())
		{
			if(!Character.isLetter(q))
			{
				plainText.append(q);
				continue;
			}	
			count=count==key.length() ? 0:count;
			
			int now = getIndex(q);
			int shift = getIndex(key.charAt(count));	
			int target = (now-shift) % alphabet.length;	
			target = target<0 ? alphabet.length + target : target;

			plainText.append(alphabet[target]);
			count++;
		}
		
		return plainText.toString();
	}
	
	
	/*
	 * Alfabe dizisindeki aranan karakterin indexini donduren metod. 
	*/
	public static int getIndex(char q)
	{		
		for(int i=0;i<alphabet.length;i++)
		{
			if(alphabet[i]==q) return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		String plainText = "kirklareli universitesi yazilim muhendisligi";
		String key ="klu";
		System.out.println("Metnin Acik Hali :"+plainText);
		
		String cipherText = encryption(plainText,key);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText,key);
		System.out.println("Sifreli Metnin Cozulmus Hali :"+plainText);
	}
}