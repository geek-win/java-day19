/*
 * IO流的复习
 * IO流分为字符流和字节流
 * 1、字符流体系
 * 基类；Reader、Writer
 * 字符读取流
 * Reader
 *	|--InputStreamReader
 *		|--FileReader
 *	|--BufferedReader
 *		|--LineNumberReader
 * 字符写入流
 * Writer
 *	|--OutputStreamWriter
 *		|--FileWriter
 *	|--BufferedReader
 * 2、字节流体系
 * 基类：InputStream、OutputStream
 * 字节输入流
 * InputStream
 *  |--FileInputStream
 *  |--FilterInputStream
 *		|--BufferedInputStream
 * 字节输出流
 * OutputStream
 *	|--FileOutputStream
 *	|--FilterOutputStream
 *		|--BufferedOutputStream
 * 3、字节流和字符流的区别？
 * IO流就是数据流
 * 字节流是对以字节为单位对数据进行处理，一般是图片、视频、音频等媒体数据
 * 字符流是以字符为单位对数据进行处理。一般是文本文件
 * 字节流可以处理字符流，但是字符流不一定可以处理字节流。
 * 字符流底层还是字节流。
 * 字节流可以转换成字符流，字符流在存储到硬盘的时候还是要转成字节流，这就是转换流
 * InputStreamReader(InputStream in)
 * OutputStreamWriter(OutputStream out)
 * 4、装饰类和继承体系
 * 现有的类有一些方法无法满足需求，我们可以构造其子类，并对现有的方法进行复写，以便进行功能的改进和增强，但是继承体系较为庞大，并且冗余的内容较多，所以可以使用装饰类。也就是装饰设计模式。将需要功能增强的类对象传入装饰类的构造函数中，基于已有方法，增强功能，提供装饰类。所以装饰设计模式比继承要灵活，并且装饰类和被装饰类同属于一个体系。并且扩展性很强。只需要将需要功能增强的类对象传入装饰类的构造函数即可，扩展性很强。所以相对与继承来说，扩展性和灵活性好很多。并且避免了体系的冗余庞大。
 * 5、各个类的基本功能
 * 1)Reader
 *	abstract void close()
 *	abstract int read(char[] buf, int off, int length)
 *	void int read()//读取单个字符
 *	void int read(char[] buf)//将关联文件数据读到buf中
 * 2)BufferedReader
 *	BufferedReader(Reader in)
 *	String readLine()//读取文本行，不包括换行符等
 *	void close()
 *	int read()
 *	int read(char[] buf, int off, int length)//将最多length个字符读到buf的off开始的位置
 *	3)LineNumber extends BufferedReader
 *	int getLineNumber()//获取行号
 *	void setLineNumber()//设置行号
 *	String readLine()//读取文本行
 *	void close()
 *	4)InputStreamReader
 *	InputStreamReader是转换流，是字节流通往字符流的桥梁。我们在读取字节流的时候，如果想通过字符流的readLine等方法进行读取操作，可以将字节流转成字符流，但是前提是处理的数据是文本数据，否则因为编码表问题容易出错。并且转换流出现的意义，很大一部分是因为编码表。其子类FileReader，使用默认的编码表进行数据读取，但是如果我们想通过指定的编码表进行读取，就需要使用转换流来自定义编码表。
 *	InputStreamReader(InputStream in, String charsetName)
 *	InputStreamReader(InputStream in)
 *	5)FileReader	能够处理文件的字符读取流
 *	throws FileNotFoundException (extends IOException)
 *	FileReader(String fileName)
 *	FileReader(File file)
 *	6)Writer	throws IOException
 *	void write(int c)//写入单个字符
 *	void write(char[] cbuf)//将字符数组cbuf的数据写到字符写入流中
 *	abstract void write(char[] cbuf, int off, int len)//将cbuf数组的off开始的len个字符写到字符写入流中
 *	void write(String str)//将字符串写入字符写入流
 *	void write(String str, int off, int len)//将str的off开始的len个字符写到字符写入流中
 *	abstract void flush()//将字符写入流中的数据刷到目标文件中。
 *	对于字符流来说，底层调用的是字节流的缓冲区，所以写入数据是写到流中，如果想写到目标文件，需要使用flush方法将数据刷到文件中。
 *	abstract void close()
 *	7)BufferedWriter
 *	BufferedWriter(Writer out)
 *  void newLine()//添加换行符
 *  void flush()//将数据从缓冲区刷到文件中
 *  8)OutputStreamWriter
 *  OutputStreamWriter是字符流通往字节流的转换流，我们录入的是字符，但真正在硬盘中存储的时候还是要使用字节流，所以要使用转换流。其子类FileWriter使用默认的编码表进行数据存储，但是如果想使用指定编码表进行存储，就需要使用转换流，这样是转换流存在的主要意义。
 *  OutputStreamWriter(OutputStream out)
 *  OutputStreamWriter(OutputStream out, String charsetName)//使用指定的编码表存储
 *  9)FileWriter	能够处理文件的字符写入流
 *  FileWriter(String fileName)
 *  FileWriter(File file)
 *	FileWriter(String fileName, boolean append)//如果append为true，表示如果没有fileName文件存在就创建，如果有就不创建，直接在文件末尾进行数据操作
 *  10)InputStream
 *  abstract int read()//读取一个字节
 *  int read(byte[] buf)//读到byte数组中
 *  int read(byte[] buf, int off, int len)//将最多len个字节存到buf数组的off开始位置
 *	int available()//返回此输入流关联文件的估计字节数
 *	System.in
 *	11)FileInputStream
 *	同上
 *	12)BufferedInputStream
 *	同上
 *	13)OutputStream
 *	void close()
 *	abstract void write(int b)//将字节b写入输出流
 *  void write(byte[] buf)//将buf写入输出流
 *  void write(byte[] buf, int off, int len)//将buf的off开始的len写入输出流
 *	void flush()//当使用缓冲区的时候才会用到flush，其他时候write就会直接写到目标文件中
 *	14)FileOutputStream
 *	同上
 *	15)BufferedOutputStream
 *	void flush()
 *  6、针对需求，找到对应的类
 *  1）明确源和目的
 *  源：输入流InputStream或Reader
 *  目的；输出流OutputStream或Writer
 *  2）明确体系
 *  根据是否是纯文本选择字符流还是字节流
 *  如果是纯文本选择字符流，当然也可以使用字节流
 *  如果是图片、视频、音频等文件，只能使用字节流
 *  3）根据设备确定具体的对象
 *  源：内存、硬盘（文件）、键盘
 *  目的：内存、硬盘（文件）、屏幕控制台
 *  7、几个小问题
 *  1）键盘录入
	InputStream System.in
	是标准输入流，默认的输入设备是键盘
	如果使用System.setIn(InputStream in)可以指定输入设备
 *  BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
 *  BufferedInputStream bufin = new BufferedInputStream(System.in);
 *	2）屏幕控制台输出
 *	PrintStream System.out
 *	是标准输出流，默认的输出设备是屏幕控制台
 *	如果使用System.setOut(PrintStream ps)就可以指定输出设备
 *	BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));
 *	3）把异常信息存到指定文件中
 *	Exception 类的方法
 *	void printStackTrace()//将异常信息打印到控制台
 *  void printStackTrace(System.out)//将异常信息输出到System.out指定的目标。如果没有设置out，就默认是控制台
 *	void printStackTrace(PrintStream out)//将异常信息输出到out指定的文件中
 *  4）System中的静态方法
 *  static Properties getProperties()
 *  如果直接打印返回的Map集合，数据较为复杂，可以使用Properties的特有方法
 *  public void list(PrintStream out)//将属性列表输出到out指定的输出流
 *  5）BufferedReader
 *  内部使用了缓冲区，字符数组，用来存储数据，其readLine()调用的是其装饰的字符读取流的read()方法。也就是装饰类的功能增强是基于已有方法进行修饰。
 *  6）BufferedInputStream
 *  内部有缓冲字节数组。首先判断其缓冲区是否是空的，如果是空的，就通过其提高读取效率的字节输入流的read(byte[] buf)将关联文件内容从硬盘存到缓冲区中，然后再读取字节数据，如果缓冲区不是空的，就直接读取其中的字节数据。这样就先不用每次从硬盘读取数据，速度较快。所以如果使用了缓冲区，写入的时候就需要flush才能写入。
 *  7）关闭资源
 *  关闭资源之前，需要判断其是否是null。如果是null，才关闭资源，否则不需要
 *  8）BufferedInputStream的read方法
 *  缓冲区中的数据都是byte类型，返回值是int类型，所以byte类型要转成int类型
 *  如果返回是-1，二进制是1111，如果直接返回，那么转成int还是-1，4个1111，那么进行判断的时候可能会误判为文件结束。所以需要和255相与，这样，即使是-1
 *  那么-1和255相与，那么-1会变成int类型和255相与，这样返回的就是255，就不会误判
 *	对应的，字节流的write(int b)，其实内部会将b转换成byte存入。
 * */ 
 import java.io.*;
 import java.util.*;
 import java.text.*;

 //实现BufferedReader类的功能
 class MyBufferedReader extends Reader
{
	//需要提高读取效率的字符读取流
	private Reader r;

