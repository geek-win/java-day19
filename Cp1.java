/*
 * 使用read方法将键盘录入读到屏幕
 * */
import java.io.*;

class Cp1
{
	public static void main(String[] args)throws IOException
	{
		//读取键盘录入
		//使用字节流
		InputStream in = System.in;
		OutputStream out = System.out;

//		StringBuilder sb = new StringBuilder();

		byte[] buf = new byte[1024];
		int ch = 0, pos = 0;

		while((ch = in.read()) != -1)
		{
			if(ch == '\n')
			{
				/*
				//现在是一行了，所以转成字节数组输出到屏幕
				out.write(sb.toString().getBytes());
				out.write('\n');

				sb.delete(0, sb.length());
				*/

				/*
				String s = sb.toString();
				if("over".equals(s))
					break;

				out.write(s.getBytes());
				out.write('\n');
				sb.delete(0, sb.length());
				*/
				String s = new String(buf, 0, pos);
				if("over".equals(s))
					break;

				out.write(buf, 0, pos);
				out.write('\n');
				pos = 0;
			}
			else
				buf[pos++] = (byte)ch;
			//	sb.append((char)ch);
		}

		
		in.close();
		out.close();

	}
}
