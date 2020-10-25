package java1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server4 {
	

	

	
		public static final int port = 9668;

		public static void main(String[] args) throws IOException {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("server đã được khởi tạo");
			Socket socket = serverSocket.accept();
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(socket.getInputStream());
			while (true) {
				String mess = is.readUTF();
				if (".".equals(mess)) {
					System.out.println("Đã ngắt kết nối");
					break;
				}
				String send = "";
				String[] numberStrings = mess.trim().split("[\\s]+");
				int sum = 0;
				for (String s : numberStrings) {
					sum += Integer.parseInt(s);
				}
				send = sum + "";

				os.writeUTF(send);
			}
		}
	}

	


