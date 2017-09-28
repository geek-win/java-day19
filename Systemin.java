/*
 * 键盘录入
 * public static final InputStream System.in
 * System.in返回的是InputStream对象，即字节流读取流对象
 * */
import java.io.*;

class Systemin
{
	public static void main(String[] args)throws IOException
	{
		//通过System.in获取字节流读取流对象
		//in关联的是键盘录入
		InputStream in = System.in;

		/*
		 * 键盘录入，然后将录入的内容输出
		while(true)
		{
			int ch = in.read();
			System.out.println((char)ch);
		}
		*/

		/*
		//通过缓冲区存储输入的内容，然后整体输出
		StringBuilder sb = new StringBuilder();
		while(true)
		{
			int ch = in.read();
			if(ch == '\n')
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
		//将字节流转成字符流
		//然后通过装饰类对字符流读取流对象进行装饰
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader bufr = new BufferedReader(isr);

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			System.out.println(line);
		}
		bufr.close();
	}
}
