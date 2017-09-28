/*
 * 键盘录入
 * 当录入over的时候停止录入
 * */
import java.io.*;

class Key
{
	public static void main(String[] args)throws IOException
	{
		//创建字节流读取流对象，对应键盘录入
		InputStream in = System.in;

		/*
		//读取键盘录入并输出
		while(true)
		{
			int ch = in.read();
			
			System.out.println((char)ch);
		}
		*/
		/*
		//想把键盘录入的内容存到StringBuilder中
		//遇到换行符就输出一次
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

		//想利用BufferedReader的readLine方法每次读取一行
		//之前都是读取写好的文件
		//现在是从键盘录入读取数据
		//所以原理是一样的
		InputStreamReader isr = new InputStreamReader(in);//字节流转成字符流
		BufferedReader bufr = new BufferedReader(isr);//装饰类，装饰字符流

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
