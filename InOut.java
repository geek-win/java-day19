/*
 * 通过IO流实现键盘录入和屏幕输出
 * 其实这里就是把键盘录入当做数据源，也就是输入流
 * 屏幕输出就是输出流，也就是目的
 * 键盘录入
 * InputStream in = System.in;
 * InputStreamReader isr = new InputStreamReader(in);
 * BufferedReader bufr = new BufferedReader(isr);
 * bufr对应的就是键盘录入
 * 屏幕输出
 * OutStream out = System.out;
 * OutputStreamWriter osw = new OutputStreamWriter(out);
 * BufferedWriter bufw = new BufferedWriter(osw);
 * bufw对应的是屏幕输出
 * 并且是字符流对象，write方法可以操作字符串，只能将内容写到缓冲区中，所以需要flush才能将内容写到目标文件也就是屏幕上
 * */
import java.io.*;

class InOut
{
	public static void main(String[] args)throws IOException
	{
		//键盘录入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		//屏幕输出
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}

		bufr.close();
		bufw.close();
	}
}
