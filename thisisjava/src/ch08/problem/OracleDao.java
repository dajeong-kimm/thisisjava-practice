package ch08.problem;

public class OracleDao implements DataAccessObject{
	public void select() {
		System.out.println("Oracle DB select");
	}
	public void insert() {
		System.out.println("Oracle DB insert");
	}
	public void update() {
		System.out.println("Oracle DB update");
	}
	public void delete() {
		System.out.println("Oracle DB delete");
	}

}
