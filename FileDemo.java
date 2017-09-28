/*
 * File
 * File(String pathname)
 * File(String parent, String child)
 * File(File parent, String child)
 * sop(File)的时候，打印的就是其创建时使用的字符串
 * */
import java.io.*;

class FileDemo
{
	public static void main(String[] args)throws IOException
	{
		method_1();
		/*
		//创建文件
		File f1 = new File("abc.txt");
		File f2 = new File("/home/zhshuang/桌面/haha.txt");
		File d = new File("/home/zhshuang/桌面/");
		File f3 = new File(d, "abc.txt");
		File f4 = new File("/home/zhshuang", "ttt.txt");

		System.out.println("f1 = "+f1);
		System.out.println("f2 = "+f2);
		System.out.println("f3 = "+f3);
		System.out.println("f4 = "+f4);

		//为了使分隔符能够跨平台，需要使用静态字段String separator
		File f5 = new File(File.separator+"home"+File.separator+"zhshuang"+File.separator+"桌面"+File.separator+"aaa.txt");
		System.out.println("f5 = "+f5);
		*/
	}

	public static void method_1()throws IOException
	{
		//f对应了一个文件
		//但是要想创建，
		//还需要使用createNewFile()
		File f = new File(File.separator+"home"+File.separator+"zhshuang"+File.separator+"桌面"+File.separator+"file.txt");

		System.out.println("create: "+f.createNewFile());
		f.deleteOnExit();//在程序退出之前把文件或者指定文件夹删除

		//删除File指定的文件或者文件夹
//		System.out.println("delete: "+f.delete());
	}
}

