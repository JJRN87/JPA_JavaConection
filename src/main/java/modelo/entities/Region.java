package modelo.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="regions")

public class Region implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="region_id")
	// @GeneratedValue(strategy = GenerationType.IDENTITY) para autoincrement en mysql. se asterica por que no está este campo per sé. No haría falta
	private int regionId;
	
	@Column(name="region_name")
	private String regionName;
	
	public Region(int regionId, String regionName) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
	}

	public Region() {
		super();
	}

	public int getRegionId() {
		return regionId;
	}

	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(regionId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		return regionId == other.regionId;
	}

	@Override
	public String toString() {
		return "Region [regionId=" + regionId + ", regionName=" + regionName + "]";
	}
	
	
}
