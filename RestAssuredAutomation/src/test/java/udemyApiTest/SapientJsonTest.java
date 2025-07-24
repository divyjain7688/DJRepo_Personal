package udemyApiTest;
import org.hamcrest.collection.HasItemInArray;
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

		
	//	System.out.println("size of members arrays is "+js.getList( "members.findAll{it.length()}" ));
		System.out.println("memberid of Gurugram user is "+js.getList( "members.findAll{it.memberAddress.State == 'Gurugram' }.memberAddress.PinCode" ));
		System.out.println("memberid of Gurugram user is "+js.getList( "members.findAll{it.memberAddress.State == 'Gurugram' }.memberName" ));
		String city = "Gurugram";
		System.out.println("memberid of parameterized Gurugram user is "+js.getList( "members.findAll{it.memberAddress.State == '"+city+"' }.memberAddress.PinCode" ));
		js.getList( "members.findAll{it.memberAddress.State == '"+city+"' }.memberAddress.PinCode" );
		


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
public void testFindAllWithDynamicParams()
{

	String response = payload.findAllJson();
	System.out.println("response is "+ response);
	JsonPath js = new JsonPath(response);
	
	System.out.println(js.getList("findAll{it.name=='getName'}.id"));

	
	
	System.out.println(js.param("name", "divy").getList("findAll { it.name == name  }"));  //dynamic way
	System.out.println(js.getList("findAll{it.name=='divy'}"));  // hardcoded way og above line
	System.out.println(js.param("name", "divy").param("status", true).getList("findAll { it.name == name && it.isActive == status }")); //multiple dynamic parameter

	System.out.println("memberid of Gurugram user is "+js.getList( "members.findAll{it.memberAddress.State == 'Gurugram' }.memberName" ));
	System.out.println(js.param("test", "divy").get("findAll { it.name == test  }"));
	System.out.println(js.get("findAll { it.name == 'divy'  }"));
	System.out.println(js.get("findAll { it.name == 'divy'  }.id"));
	System.out.println(js.getList("findAll { it.name == 'divy'  }.id"));


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