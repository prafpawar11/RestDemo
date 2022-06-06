package tutorial3;

public class demo {
	//POJO
	private int id;
	private String name;
	private String address;
	private String job;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "demo [id=" + id + ", name=" + name + ", address=" + address + ", job=" + job + "]";
	}

	
}
