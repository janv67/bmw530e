package be.jv.bmw.data.dynamic;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_vehiclemessages")
public class VehicleMessages {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@OrderColumn(name = "ccmMessages")
//	@OneToMany(cascade = CascadeType.ALL)
//	@ElementCollection
//	@JoinColumn(name="id")
//	List<Object> ccmMessages = new ArrayList<Object>();
//
//	@OrderColumn(name = "cbsMessages")
//	@OneToMany(cascade = CascadeType.ALL)
//	@ElementCollection
//	@JoinColumn(name="id")
//	List<Object> cbsMessages = new ArrayList<Object>();

}
