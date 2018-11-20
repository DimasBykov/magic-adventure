import java.util.HashMap;
import java.util.Map;

public class Location  {

	private String name;
	private String description;
	private Inventory inventory;
	private Map<Direction, Location> directions;

	public Location(String name, String description) {
		this.name = name;
		this.description = description;

		inventory = new Inventory();
		directions = new HashMap<>();
	}

	public String getDescription() {
		if (inventory.getItems().keySet().isEmpty()){
			return description;
		}
		else {
			return description + " Здесь находятся:" + inventory.getItems().keySet().toString().replace('[', ' ').replace(']', ' ') + "\n";
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public Location findNext(String directionName) {
		if (directions.containsKey(Direction.valueOf(directionName.toUpperCase()))) {
			Direction dir = Direction.valueOf(directionName.toUpperCase());
			return directions.get(dir);
		}else {
			System.out.println("Вы не можете туда пойти \n");
			return null;
		}
	}

	public void setDirections(Direction dir, Location nextLocation) {
		directions.putIfAbsent(dir, nextLocation);
	}


}
