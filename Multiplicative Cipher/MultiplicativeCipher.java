
public class MultiplicativeCipher
{
     static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();


    public static String encryption(String plainText,int shift)
    {
        assert(shift>= -(alphabet.length) && shift<=alphabet.length);
		plainText = plainText.trim();
		plainText=plainText.toLowerCase();
		if(shift<0) shift=alphabet.length+shift; 
		StringBuilder cipherText=new StringBuilder();

        for(char q:plainText.toString().toCharArray())
		{
			if(!Character.isLetter(q))
			{
				cipherText.append(q);
				continue;
			}
            int index = ( getIndex(q) * shift ) % alphabet.length ;
            cipherText.append(alphabet[index]);
        }
        
        return cipherText.toString();
    }

    public static String decryption(String cipherText,int shift)
	{
		cipherText = cipherText.trim();
		StringBuilder plainText = new StringBuilder();
		
		int j=0;

		for(char q:cipherText.toString().toCharArray())
		{
			if(!Character.isLetter(q))
			{
				plainText.append(q);
				continue;
			}

            int index = getIndex(q);
            for(int i=0;i<alphabet.length;i++)
            {
                if( ((i * shift) - index) % alphabet.length == 0 )
                    plainText.append(alphabet[i]);
            }
        }
		
		return plainText.toString();
	}


    public static int getIndex(Character ch)
    {
        for(int i=0;i<alphabet.length;i++)
        {
            if(alphabet[i] == ch)
                return (i);
        }
        return 0;
    }
    
    
    public static void main(String args[])
    {
         int shift = 5;
		String plainText = "can you hear me?";
		System.out.println("Metnin Acik Hali : "+ plainText);
		
		String cipherText = encryption(plainText,shift);
		System.out.println("Metnin Sifrelenmis Hali : "+ cipherText);
		
		String decryptedText = decryption(cipherText,shift);
		System.out.println("Metnin Acik Hali : "+ decryptedText);
    }
}