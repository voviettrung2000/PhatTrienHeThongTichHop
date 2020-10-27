package bai4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class client4 {




		public static final int port = 9126;
		public static final String serverIp = "localhost";

		public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
			Socket socket = new Socket(serverIp, port);

			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);

			System.out.println("Nhập chuỗi nhấn 1,  đọc file nhấn 2. Enter");
			int number = Integer.parseInt(sc.nextLine());
			if (number == 1) {
				while (true) {
					System.out.print("nhập vào chuỗi : ");
					String send = sc.nextLine();
					os.writeUTF(send);
					if (".".equals(send)) {
						System.out.println("Đã ngắt kết nối");
						break;
					}
					
					
				}
				String mess = is.readUTF();
				System.out.println("Tổng số chuỗi vừa nhận là: " + mess);
				
			} else {
				System.out.println("đọc file data.txt");
				List<String> strings = readFile("C:\\Users\\Student\\eclipse-workspace\\bai1\\src\\bai4\\data.txt");
				strings.forEach(System.out::println);
				while (true) {
					String check = "";
					for (String s : strings) {
						os.writeUTF(s);
						if (".".equals(s)) {
							check = s;
							break;
						}
						
						
					}

					if (".".equals(check)) {
						System.out.println("Đã ngắt kết nối");
						break;
					}

				}
				String mess = is.readUTF();
				System.out.println("Tổng số chuỗi vừa nhận là: " + mess);
				
			}

		}

		private static List<String> readFile(String filename) {
			List<String> list = new ArrayList<>();
			File file = new File(filename);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			FileInputStream fis = null;
			DataInputStream dis = null;
			try {
				fis = new FileInputStream(file);
				dis = new DataInputStream(fis);
				String string = dis.readLine();
				while (string != null) {
					list.add(string);
					string = dis.readLine();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					dis.close();
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			return list;
		}
	}