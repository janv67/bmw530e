package be.jv.bmw.data.dynamic;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "bmw_dynamic")
public class Dynamic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@OrderColumn(name = "attributes_map_object")
	@OneToOne(cascade=CascadeType.ALL)
	AttributesMap attributesMapObject;

	// Getter Methods

	public AttributesMap getAttributesMap() {
		return attributesMapObject;
	}
	// Setter Methods

	public void setAttributesMap(AttributesMap attributesMapObject) {
		this.attributesMapObject = attributesMapObject;
	}
}
