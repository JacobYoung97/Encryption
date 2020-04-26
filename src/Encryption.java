import java.io.*;

public class Encryption {

	public static void main(String[] args) throws IOException {
	    if (args.length != 2) {
	    	System.err.println("The program needs two txt files to execute");
	    	System.out.println("The files are ordered: key.txt message.txt");
	    	System.exit(1);
	    }
		final String secretKey = setKey(args[0]);
	    
		File secretFile = new File(args[1]);
		FileReader fr = new FileReader(secretFile);
		BufferedReader br = new BufferedReader(fr);
		
		FileWriter fw = new FileWriter(args[1].replace("txt", "encrypt"));
		PrintWriter pw = new PrintWriter(fw);
		
		String line;
		while((line = br.readLine()) != null) {
			String encryptedString = AES.encrypt(line, secretKey);
			System.out.println(line);
			System.out.println(encryptedString);
			pw.printf("%s\n", encryptedString);
			//String decryptedString = AES.decrypt(encryptedString, secretKey);
			//System.out.println(decryptedString);
		}
		
		closeFiles(br, fr, pw, fw);
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
	
	public static void closeFiles(BufferedReader br, FileReader fr, PrintWriter pw, FileWriter fw) throws IOException {
		br.close();
		fr.close();
		pw.close();
		fw.close();
	}

}
