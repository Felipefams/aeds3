import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class File {
	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String> emails = new ArrayList<String>();
		emails.add("teste@gmail.com");
		User u = new User(1, "Joao", emails, "teste", "teste", "teste", "teste", 1, 1F);
		try {
			RandomAccessFile raf = new RandomAccessFile("teste.db", "rw");
			raf.write(u.toByteArray());
			// raf.writeBytes("teste");
			long pos = raf.getFilePointer();
			System.out.println("Registro iniciado na posição: "+pos);
			while(raf.getFilePointer() < raf.length()) {

			}
			raf.close();
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
