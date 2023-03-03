package GenericUtility;

import java.util.Random;

public class JavaLibrary {
public int randomNumber()
{
	Random random=new Random();
	int ran = random.nextInt(1000);
	return ran;
}

}
