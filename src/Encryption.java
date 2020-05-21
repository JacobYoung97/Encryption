import java.io.*;

public class Encryption {

	public static void main(String[] args) throws IOException {
	    if (args.length != 2) {
	    	System.err.println("The program needs two txt files to execute");
	    	System.out.println("The files are ordered: key.txt message.txt");
	    	System.exit(1);
	    }
		final String secretKey = keyFromFile(args[0]);
		String encryptedFile = args[1].replace("txt", "encrypt");

		// These three are for the file that contains the message to be encrypted
		File secretFile = new File(args[1]);
		FileReader fr = new FileReader(secretFile);
		BufferedReader br = new BufferedReader(fr);

		// These two are for the file where the encrypted message will be sent
		FileWriter fw = new FileWriter(encryptedFile);
		PrintWriter pw = new PrintWriter(fw);

		String line;
		while((line = br.readLine()) != null) {
			String encryptedString = AES.encrypt(line, secretKey);
			System.out.println(line);
			System.out.println(encryptedString + "\n");
			pw.printf("%s\n", encryptedString);
		}

		closeFiles(br, fr, pw, fw);
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

	/**
	 * This will close all the open files used by the program. A way to gather them all together.
	 * @param br the buffered reader from the file that contained the message to encrypt
	 * @param fr the file reader that actually read the file
	 * @param pw the print writer that prints to the actual file with encrypted text
	 * @param fw the file writer that creates the ability to write to the file
	 * @throws IOException in case of file errors this will throw an IOException
	 */
	public static void closeFiles(BufferedReader br, FileReader fr, PrintWriter pw, FileWriter fw) throws IOException {
		br.close();
		fr.close();
		pw.close();
		fw.close();
	}

}
