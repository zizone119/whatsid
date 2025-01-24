package ch05;

class Item{
	public int price;
}

class Noodle extends Item{
	public Noodle() {
		price = 2500;
	}
	public String toString() {
		return "라면";
	}
}


class Wodong extends Item{
	public Wodong() {
		price = 3000;
	}
	public String toString() {
		return "우동";
	}
}


class MixNoddle extends Item{
	public MixNoddle() {
		price = 2500;
	}
	public String toString() {
		return "비빔국수";
	}
}

class Buyer{
	private int money;
	public Buyer(int money) {
		this.money= money;
	}
	public void buy(Item it,int count) {
		System.out.println(it+"을 "+count+"개 먹었습니다.");
		money = money-it.price*count;
		System.out.println("현재 남은 돈은 "+money);
	}
}

public class Sample4 {

	public static void main(String[] args) {
		Buyer me = new Buyer(20000);
		me.buy(new Wodong(), 2);
		me.buy(new MixNoddle(), 2);
		me.buy(new Noodle(), 2);

	}

}
