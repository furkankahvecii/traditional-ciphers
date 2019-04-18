import java.util.*;
public class AffineCipher {
	
	static List<Character> alphabet = new ArrayList<Character>();

	static void fiilAlphabet()
	{
		for(char i ='a';i<='z';i++)
		{
			alphabet.add(i);
		}
	}

	/* Sifreleme islemi icin oncelikle sifrelenecek mesajin karakter index degerleri cikartilir ve bu degerler basit bir fonksiyona sokulur (a*x + b). 
	 * Fonksiyondan cikan degerlerin alfabedeki harf sayisindan buyuk olmamasi icin mod islemine tabi tutulur. 
	 * Cikan index degerlerin alfabedeki karakter karsiliklari sifreli mesaji olusturur.
	 */
	static String encryption(String plainText,int a,int b)
	{
		StringBuilder cipherText = new StringBuilder();
		plainText = plainText.toLowerCase();
		for(char character:plainText.toCharArray())
		{
			try 
			{
				int x = alphabet.indexOf(character);	
				char s = alphabet.get((((a*x)+b) % alphabet.size()));
				cipherText.append(s);
			}
			catch(Exception e)
			{
				cipherText.append(character);
			}
		}
		return cipherText.toString();
	}
	
	/* Sifre cozme islemi icin oncelikle sifreli mesajin karakter index degerleri cikartilir ve bu degerleri basit bir fonksiyona sokulur (ax* (x-b)).
	 * Buradaki ax degeri sifreleme isleminde kullanilan a degerinin mod islemine gore tersidir. 
	 * Fonksiyondan cikan degerler 0'dan kucukse, uzerine sifreleme metodunda mod isleminde kullanilan sayi degeri bir diger ifade ile alfabedeki harf sayisi eklenir. 
	 * Cikan index degerlerinin alfabedeki karakter karsiliklari acik mesaji olusturur.
	 */
	static String decryption(String cipherText,int a,int b)
	{
		StringBuilder plainText = new StringBuilder();
		
		int reverseA=0;
		for(int i =0;i<alphabet.size();i++)
		{
			if((a*i)%26 == 1)
			{
				reverseA = i;
				break;
			}		
		}
		
		for(char character : cipherText.toCharArray())
		{
			if(alphabet.indexOf(character)==-1)
			{
				plainText.append(character);
				continue;
			}
			int index = (reverseA * (alphabet.indexOf(character) - b) % alphabet.size());
			if(index<0)
				index+=alphabet.size();
			
			plainText.append(alphabet.get(Math.abs(index)));
		}
		
		return plainText.toString();
	}

	public static void main(String[] args) 
	{
		fiilAlphabet();
		
		String plainText = "KIRKLARELI UNIVERSITESI YAZILIM MUHENDISLIGI";
		System.out.println("Metnin Acik Hali :"+plainText);
		
		String cipherText = encryption(plainText,7,2);
		System.out.println("Metnin Sifrelenmis Hali :"+cipherText);
		
		plainText = decryption(cipherText,7,2);
		System.out.println("Metnin Cozulmus Hali :"+plainText);
	}
}