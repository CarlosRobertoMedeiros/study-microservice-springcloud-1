package br.com.roberto.cambioservice.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_CAMBIO")
public class Cambio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="NM_FROM_CURRENCY", nullable = false , length = 3)
	private String from;
	
	@Column(name="NM_TO_CURRENCY", nullable = false , length = 3)
	private String to;
	
	@Column(name="VL_CONVERSION_FACTORY", nullable = false)
	private BigDecimal conversionFactory;
	
	@Transient
	private BigDecimal convertedValue;
	
	@Transient
	private String environment;

	public Cambio() {}

	public Cambio(Long id, String from, String to, BigDecimal conversionFactory, BigDecimal convertedValue,
			String environment) {
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactory = conversionFactory;
		this.convertedValue = convertedValue;
		this.environment = environment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionFactory() {
		return conversionFactory;
	}

	public void setConversionFactory(BigDecimal conversionFactory) {
		this.conversionFactory = conversionFactory;
	}

	public BigDecimal getConvertedValue() {
		return convertedValue;
	}

	public void setConvertedValue(BigDecimal convertedValue) {
		this.convertedValue = convertedValue;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cambio other = (Cambio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
