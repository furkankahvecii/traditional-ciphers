import java.util.ArrayList;
import java.util.Arrays;

public class VernamCipher {

	//Acik mesajin ve anahtar degerinin binary hallerini Xor islemine tabi tutulan metod.
	public static String encryption(String plainTextBinary, String keyBinary)
	{
		StringBuilder cipherTextBinary = new StringBuilder();
        
		for(int i=0;i<plainTextBinary.length();i++)
		{
			if(plainTextBinary.charAt(i) == keyBinary.charAt(i==0 ? 0 : i%keyBinary.length()))
			{
				if(plainTextBinary.charAt(i) == ' ')
					cipherTextBinary.append(' ');
				else
					cipherTextBinary.append('0');
			}
			else
				cipherTextBinary.append('1');
		}
		return cipherTextBinary.toString();
	}
	
	//Sifreli mesajin ve anahtar degerinin binary hallerini Xor islemine tabi tutulan metod.
	public static String decryption(String cipherTextBinary, String keyBinary)
	{
		StringBuilder plainTextBinary = new StringBuilder();
        
		for(int i=0;i<cipherTextBinary.length();i++)
		{
			if(cipherTextBinary.charAt(i) == keyBinary.charAt(i==0 ? 0 : i%keyBinary.length()))
			{
				if(cipherTextBinary.charAt(i) == ' ')
					plainTextBinary.append(' ');
				else
					plainTextBinary.append('0');
			}
			else
				plainTextBinary.append('1');
		}
		return plainTextBinary.toString();
	}
	
	//Icerisine aldigi text degerini binary(0-1 sayi dizisi) formatina cevirir.
	public static String stringToBinary(String string)
	{
		StringBuilder binary = new StringBuilder();
		for(int i=0;i<string.length();i++)
		{
			binary.append((Integer.toBinaryString(string.charAt(i)))+" ");
		}
		return binary.toString();
	}
	//Icerisine gelen binary diziyi karakter haline cevirir.
	public static String binaryToString(String binary)
	{
		StringBuilder string = new StringBuilder();
		String[] array = binary.split(" ");
		for(int i=0;i<array.length;i++)
		{
			string.append((char)Integer.parseInt(array[i],2));
		}
		return string.toString();
	}
	
	// Metni turkce karakterlerden arindiran metod.
	public static String turkce(String metin)
	{
		ArrayList<Character> aranan = new ArrayList<Character>();
		aranan.addAll(Arrays.asList('ç','Ç','ğ','Ğ','ı','İ','ö','Ö','ş','Ş','ü','Ü'));
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
		return str.toString();
	}
	
	public static void main(String[] args) 
	{
		//Acik mesaji ekrana yazdiriyoruz..
		String plainText = "softwareengineering";
		System.out.println("Şifrelenecek Metin : "+plainText);
		
		//Acik mesajin binary halini elde edip, ekrana yazdiriyoruz.
		String convertPlainText=stringToBinary(plainText);
		System.out.println("Şifrelenecek Metin (Binary) : " +convertPlainText);
		System.out.println();
		
		//Anahtar degerini ekrana yazdiriyoruz.
		String key = "klu";
		System.out.println("Şifreleme Anahtarı : "+key);
		
		//Anahtar degerinin binary halini elde edip, ekrana yazdiriyoruz.
		String convertKey=stringToBinary(key);
		System.out.println("Şifreleme Anahtarı (Binary) : " +convertKey);
		System.out.println();
		
		//Acik mesajin ve anahtar degerinin binary hallerini Xor islemine tabi tutuyoruz.
		String cipherTextBinary = encryption(convertPlainText,convertKey);
		System.out.println("Şifreli Metin (Binary) :"+cipherTextBinary);
		System.out.println();
		
		//Şifreli mesajin ve anahtar degerinin binary hallerini Xor islemine tabi tutuyoruz.
		String acik = decryption(cipherTextBinary,convertKey);
		System.out.println("Açık Metin (Binary) :"+acik);
		
		//Acik mesajin binary halini karakter haline ceviriyoruz.
		System.out.println("Açık Metin : " + binaryToString(acik));
	}
}