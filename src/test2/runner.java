package test2;
import com.experitest.client.*;
import org.junit.*;
public class runner {

  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = "C:\\Users\\taif.hussain\\workspace\\project4";
  protected Client client = null;
  protected GridClient grid = null;

  @Before
  public void setUp(){
      // In case your user is assign to a single project you can provide an empty string, 
      // otherwise please specify the project name
	  grid= new GridClient("admin", "Maxyman23", "Default", "192.168.60.143", 80, false);
	  client = grid.lockDeviceForExecution("testy", "@name='XCover 4-01'", 2850, 50000);
      client.setProjectBaseDirectory(projectBaseDirectory);
      client.setReporter("xml", "reports", "Untitled");
  }

  @Test
  public void testUntitled(){
      // This command "setDevice" is not applicable for GRID execution 
      client.launch("cloud:se.phoniro.xone/.MainActivity", true, true);
      client.elementSendText("default", "Användarnamn_4", 0, "david");
      client.elementSendText("default", "Lösenord_8", 0, "123456");
      client.click("default", "Logga in_7", 0, 1);
      if(client.syncElements(1000, 10000)){
          // If statement
      }
      client.click("default", "element 52", 0, 1);
      client.click("default", "Logga ut_12", 0, 1);
      client.click("default", "Logga ut_11", 0, 1);
  }

  @After
  public void tearDown(){
      // Generates a report of the test case.
      // For more information - https://docs.experitest.com/display/public/SA/Report+Of+Executed+Test
      client.generateReport(false);
      // Releases the client so that other clients can approach the agent in the near future. 
      client.releaseClient();
  }
}
