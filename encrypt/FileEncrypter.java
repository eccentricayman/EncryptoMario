//Java class that encrypts a single file, with utilities.

/* THIS IS HEAVILY COMMENTED SO YOU CAN UNDERSTAND AND HOPEFULLY DEBUG KEVIN */

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.crypto.*;

public class FileEncrypter {

	//the file to encrypt
	private File toEncrypt;
	//the encryption key
	private SecretKey key;
	//the lines in the file, to be encrypted later
	private ArrayList<String> lines;
	//used to tell if a line is encrypted or not
	private ArrayList<Boolean> isencrypted;
	//new arraylist for encrypted/not encrypted data, since everything is now in bytes
	private ArrayList<byte[]> newlines;

	//used to make a random file containing encryption method
	static final String abc = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random r = new Random();

	//used for creating a random key per file
	public static String randomString(int len) {
		// stringbuilder is used so we can append at a certain point
		StringBuilder rs = new StringBuilder(len);
		for(int i = 0; i < len; i++) {
			//appends whatever is at the index of a random number in abc's length
	    	rs.append(abc.charAt(r.nextInt(abc.length())));
		}
		return rs.toString();
	}

	public static int totallinum(File toread) {
		//total number of lines
		int total = 0;
		try {
			//open file under bufferedreader so we can parse through it
			BufferedReader file = new BufferedReader(new FileReader(toread));
			//reads lines in file until there are no more
			while (file.readLine() != null) {
				total += 1;
			}
			file.close();
		}
		//basic bufferedreader exceptions, used stacktrace 
		//instead of regular printing for easier debugging
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		//closes file
		return total;
	}

	public FileEncrypter(File _toEncrypt) throws Exception {
		//fileencrypter object has file
		toEncrypt = _toEncrypt;
		//random AES key, per file
		KeyGenerator keymaker = KeyGenerator.getInstance("AES");
		//simple txt files, so 128 instead of 256
		keymaker.init(128);
		//stores key for file per object
		key = keymaker.generateKey();
		try {
			BufferedReader file = new BufferedReader(new FileReader(toEncrypt));
			for (int i = 0 ; i < totallinum(toEncrypt) ; i++) {
				//add each line to the lines arraylist
				lines.add(file.readLine());
			}
		}
		//basic bufferdreader exceptions
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* The idea behind this is that it has a 50% chance to encrypt each 
	line, so even if the user got the key it would definetely be a hassle 
	because they don't know which lines to decrypt. */
	public void encrypt() throws Exception {
		//cipher is initiated here instead of in constructor
		Cipher AesCipher = Cipher.getInstance("AES");
		byte[] regularbytetext;
		byte[] encryptedbytetext;
		for (int i = 0 ; i < lines.size() ; i++) {
			//regular text in bytes
			regularbytetext = lines.get(i).getBytes();
			//key only changes with a new file, because new object
			AesCipher.init(Cipher.ENCRYPT_MODE, key);
			//encrypt time!
			encryptedbytetext = AesCipher.doFinal(regularbytetext);
			//for 1/2 chance of encrypting the line
			double random = Math.random();
			if (random > 0.5) {
				newlines.add(encryptedbytetext);
				isencrypted.add(true);
			}
			else {
				//add regular byte text if random is less than 0.5
				newlines.add(regularbytetext);
				isencrypted.add(false);
			}
		}
		//new filewriter that overwrites instead of appends on this object's file
		FileOutputStream overwrite = new FileOutputStream(toEncrypt, false);
		//using bufferedoutputstream so we can have newlines without using "\n" so 
		//the encryption doesn't get messed up, and so we can append byte arrays to
		//txt files
		BufferedOutputStream out = new BufferedOutputStream(overwrite);
		//printwriter only so we can append newlines(NOT SURE IF THIS WORKS)
		PrintWriter printout = new PrintWriter(out);
		for (int linum = 0 ; linum < newlines.size() ; linum++) {
			out.write(newlines.get(linum));
			printout.print(System.getProperty("line.separator"));
		}
		//closing output
		out.close();
		printout.close();
		//clears newlines after everything successfully in file
		newlines = new ArrayList<byte[]>();
	}	

	public void decrypt() throws Exception {
		//used later on in while loop for decrypting
		Cipher AesCipher = Cipher.getInstance("AES");
		//consistency, and so we can read bytes
		FileInputStream bytesin = new FileInputStream(toEncrypt);
		BufferedInputStream in = new BufferedInputStream(bytesin);
		//used to check isencrypted arraylist
		int index = 0;
		//used for temp storing of decrypted bytes
		byte[] temp = new byte[(int)(toEncrypt.length())];
		//going to write to file later
		ArrayList<String> outstore = new ArrayList<String>();
		//available checks if there's more data to read
		while (in.available() != 0) {
			//decrypting only if we encrypted in first place
			if (isencrypted.get(index) == true) {
				AesCipher.init(Cipher.DECRYPT_MODE, key);
				in.read(temp); 
				temp = AesCipher.doFinal(temp);
			}
			else {
				in.read(temp);
			}
			//converting bytes back to string
			 outstore.add(new String(temp));
		}
		//closing input
		in.close();
		//writing to file
		BufferedWriter out = new BufferedWriter(new FileWriter(toEncrypt, false));
		for (int line = 0 ; line < outstore.size() ; line++) {
			out.write(outstore.get(line));
			out.newLine();
		}
		//clearing isencrypted
		isencrypted = new ArrayList<Boolean>();
		out.close();
	}

	/*PURELY FOR TESTING THE STUFFZ
	public static void main(String[] args) {

	}
	*/
}

