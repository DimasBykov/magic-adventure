import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static ArrayList<Combo> comboList = new ArrayList<>();

    public static void main(String[] args) {

	     Item bucket = new Item("ведро","пустое ведро",Movable.MOBILE);
	     Item whiskey = new Item("виски","бутылка виски",Movable.MOBILE);
	     Item chain  = new Item("цепь","цепь",Movable.MOBILE);
	     Item well = new Item("колодец","колодец",Movable.STATIONARY);
	     Item weld = new Item("горелка","горелка",Movable.STATIONARY);
	     Item magical = new Item("волшебник","волшебник",Movable.STATIONARY);
	     Item BucketAndChain = new Item("ведро","ведро и цепь",Movable.MOBILE);
	     Item BucketOnChain = new Item("ведро","ведро на цепи",Movable.MOBILE);
	     Item BucketwithWater = new Item("ведро","ведро с водой",Movable.MOBILE);
	     Item frog = new Item("лягушка","лягушка",Movable.MOBILE);

	     Combo BucketwithChaincombo = new Combo(bucket,chain,BucketAndChain,"Теперь у вас есть ведро с цепью\n");

	     Combo BucketOnChainCombo = new Combo(BucketAndChain,weld,BucketOnChain,"Теперь цепь надежно приварена к ведру.\n");
	     Combo BucketwithWaterCombo = new Combo(BucketOnChain,well,BucketwithWater,"Держа ведро за цепь, вы опускаете его в колодец и поднимаете полным до краев.\n");
	     Combo bucketOnMagical = new Combo(BucketwithWater,magical,BucketOnChain,"Волшебник вскакивает и начинает отряхиваться. Приведя себя в порядок, он благодарит вас за помощь и протягивает вам магический кристалл. Вы выиграли!\n");
	     Combo emptybucketOnMagical = new Combo(bucket,magical,bucket,"В ведре пусто.\n");
	     Combo bucketWithuoutChainOnWell = new Combo(bucket,well,bucket,"Вода слишком далеко. Не достать.\n");


	    comboList.add(BucketwithChaincombo);
	    comboList.add(BucketOnChainCombo);
	    comboList.add(BucketwithWaterCombo);
		comboList.add(bucketOnMagical);
		comboList.add(emptybucketOnMagical);
		comboList.add(bucketWithuoutChainOnWell);

		Location attic = new Location("Чердак","Вы на чердаке старого дома. В углу видна гигантская горелка. Вниз ведет лестница.");


	    Location livingRoom = new Location("Гостиная","Вы находитесь в гостиной в доме волшебника. А вот и он сам громко храпит на кровати. На западе от вас есть дверь, рядом лестница\n" +
			    "наверх.");

	    Location garden = new Location("Сад","Вы в прекрасном саду. Прямо по курсу находится колодец. На востоке дверь в дом.");

	    attic.getInventory().add(weld);
		attic.setDirections(Direction.ВНИЗ,livingRoom);

	    livingRoom.getInventory().add(magical);
	    livingRoom.getInventory().add(whiskey);
	    livingRoom.getInventory().add(bucket);
		livingRoom.setDirections(Direction.ВВЕРХ,attic);
		livingRoom.setDirections(Direction.ВОСТОК,garden);

		garden.getInventory().add(frog);
		garden.getInventory().add(chain);
		garden.getInventory().add(well);
		garden.setDirections(Direction.ЗАПАД,livingRoom);

		Player player = new Player(livingRoom);

	    Scanner in = new Scanner(System.in);

	    while (true){

		    System.out.print("> ");
			String command = in.nextLine();
			String[] comWords;
			comWords = command.split(" ");

			if (comWords[0].equals("осмотреться")){
				player.lookAround();
			}
			else if (comWords[0].equals("идти")|| comWords[0].equals("пойти")){
					player.go(comWords[1]);
			}
			else if (comWords[0].equals("взять")){
					player.take(comWords[1]);
			}
			else if (comWords[0].equals("использовать")){

				try {
					player.use(comWords[1],comWords[3]);
				}
				catch (ArrayIndexOutOfBoundsException e){
					System.out.println("неправильно введена команда \n");
				}
			}
			else if (comWords[0].equals("инвентарь")){
				player.inventory();
			}
			else if (comWords[0].equals("выйти")) {
				System.exit(0);
			}
	    }

    }
}
