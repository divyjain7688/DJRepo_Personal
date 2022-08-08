package udemyApiTest;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import udemyApiResource.payload;

public class SapientJsonTest {

	@Test
	public void testSapientResponse()
	{
		String response = payload.sapientTestJson();
		System.out.println("response is "+ response);
		JsonPath js = new JsonPath(response);
		int size =js.get("members.size()");
		System.out.println(js.get("members"));
		System.out.println(js.get("members[0]"));

		for(int i=0;i<size;i++)
		{
			if(js.get("members["+i+"].memberAddress.State").equals("Gurugram"))
			{
				System.out.println(js.get("members["+i+"].memberName"));
			}
		}
		
	//	System.out.println(js.param("city", "Gurugram").get("findAll {it.members.memberAddress.State == city}"));

		
		System.out.println("memberid of Gurugram user is "+js.getList( "members.findAll{it.memberAddress.State == 'Gurugram' }.memberAddress.PinCode" ));
		System.out.println("memberid of Gurugram user is "+js.getList( "members.findAll{it.memberAddress.State == 'Gurugram' }.memberName" ));

	}


/*

{
	"members": 
	[
		{
			"memberName": "Amit",
			"memberId": 101,
			"memberAddress": 
			{
				"PinCode": 410057,
				"State": "Gurugram"
			}
		},
		{
			"memberName": "Sameer",
			"memberId": 102,
			"memberAddress": 
			{
				"PinCode": 410057,
				"State": "Gurugram"
			}
		},
		{
			"memberName": "Jassi",
			"memberId": 104,
			"memberAddress": 
			{
				"PinCode": 454332,
				"State": "Delhi"
			}
		}		
	]
}
 */


@Test
public void testFindAll()
{

	String response = payload.findAllJson();
	//System.out.println("response is "+ response);
	JsonPath js = new JsonPath(response);
	
	System.out.println(js.getList("members.findAll { it.name == 'getName'  }.id"));

	
	System.out.println(js.param("name", "getName").getList("findAll { a -> a.name == name  }"));
	System.out.println(js.param("name", "getName").get("findAll { a -> a.name == name  }"));
	System.out.println(js.param("name", "getName").getList("findAll { it.name == name  }"));
	System.out.println(js.param("test", "getName").get("findAll { it.name == test  }"));
	System.out.println(js.get("findAll { it.name == 'getName'  }"));
	System.out.println(js.get("findAll { it.name == 'getName'  }.id"));
	System.out.println(js.getList("findAll { it.name == 'getName'  }.id"));


}

/*
 [
{
    "id": 9741962,
    "name": "getName",
    "isActive": true
},
{
    "id": 432434,
    "name": "getName",
    "isActive": true
},
{
    "id": 1,
    "name": "New",
    "isActive": true
}
]
*/
}