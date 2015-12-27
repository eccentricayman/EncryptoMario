//Java class that encrypts a single file, with utilities.
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import javax.crypto.*;

public class FileEncrypter {

	//the file to encrypt
	private File toEncrypt;
	//the encryption key
	private String key;
	//the lines in the file, to be encrypted later
	private ArrayList<String> lines;
	//used to tell if a line is encrypted or not
	private ArrayList<Boolean> isencrypted;

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
		//basic bufferedreader exceptions
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		//closes file
		return total;
	}

	public FileEncrypter(File _toEncrypt) {
		//fileencrypter object has file
		toEncrypt = _toEncrypt;
		//random key with length
		key = randomString((int)(Math.random() * 15 + 5));
		try {
			BufferedReader file = new BufferedReader(new FileReader(toEncrypt));
			for (int i = 0 ; i < totallinum(toEncrypt) ; i++) {
				//add each line to the lines arraylist
				lines.add(file.readLine());
			}
		}
		//basic bufferdreader exceptions
		catch (FileNotFoundException e) {
			System.out.println(e);
		}
		catch (IOException e) {
			System.out.println(e);
		}
		for (int fill = 0 ; fill < lines.size() ; fill++) {
			isencrypted.add(false);
		}
	}

	public void encrypt() {
		for (int i = 0 ; i < lines.size() ; i++) {

		}
	}	

	public void deencrypt() {
		//also todo
	}

}