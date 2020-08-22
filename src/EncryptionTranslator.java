import java.io.*;
import java.util.ArrayList;

public class EncryptionTranslator {

	public static void main(String[] args) throws IOException {
	    if (args.length != 3) {
	    	System.err.println("The program needs three txt files to execute");
	    	System.out.println("The files are ordered: key.txt newKey.txt message.encrypt");
	    	System.exit(1);
	    }
	    final String secretKey = keyFromFile(args[0]);
	    final String newKey = keyFromFile(args[1]);
	    
	    // Opens the file to read the encrypted text
	    File secretFile = new File(args[2]);
	    FileReader fr = new FileReader(secretFile);
	    BufferedReader br = new BufferedReader(fr);

	    String line;
	    ArrayList<String> lines = new ArrayList<>();
	    while((line = br.readLine()) != null) {
	    	String decryptedString = AES.decrypt(line, secretKey);
	    	System.out.println(line);
	    	System.out.println(decryptedString + "\n");
			lines.add(decryptedString);
	    }

	    // Closes the file
	    br.close();
	    fr.close();

	    System.out.println("================================================ \n");

		// These two are for the file where the encrypted message will be sent
		FileWriter fw = new FileWriter(secretFile);
		PrintWriter pw = new PrintWriter(fw);

	    for(String plaintext : lines) {
			String encryptedString = AES.encrypt(plaintext, newKey);
	    	System.out.println(plaintext);
	    	System.out.println(encryptedString + "\n");
			pw.printf("%s\n", encryptedString);
	    }

		pw.close();
		fw.close();

		System.out.println("================================================ \n");

	    System.out.println("Text has been encrypted with the new key!");

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
