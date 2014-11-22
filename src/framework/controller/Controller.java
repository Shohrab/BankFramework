package framework.controller;

public class Controller implements IController {

	private static Controller controller;
	public static Controller createInstance() {
		if (controller == null) {
			controller = new Controller();
		}
		return controller;
	}
	public Controller() {

	}
	public void LoadTableData() {
		
	}
}
