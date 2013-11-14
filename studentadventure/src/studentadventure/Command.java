package studentadventure;

public class Command {
	private String name;
	private String actionName;
	
	public Command(String name, String actionName) {
		this.setName(name);
		this.setActionName(actionName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	public String toString() {
		return name + " | " + actionName;
	}
}
