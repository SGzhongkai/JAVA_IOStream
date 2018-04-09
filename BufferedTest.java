import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedTest {

	public void testBufferedReader()throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c;
		String s;
		System.out.println("br.read()"+"    ");
		do {
			c = (char) br.read();
			System.out.println(c);
		}while (c!='q');
		
		System.out.println("br.readline()"+ "      ");
		do {
			s = br.readLine();
			System.out.println(s);
		}while (!s.equals("quit"));
		
		System.out.println("OVER!");
	}
	
	public void testBufferedReaderFile() throws IOException,FileNotFoundException{
		String line;
		try(
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("0.txt")))){
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			}catch(FileNotFoundException e) {
				System.err.println("File Not Found!");
			}catch(IOException e) {
				e.printStackTrace();
		}
	}
	
	public static void main(String [] args) throws IOException, FileNotFoundException{
		BufferedTest bt = new BufferedTest();
		bt.testBufferedReader();
		bt.testBufferedReaderFile();
	}
}
