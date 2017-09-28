/*
 * System.in:final InputStream
 * 键盘录入，到over停止录入
 * */
import java.io.*;

class ReadIn
{
	public static void main(String[] args)throws IOException
	{
		//System.in返回的是InputStream流对象
		InputStream in = System.in;
		//in接收的是键盘录入
		//如果没有键盘录入，会一直等待，read方法是阻塞式方法
/*
		int ch = 0;
		while((ch = in.read()) != -1)
			System.out.println((char)ch);
*/

		/*
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		*/

		StringBuilder sb = new StringBuilder();

		while(true)
		{
			//录入一个存一下，当敲回车的时候打印
			//需要有缓冲区
			int ch = in.read();
			if(ch == '\n')
			{
				String s = sb.toString();
				if("over".equals(s))
					break;

				System.out.println(s.toUpperCase());

				//清空缓冲区
				sb.delete(0, sb.length());
			}
			else
			{
				sb.append((char)ch);
			}
			
			
		}

		//关闭流资源
		in.close();
	}
}
