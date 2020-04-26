import java.io.*;

public class Encryption {

	public static void main(String[] args) throws IOException {
	    if (args.length != 2) {
	    	System.err.println("The program needs two files to execute");
	    	System.exit(1);
	    }
		final String secretKey = setKey(args[0]);
	    
	    /*
	    FileWriter fw = new FileWriter(args[0].replace("txt", "pwde"));
	    PrintWriter pw = new PrintWriter(fw);
	    
	    pw.close();
	    fw.close();
	    */
	    
	    String originalString = "The code word is pineapple";
	    String encryptedString = AES.encrypt(originalString, secretKey);
	    String decryptedString = AES.decrypt(encryptedString, secretKey);
	    
	    System.out.println(originalString);
	    System.out.println(encryptedString);
	    System.out.println(decryptedString);
	}
	
	public static String setKey(String fileName) throws IOException {
		File keyFile = new File(fileName);
		FileReader fr = new FileReader(keyFile);
		BufferedReader br = new BufferedReader(fr);
		
		String key = br.readLine();
		
		br.close();
		fr.close();
		
		return key;
	}

}
