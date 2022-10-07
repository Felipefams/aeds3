import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;
import User;
public class Crud {
	public static void main(String[] args) {
		User i = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		i.setName(sc.nextLine());
		System.out.println("Enter the age");
		i.setAge(sc.nextInt());
		System.out.println("Enter the address");
		i.setAddress(sc.nextLine());
		System.out.println("Enter the phone number");
		i.setPhone(sc.nextLine());
		System.out.println("Enter the email");
		i.setEmail(sc.nextLine());
		System.out.println("Enter the password");
		i.setPassword(sc.nextLine());
	}	
	public void create(User i) {
		try {
			RandomAccessFile raf = new RandomAccessFile("user.txt", "rw");
			raf.seek(raf.length());
			raf.writeBytes(i.getName() + " " + i.getAge() + " " + i.getAddress() + " " + i.getPhone() + 
					" " + i.getEmail() + " " + i.getPassword() + " " + i.getRole() + " " + i.getBalance());
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}	
}
