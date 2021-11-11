package package1;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FindUniquePair 
{
	private List<String> findUnique(List<String> users) {
		List<String> unique = new ArrayList<>();
		unique.add(users.get(0));
		for(int i=1;i<users.size();i++)
		{
			if(!unique.contains(users.get(i)))
			{
				String[] s = users.get(i).split(",");
				String rev = s[1] +","+ s[0];
				if(!unique.contains(rev))
				{
					unique.add(users.get(i));
				}
			}
		}
		return unique;
	}
	
	@Test
	public void testCase1()
	{
		List<String> users = new ArrayList<>();
		users.add("U1,U2");
		users.add("U3,U4");
		users.add("U1,U5");
		users.add("U2,U1");
		users.add("U3,U4");
		users.add("U2,U4");
		users.add("U2,U4");
		users.add("U5,U1");
		List<String> expected = new ArrayList<>();
		expected.add("U1,U2");
		expected.add("U3,U4");
		expected.add("U1,U5");
		expected.add("U2,U4");
		Assert.assertEquals(findUnique(users), expected);
	}

}
