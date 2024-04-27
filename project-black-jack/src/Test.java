interface X {
	void aaa();
	void bbb();
}

interface Y {
	void ccc();
	void ddd();
}

class C implements X, Y {
	public void ccc() {}
	public void ddd() {eee(1);}
	public void aaa() {}
	public void bbb() {eee(2);}
	private void eee(int x) {}
}

class Client1 {
	static void dosmth(X x) {
		x.aaa();
		x.bbb();
	}
}

class Client3 {
	static void dosmth(X x, Y y) {
		if(x == y) {
			
		}
	}
}

public class Test {

	public static void main(String[] args) {
		Client1.dosmth(new C());
		Client3.dosmth(new C(), new C());
	}

}
