class Single
{
	private Single(){

	}

	private static Single s = null;

	public static Single getInstance()
	{

		if(s == null)
		{
			synchronized(Single.class)
			{
				if(s == null)
					s = new Single();
			}
		}

		return s;
	}
	
	public void show()
	{
		System.out.println("hello, world");
	}

}

class SingleDemo
{
	public static void main(String[] args)
	{
		Single.getInstance().show();
	}
}
