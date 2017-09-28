/*
 * 使用指定码表存储
 * */
import java.io.*;

class TransStreamDemo4
{
	public static void main(String[] args)throws IOException
	{
		//读取键盘录入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy.txt"), "UTF-8"));

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}

		//想按照UTF-8读取
		InputStreamReader isr = new InputStreamReader(new FileInputStream("copy.txt"), "UTF-8");
		FileReader fr = new FileReader("copy.txt");

		int ch = 0;
		while((ch = fr.read()) != -1)
			System.out.print((char)ch);

		bufr.close();
		bufw.close();
	}
}
