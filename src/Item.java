public class Item {

    private String name;
    private String description;
    private Movable movable;


	public Item(String name, String description, Movable movable) {
		this.name = name;
		this.description = description;
		this.movable = movable;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Movable getMovable() {
		return movable;
	}
}
