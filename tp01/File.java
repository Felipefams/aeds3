import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class File {
	public static void main(String[] args) throws FileNotFoundException {
		try {
			RandomAccessFile raf = new RandomAccessFile("teste.db", "rw");
			long pos = raf.getFilePointer();
			System.out.println("Registro iniciado na posição: "+pos);
			int k = 10;
			byte x = Byte.parseByte(Integer.toString(k));
			raf.writeInt(k);
			raf.write(x);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
