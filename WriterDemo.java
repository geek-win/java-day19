/*
 * Reader有个子类InputStreamReader是字节流转换成字符流的通道
 * Writer有个子类OutputStreamWriter是字符流转成字节流的通道
 * */
import java.io.*;
class WriterDemo
{
	public static void main(String[] args)throws IOException
	{
		/*
		Runtime r = Runtime.getRuntime();

		Process p = r.exec("命令");
		p.destroy();
		*/

		//输出流，对应屏幕
		OutputStream out = System.out;//对应输出流
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bufw = new BufferedWriter(osw);
		
		//输入流，对应键盘录入
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader bufr = new BufferedReader(isr);

		String line = null;
		while((line = bufr.readLine()) != null)
		{
			if("over".equals(line))
				break;

			bufw.write(line.toUpperCase());
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
		bufr.close();

	}
}