	//构造函数
	//将需要被功能提升的类对象传入
	MyBufferedReader(Reader r)
	{
		this.r = r;
	}

	//复写父类的抽象函数close
	//关闭字符读取缓冲区其实就是关闭其关联的字符读取流
	//所以不需要单独关闭字符读取流
	public void close()throws IOException
	{
		if(r != null)
			r.close();
	}

	//复写父类的抽象函数read(char[] buf, int off, int len)
	public int read(char[] cbuf, int off, int len)throws IOException
	{
		return r.read(cbuf, off, len);
	}

	//实现字符读取流缓冲区的读取文本行的功能
	public String myReadLine()throws IOException
	{
		//创建字符数组缓冲区
		char[] cbuf = new char[1024];
		int ch = 0, pos = 0;

		while((ch = r.read()) != -1)
		{
			if(ch == '\n')
			{
				return new String(cbuf, 0, pos);
			}
			else
				cbuf[pos++] = (char)ch;
		}

		//如果没有换行符就结束了
		//需要将数组中的缓存内容返回
		if(pos > 0)
			return new String(cbuf, 0, pos);

		return null;
	}
}

//实现LineNumberReader的功能
class MyLineNumberReader extends MyBufferedReader
{
	//进行装饰的字符读取流
	//父类中有，就省略不写
	//private Reader r;
	//成员变量行号
	private int lineNumber;

