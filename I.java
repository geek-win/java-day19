/*
 * 练习通过IO流进行键盘录入和屏幕输出
 * 键盘录入对应输入流
 * InputStream in = System.in;
 * InputStreamReader isr = new InputStreamReader(in);
 * BufferedReader bufr = new BufferedReader(isr);
 * 屏幕输出对应输出流
 * OutputStream out = System.out;
 * OutputStreamWriter osw = new OutputStreamWriter(out);
 * BufferedWriter bufw = new BufferedWriter(osw);
 * */
import java.io.*;

class I
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		String line = null;

		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();
		bufw.close();
	}
}
