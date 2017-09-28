/*
 * 1、源：键盘录入
 * 目的：控制台
 * 2、源：键盘录入
 * 目的：文件
 * 3、源：文件
 * 目的：文件
 * 4、源：文件
 * 目的：控制台
 * */
import java.io.*;

class TransStreamDemo1
{
	public static void main(String[] args)throws IOException
	{
		/*
		 * 需求1
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
*/
		/*
		//需求2
		//源不变，目的变成文件字节输出流
		BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("out.txt"));
*/

		/*
		//需求3
		//源是输入流InputStream或者Reader，并且是文本文件所以使用字符流FileReader
		//目的是输出流OutputStream或者Writer，并且是文本文件所以使用FileWriter
		//如果想要加速，就可以使用对应的缓冲区
		BufferedReader bufr = new BufferedReader(new FileReader("I.java"));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("out.txt"));
	*/
		
	
		//需求4
		//源：输入流，InputStream和Reader，但是是文本文件，所以使用Reader，并且是文件，所以使用FileReader。提高效率的话就使用缓冲区
		//目的：输出流OutputStream和Writer，是控制台，字节流，所以是OutputStream。
		BufferedReader bufr = new BufferedReader(new FileReader("out.txt"));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		//需求5：
		//源；图片文件，输入流，字节流，选择InputStream，并且想提高效率所以使用缓冲区
		//目的：图片文件，输出流，字节流，OutputStream，提高效率使用缓冲区
		//因为是图片，所以只能使用字节流处理，不要再转换成字符流了
		//如果再转换成字符流，可能会出问题
		//如果是文本文件，那么使用字节流和字符流都ok
		//首选字符流
		/*
		BufferedInputStream bufr = new BufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
		BufferedOutputStream bufw = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/8.png"));
*/
		//假设我们将图片字节流转换成字符流处理
		//经过验证，会有精度损失
		//所以对于图片、视频、音频等媒体数据
		//只能用字节流处理
		//不能将其转换成字符流处理
		//对于文本文件
		//我们既可以使用字节流，也可以使用字符流，推荐使用字符流
		//因为可以使用readLine方法和newLine方法
		/*
		BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("/home/zhshuang/桌面/p1.png")));
		BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("/home/zhshuang/桌面/10.png")));
*/
		String line = null;
		while((line = bufr.readLine()) != null)
		{
			/*
			if("over".equals(line))
				break;
*/
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}
		
		/*

		int ch = 0;
		while((ch = bufr.read()) != -1)
			bufw.write(ch);
*/
		bufr.close();
		bufw.close();
	}
} 