	//构造函数
	//将被操作的字符读取流对象传入构造函数
	MyLineNumberReader(Reader r)
	{
		super(r);
	}

	//设置行号
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	//获取行号
	public int getLineNumber()
	{
		return this.lineNumber;
	}

	//读取文本行
	public String myReadLine()throws IOException
	{
		//读取文本行之后行号会自增
		lineNumber++;

		//调用父类的读取文本行方法
		return super.myReadLine();
	}
}

//实现BufferedInputStream的功能
class MyBufferedInputStream
{
	//进行修饰的字节输入流对象
	private InputStream in;
	//缓冲区数组
	private byte[] buf = new byte[1024*4];
	//数组指针和计数器
	private int pos = 0, count = 0;

	//构造函数
	//将被装饰的字节输入流对象传入
	MyBufferedInputStream(InputStream in)
	{
		this.in = in;
	}

	//读取方法
	//每次只读一个字节，是从缓冲区中读取字节，效率较高
	//首先判断缓冲区是否是空的
	//如果是空的，调用in.read(buf)，将文件数据输出到缓冲区，然后从缓冲区获取字节
	//如果不是空的，直接从缓冲区中读取字节
	public int myRead()throws IOException
	{
		//如果缓冲区是空的
		if(count == 0)
		{
			count = in.read(buf);

			//如果文件已被读完或者是空的则返回-1
			if(count < 0)
				return -1;

			//否则从缓冲区读取字节数据
			pos = 0;
			byte b = buf[pos];
			pos++;
			count--;

			return b&255;
		}
		else if(count > 0)
		{
			byte b = buf[pos];
			pos++;
			count--;

			return b&255;
		}
		return -1;
	}

	//关闭资源
	public void myClose()throws IOException
	{
		if(in != null)
			in.close();
	}
}

class IoTest
{
	public static void main(String[] args)
	{
		//创建字符流读取缓冲区对象
		MyBufferedReader mybufr = null;

		//创建MyLineNumberReader对象
		MyLineNumberReader myline = null;
		
		//创建字节流输入缓冲区对象
		MyBufferedInputStream mybufin = null;

		//创建字符流写入缓冲区
		BufferedWriter bufw = null;
	
		//创建字节流输出缓冲区
		BufferedOutputStream bufout = null;

		try
		{
			//创建各个实体
			//源
			//输入流
			mybufr = new MyBufferedReader(new FileReader("I.java"));
			myline = new MyLineNumberReader(new FileReader("I.java"));
			mybufin = new MyBufferedInputStream(new FileInputStream("I.java"));

			//目的
			//输出流
			bufw = new BufferedWriter(new OutputStreamWriter(System.out));
			bufout = new BufferedOutputStream(System.out);

			/*
			//将I.java文件输出到控制台
			int ch = 0;
			while((ch = mybufin.myRead()) != -1)
			{
				bufout.write(ch);
				bufout.flush();
			}
			*/
				
			//将I.java文件输出到控制台
			String line = null;
			//myline.setLineNumber(20);
			while((line = mybufr.myReadLine()) != null)
			{
				bufw.write(line);
				bufw.newLine();
				bufw.flush();
			}
		}
		catch(Exception e)
		{
			try
			{
				//创建打印输出流
				//关联文件存储异常信息
				PrintStream out = new PrintStream("sys.log");

				//获取异常时间
				String time = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss").format(new Date());
				out.println(time);//将time输出到out指定输出流中
				
				//将异常信息输出到out指定输出流中
				e.printStackTrace(out);
			}
			catch(Exception e1)
			{
				throw new RuntimeException("创建文件异常");
			}
		}
		finally
		{
			if(mybufr != null)
			{
				try
				{
					mybufr.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(myline != null)
			{
				try
				{
					myline.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(mybufin != null)
			{
				try
				{
					mybufin.myClose();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(bufw != null)
			{
				try
				{
					bufw.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			if(bufout != null)
			{
				try
				{
					bufout.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
