/*
 * 转换流对象
 * 字节流 -> 字符流
 * InputStreamReader(InputStream in)
 * InputStream in = System.in;
 * InputStreamReader isr = new InputStreamReader(in);
 * BufferedReader bufr = new BufferedReader(isr);
 * bufr.readLine();//读取一行
 * bufr对应的是输入流，也就是键盘录入
 * 字符流 -> 字节流
 * OutputStreamWriter(OutputStream out)
 * OutputStream out = System.out;
 * OutputStreamWriter osw = new OutputStreamWriter(out);
 * BufferedWriter bufw = new BufferedWriter(osw);
 * bufw对应的是输出流，也就是屏幕输出、屏幕打印
 * */
import java.io.*;

class E
{
	public static void main(String[] args)throws IOException
	{
		//System.in是数据源
		//System.out是控制台，目的
		//读取键盘录入
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		//创建屏幕输出
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line.toUpperCase());
			bufw.newLine();//添加新的行
			bufw.flush();
		}
		bufw.close();
		bufr.close();

		/*
		//复制文本文件
		BufferedReader fr = new BufferedReader(new FileReader("I.java"));
		BufferedWriter fw = new BufferedWriter(new FileWriter("PP.java"));
		
		String  ch = null;
		while((ch = fr.readLine()) != null)
		{
			fw.write(ch);
			fw.newLine();
			fw.flush();
		}
		fr.close();
		fw.close();
		*/
	}
}
