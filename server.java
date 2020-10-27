package server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
	public static final int port =6967;
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(port);
		Socket socket = serverSocket.accept();
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		DataInputStream is =new DataInputStream(socket.getInputStream());
		while(true) {
			String mess =is.readUTF();
			String send="";
			switch (mess) {
			case "0":
				send ="Không";
				break;
			case "1":
				send ="Một";
				break;
			case "2":
				send ="Hai";
				break;
			case "3":
				send ="Ba";
				break;
			case "4":
				send ="Bốn";
				break;
			case "5":
				send ="Năm";
				break;
			case "6":
				send ="Sáu";
				break;
			case "7":
				send ="Bảy";
				break;
			case "8":
				send ="Tám";
				break;
			case "9":
				send ="Chín";
				break;

			default:
				send ="Không phải số nguyên";
				break;
			}
			os.writeUTF(send);
		}
	}
	}


