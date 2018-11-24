import java.util.HashMap;
import java.util.Map;

public class Inventory {


   private  Map<String,Item> items = new HashMap<>();

	public void add(Item item){
		items.put(item.getName(),item);
    }

    public  void remove(String item){

    	items.remove(item);

    }

    public  void show(){
		int i =0;
		if (items.isEmpty()){
			System.out.println("В вашем инвентаре пусто. \n");
		}
		else {
			for (Item item : items.values()) {
				if (items.size()!=i+1) {
					i++;
					System.out.print(item.getDescription());
					System.out.print(", ");
				}
				else {
					System.out.println(item.getDescription());
				}
			}
		}

    }

    public Item find(String itemName){

		for (int i =0;i<items.size(); i++){
			if (items.containsKey(itemName)){
				return items.get(itemName);
			}
		}

		return null;

    }

	public Map<String, Item> getItems() {
		return items;
	}
}
