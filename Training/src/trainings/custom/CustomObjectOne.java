package trainings.custom;

public class CustomObjectOne implements ICustomObject {

	private String objectName = "";
	
	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	private static CustomObjectOne _inst;
	
	static {
		System.out.println("[CustomObjectOne] Static Init Running;");
		_inst = null;
	}
	
	{
		System.out.println("[CustomObjectOne] Public Init Running;");
	}
	
	private CustomObjectOne () {
		System.out.println("[CustomObjectOne] Constructor Running;");
	}
	
	public static CustomObjectOne getInstance() {
		System.out.println("[CustomObjectOne] getInstance() Running;");
		if (_inst == null)
			_inst = new CustomObjectOne();
		
		return _inst;
	}
	
	
	
}
