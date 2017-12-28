package batch.project.prototype;

/**
 * @author ib3d68bn
 *
 */
public class Prototype {
	
	private int id;
	private int hostId;
	private String name;
	private String location;
	private String hostName;
	private String iPaddress;
	private String operativeSystem;

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getHostId() {
		return hostId;
	}
	
	public void setHostId(int hostId) {
		this.hostId = hostId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getHostName() {
		return hostName;
	}
	
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getIPaddress() {
		return iPaddress;
	}
	
	public void setIPaddress(String iPAddress) {
		iPaddress = iPAddress;
	}
	
	public String getOS() {
		return operativeSystem;
	}
	
	public void setOS(String oS) {
		operativeSystem = oS;
	}

	@Override
	public String toString() {
		return "Prototype [id=" + id + ", hostId=" + hostId + ", name=" + name + ", location=" + location
				+ ", hostName=" + hostName + ", iPaddress=" + iPaddress + ", operativeSystem=" + operativeSystem + "]";
	}
}
