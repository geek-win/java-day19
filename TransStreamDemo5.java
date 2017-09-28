/*
 * 键盘录入，屏幕输出
 *
 * */
import java.io.*;

class TransStreamDemo5
{
	public static void main(String[] args)throws IOException
	{
		/*
		//1、读取键盘录入
		InputStream in = System.in;
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader bufr = new BufferedReader(isr);

		//创建屏幕输出
		OutputStream out = System.out;
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bufw = new BufferedWriter(osw);
*/
		/*
		//2、读取键盘录入以及屏幕输出流对象
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
*/
	
		/*
		//3、将键盘录入存到文件中
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("out.txt"));
		*/

		/*
		//4、将文件输出到屏幕
		//源：文本文件，字符流，FileReader。提高效率使用缓冲区
		//目的：屏幕，字节流，OutputStream。提高效率使用缓冲区
		//文本对象，所以转化成字符流
		BufferedReader bufr = new BufferedReader(new FileReader("out.txt"));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
*/
		/*
		//5、将图片进行复制到图片文件
		//源：InputStream和Reader。不是纯文本，使用字节流，缓冲区
		//目的：图片，字节流，OutputStream，缓冲区
		BufferedInputStream bufr = new BufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
		BufferedOutputStream bufw = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/3.png"));
		int ch = 0;
		while((ch = bufr.read()) != -1)
			bufw.write(ch);
*/
//
//对于图片文件来说，是字节流，不能转成字符流，会出问题，所以只能使用字节流。
//对于源文件使用BufferedInputStream
//目标文件就是BufferedOutputStream
//			BufferedWriter bufw = new BufferedWriter(new FileWriter("/home/zhshuang/桌面/4.png"));


		//将键盘录入存到文件中，存储的编码表自己指定
		//源：键盘录入，
		//目的：文件，文本文件，理论上是FileWriter，但是指定编码表，所以
		//需要使用字符流读取流对象OutputStreamWriter
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out2.txt"), "UTF-8"));

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
