public class Player  {

   private Location location;
   private Inventory playerinventory;

	public Player(Location location) {
		this.location = location;
		playerinventory = new Inventory();
	}

	public void lookAround(){
	    System.out.println(location.getDescription());
    }

    public void go(String direction){

		if (location.findNext(direction.toUpperCase())!=null){
			setLocation(location.findNext(direction.toUpperCase()));
			lookAround();
		}
		else {
			System.out.println("Вы не можете туда пойти.\n");
		}
    }

	public void take(String item){
		if (location.getInventory().find(item)!=null) {
			if (location.getInventory().find(item).getMovable() == Movable.MOBILE) {
				playerinventory.add(location.getInventory().find(item));
				location.getInventory().remove(item);
				System.out.println("У вас есть " + item +"\n");
			} else {
				System.out.println("Вы не можете взять этот предмет.\n");
			}
		}
		else {
			System.out.println("Этого предмета тут нет.\n");
		}
	}

    public void use(String object, String subject){
		 if (playerinventory.find(object)!=null){
			if (location.getInventory().find(subject)!=null||playerinventory.find(subject)!=null){
				for (int i =0;i<Game.comboList.size();i++) {
					if (Game.comboList.get(i).getObject().equals(playerinventory.find(object)) &&
							(Game.comboList.get(i).getSubject().equals(playerinventory.find(subject))|| Game.comboList.get(i).getSubject().equals(location.getInventory().find(subject)))) {
						playerinventory.remove(object);
						if (Game.comboList.get(i).getSubject().getMovable()==Movable.MOBILE){
							playerinventory.remove(subject);
						}
							playerinventory.add(Game.comboList.get(i).getResult());
						System.out.println(Game.comboList.get(i).getMassage());
						}
				}
			}
			else{
				System.out.println("Тут или в вашем инвентаре нет нужного вам инструмента или предмета. Возможно, вы просто не можете использовать данную комбинацию.\n");
			}
		}else{
			System.out.println("Тут или в вашем инвентаре нет нужного вам инструмента или предмета. Возможно, вы просто не можете использовать данную комбинацию.\n");
		}
    }

    public void inventory(){
		playerinventory.show();
    }

	public void setLocation(Location location) {
		this.location = location;
	}
}
