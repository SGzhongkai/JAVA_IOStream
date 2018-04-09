import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * 
 * @author XiaoguniangAnn
 * @version 2018.04.08
 *
 */

public class IOtest {
	
	static byte[] tes = new byte[20];
	public IOtest() {
		for(int i=0;i<20;i++) {
			tes[i]=(byte) ('a'+i);
		}
	}

	//����д�ļ�FileWriter����
	public void testFileWriter() throws IOException {
		try(FileWriter fw=new FileWriter("fileWriter_0.txt")){
			fw.write(56);
			fw.write('b');
			fw.write("Hello World!\r");
			fw.write("My name is\n");
			fw.write("shangguan\r\n");
			fw.write("insertTest",6,4);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	//����д�ļ�FileOutputStream����	
	public void testOutputStream() throws IOException{
		try(FileOutputStream fos=new FileOutputStream("fileOutput_0.txt")){
			fos.write(65);
			fos.write('a');
			fos.write(tes);
			fos.write("\r\nabc".getBytes()); //getBytes()���ַ�תΪbyte�ֽ��ͣ����������д�뻻�з���
			fos.write(tes,2,18);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//���Զ��ļ�FileReader����
	public void testFileReader() throws IOException,FileNotFoundException{
		//List<String> read = new ArrayList<>();
		char [] tmp = new char[30];
		int hasread =0;
		try(FileReader fr = new FileReader("fileOutput_0.txt")){
			while((hasread = fr.read(tmp))>0) {
				System.out.print(new String(tmp,0,hasread)+"hasread = "+hasread);
				//for(char t :tmp) {System.out.println(t);}
			}
		}catch(FileNotFoundException e) {     //ע��FileNotFoundException д��IOExceptionǰ
			System.err.println("File not found!" );
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	//���Զ��ļ�FileInputStream����
	public void testFileInputStream() throws IOException{
		byte [] fin = new byte [20];
		int hasread =0;
		
		try(FileInputStream fis = new FileInputStream("fileOutput_0.txt")){
			while((hasread = fis.read(fin)) >0) {
				System.out.print(new String(fin)+"\nhasread = "+hasread+'\n');
				}
			}catch (FileNotFoundException e) {
				System.err.println("File not found!" );
			}catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	
	//���Է������
	public static void main(String [] args) throws IOException {
		IOtest test = new IOtest();
		test.testFileWriter();
		test.testOutputStream();
		test.testFileReader();
		test.testFileInputStream();
	}
		
		
}

