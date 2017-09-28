/*
 * 数据源：键盘录入System.in
 * 数据目的：控制台System.out
 * 需求:
 * 想把键盘录入的数据存到文件中
 * 数据源；System.in
 * 目标文件：创建的文件FileOutputStream("目标文件名");
 * */
import java.io.*;

class TransStreamDemo
{
	public static void main(String[] args)throws IOException
	{
		//创建数据源，也就是键盘录入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt")));

		//创建目标文件
		//对应的是字节流文件写入流对象
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
		bufr.close();
	}
}
