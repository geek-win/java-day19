/*
 * File(String pathname)
 * File(String path, String child)
 * File(File parent, String child)
 * */
import java.io.*;

class FileDemo2
{
	public static void main(String[] args)throws IOException
	{
		File f1 = new File("abc.txt");
		File f2 = new File("/home/zhshuang/桌面/a.txt");
		File f3 = new File("/home/zhshuang/桌面", "c.txt");
//		f3.deleteOnExit();//程序结束后删除文件

		File d = new File("/home/zhshuang");
		File f4 = new File(d, "d.txt");

		File f5 = new File(File.separator+"home"+File.separator+"zhshuang"+File.separator+"e.txt");

		System.out.println("f1 = "+f1);
		System.out.println("f2 = "+f2);
		System.out.println("f3 = "+f3);
		System.out.println("f4 = "+f4);
		System.out.println("f5 = "+f5);

		System.out.println("f3.createNewFile(): "+f3.createNewFile());
//		System.out.println("f1.delete:"+f1.delete());
	}
}
