package ch08.problem;

public class MySqlDao implements DataAccessObject{
	public void select() {
		System.out.println("MySql DB select");
	}
	public void insert() {
		System.out.println("MySql DB insert");
	}
	public void update() {
		System.out.println("MySql DB update");
	}
	public void delete() {
		System.out.println("MySql DB delete");
	}

}
