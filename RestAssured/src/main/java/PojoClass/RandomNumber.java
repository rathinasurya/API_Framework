package PojoClass;

import java.util.Random;

public class RandomNumber {
public int randomKey()
{
	{
		Random ran=new Random();
		int random = ran.nextInt(500);
		return random;
	}
}
}
