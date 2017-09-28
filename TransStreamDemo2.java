/*
 * 将图片文件复制到文本文件
 * */
import java.io.*;

class TransStreamDemo2
{
	public static void main(String[] args)throws IOException
	{
		//源：图片文件，字节流，InputStream，并且想提高效率。使用缓冲区
		//字节流输入流是读取数据，不需要flush。直接write
		BufferedInputStream bufin = new BufferedInputStream(new FileInputStream("/home/zhshuang/桌面/p1.png"));
		
		BufferedOutputStream bufout = new BufferedOutputStream(new FileOutputStream("/home/zhshuang/桌面/11.png"));

		/*
		//目的：输出流，OutputStream或者Writer但是是文本文件，所以选择Writer
		//加速使用缓冲区
		//会有精度损失
		//并且目标文件无法打开
		BufferedWriter bufout = new BufferedWriter(new FileWriter("/home/zhshuang/桌面/2.txt"));
		*/

		int ch = 0;
		while((ch = bufin.read()) != -1)
			bufout.write(ch);

		bufin.close();
		bufout.close();
	}
}
