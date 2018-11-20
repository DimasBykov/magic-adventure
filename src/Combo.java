public class Combo {

    private  Item object;
    private  Item subject;
    private  Item result;
    private  String massage;



	public Combo(Item object, Item subject, Item result, String massage) {
		this.object = object;
		this.subject = subject;
		this.result = result;
		this.massage = massage;
	}

	public String getMassage() {
		return massage;
	}

	public Item getResult() {
		return result;
	}

	public Item getObject() {
		return object;
	}

	public Item getSubject() {
		return subject;
	}
}
