/*
 * 通过键盘录入数据，当录入一行的时候就输出
 * 直到over
 * */
import java.io.*;

class ReadDemo
{
	public static void main(String[] args)throws IOException
	{
		//获取键盘录入对象
		InputStream in = System.in;

		//将字节流对象转成字符流对象，使用转换流.InputStreamReader
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
		/*
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
		/*
		int ch = 0;
		while((ch = in.read()) != -1)
			System.out.println((char)ch);
			*/

		
	}
}
