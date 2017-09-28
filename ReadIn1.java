/*
 * 键盘录入
 * 将键盘录入的内容大写输出，当输入over的时候停止录入
 * */
import java.io.*;

class ReadIn1
{
	public static void main(String[] args)throws IOException
	{
		//System.in可以返回InputStream字节流读取流对象
		InputStream in = System.in;//等待键盘录入，如果没有录入就一直等着
	
		//将键盘输入的内容存到缓冲区中
		//判断是否是over
		//StringBuilder sb = new StringBuilder();

		/*
		while(true)
		{
			int ch = in.read();
			if(ch =='\n')
			{
				String s = sb.toString();
				if("over".equals(s))
					break;

				System.out.println(s.toUpperCase());
				
				sb.delete(0, sb.length());
			}
			else
				sb.append((char)ch);
		}
		*/

		//使用读取一行
		//能否使用readLine实现键盘录入的一行数据的读取呢？
		//但是readLine方法是BufferedReader方法
		//但是System.in返回的是InputStream类
		//一个是字符流，一个是字节流
		//能否将字节流转成字符流，然后再使用字符流的方法?o
		//InputStreamReader
		//可以操作字节流的字符流
		//可以将字节流转换成字符流
		InputStreamReader isr = new InputStreamReader(in);

		//想使用读取行的功能
		//就要使用装饰类
		//将想要进行功能增强的类对象传入
		//所以将isr传到字符流读取缓冲区对象的构造函数中
		BufferedReader bufr = new BufferedReader(isr);
		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			System.out.println(line.toUpperCase());
		}

		bufr.close();

	}
}
