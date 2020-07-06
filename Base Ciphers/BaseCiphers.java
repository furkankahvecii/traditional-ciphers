import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class BaseCiphers {

	// base 16 to String
	public static String unHex(String arg) 
	{        
	    String[] array = arg.split(" ");
	    StringBuilder str = new StringBuilder("");
	    
	    for(String each : array) {
	        int decimal = Integer.parseInt(each, 16);
	        str.append((char) decimal);
	    }
	    
	    return str.toString();
	}
	
	// Ascii to String
	public static String unDecimal(String arg)
	{
		String[] array = arg.split(" ");
	    StringBuilder str = new StringBuilder("");
	    for(String each : array) 
	    {
	    	int a = Integer.valueOf(each);
	    	str.append((char) a);
	    }
	    
	    return str.toString();
	}
	
	// Base 8 to String
	public static String unOctal(String arg)
	{
		String[] array = arg.split(" ");
	    StringBuilder str = new StringBuilder("");
	    
	    for(String each : array) {
	    	int decimal = Integer.parseInt(each, 8);
	        str.append((char) decimal);

	    }
	    
	    return str.toString();
	}
	
	// Base 36 to String
	 public static String fromBase36(String arg)
	 {
		 String[] array = arg.split(" ");
		 StringBuilder str = new StringBuilder("");
		    
		 for(String each : array) {
			 int decimal = Integer.parseInt(each, 36);
			 str.append((char) decimal);
		 }
		    
		 return str.toString();
	 }
	 
	// Base 64 to String
	 public static String fromBase64(String arg) throws UnsupportedEncodingException 
	 {
		 byte[] base64decodedBytes = Base64.getDecoder().decode(arg);
		 return new String(base64decodedBytes,"utf-8");
	 }
	
	// Sample Base ciphers are taken from Kevin Mitnick's Ghost in the Wires book.
	public static void main(String[] args) throws UnsupportedEncodingException 
	{
		System.out.println(unHex("4A 75 6E 67 20 6A 6E 66 20 62 68 65 20 61 76 70 78 61 6E 7A 72 20 74 76 69 72 61 20 67 62 20 47 72 65 65 6C 20 55 6E 65 71 6C 3F"));
		System.out.println(unDecimal("85 102 121 114 32 103 113 32 114 102 99 32 108 121 107 99 32 109 100 32 114 102 99 32 122 109 105 113 114 109 112 99 32 71 32 100 112 99 111 115 99 108 114 99 98 32 103 108 32 66 99 108 116 99 112 63"));
		System.out.println(unOctal("126 147 172 163 040 166 172 162 040 154 170 040 157 172 162 162 166 156 161 143 040 145 156 161 040 163 147 144 040 115 156 165 144 153 153 040 163 144 161 154 150 155 172 153 040 162 144 161 165 144 161 040 150 155 040 122 172 155 040 111 156 162 144 077"));
		System.out.println(fromBase36("2B 2T W 2X 2Z 26 36 2P 36 2V 3C W 3A 32 39 38 2Z W 3D 33 31 38 2V 36 3D W 2R 2Z W 3E 3C 2V 2X 2Z 2Y W 3E 39 W 2R 32 2V 2E W 2V 3A 2V 3C 3E 37 2X 38 3E W 2X 39 37 3A 36 2Z 2S 1R"));
		System.out.println(fromBase64("V2hhdCBGQkkgYWdlbnQgYXNrZWQgU3VuIE1pY3Jvc3lzdGVtcyB0byBjbGFpbSB0aGV51Gxvc3QgODAgbWlsbGlvbiBkb2xsYXJzPw=="));
	}
}