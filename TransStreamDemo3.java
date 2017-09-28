/*
 * 键盘录入存到文件中
 * 源：键盘录入。录入的都是文本内容，所以使用Reader，并且可以使用缓冲区
 * InputStream in = System.in;
 * InputStreamReader isr = new InputStreamReader(in);
 * BufferedReader bufr = new BufferedReader(isr);
 * 如果我们想读取键盘录入的几个字节，那么我们就不需要转成字符串了，直接用字节流处理
 * 目的：文件，Writer。BufferedWriter
 * */
import java.io.*;

class TransStreamDemo3
{
	public static void main(String[] args)throws IOException
	{
		/*
		//读取键盘录入
		InputStream in = System.in;

		for(int i = 0; i < 3; i++)
			System.out.println((char)in.read());
		*/

		//读取键盘录入，并且以指定码表进行存储到文件中
		//那么就需要使用写入转换流
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("out2.txt"), "GBK");
		BufferedWriter bufw = new BufferedWriter(osw);

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line);
		}
		bufr.close();
		bufw.close();
	}
}
