import java.io.*;

public class Decryption {

	public static void main(String[] args) throws IOException {
	    if (args.length != 2) {
	    	System.err.println("The program needs two files to execute");
	    	System.out.println("The files are ordered: key.txt message.encrypt");
	    	System.exit(1);
	    }
	    final String secretKey = keyFromFile(args[0]);
	    
	    // Opens the file to read the encrypted text
	    File secretFile = new File(args[1]);
	    FileReader fr = new FileReader(secretFile);
	    BufferedReader br = new BufferedReader(fr);
	    
	    String line;
	    while((line = br.readLine()) != null) {
			String decryptedString = AES.decrypt(line, secretKey);
			System.out.println(decryptedString);
	    }
	    
	    // Closes the file
	    br.close();
	    fr.close();

	}

	/**
	 * This will get the key from the key file and return it back for utilization elsewhere
	 * @param fileName the one line file that contains the key to be utilized for encryption
	 * @return the key in String format
	 * @throws IOException in case of file not existing errors, cannot open, etc.
	 */
	public static String keyFromFile(String fileName) throws IOException {
		File keyFile = new File(fileName);
		FileReader fr = new FileReader(keyFile);
		BufferedReader br = new BufferedReader(fr);
		
		String key = br.readLine();
		
		br.close();
		fr.close();
		
		return key;
	}
	
}
