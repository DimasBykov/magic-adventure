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


	// Лишние геттеры. Класс Combo должен сам решать, выдавать result или нет. То есть нужен метод,
    // который будет сравнивать subject и object и возвращать result.
    // Сейчас получается так, что Combo - это тупой класс, который ничего не умеет, кроме как
    // предоставить доступ к своим членам.

	public Item getObject() {
		return object;
	}

	public Item getSubject() {
		return subject;
	}
}
