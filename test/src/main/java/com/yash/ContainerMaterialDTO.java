package com.yash;

public class ContainerMaterialDTO {
	
	private Integer tea;
	
	private Integer coffee;
	
	private Integer sugar;
	
	private Integer water;
	
	private Integer milk;
	
	public ContainerMaterialDTO() {
		super();
	}
	public ContainerMaterialDTO(Integer tea, Integer coffee, Integer sugar, Integer water, Integer milk) {
		super();
		this.tea = tea;
		this.coffee = coffee;
		this.sugar = sugar;
		this.water = water;
		this.milk = milk;
	}

	@Override
	public String toString() {
		return "ContainerMaterialDTO [tea=" + tea + ", coffee=" + coffee + ", sugar=" + sugar + ", water=" + water
				+ ", milk=" + milk + "]";
	}
	public Integer getTea() {
		return tea;
	}

	public void setTea(Integer tea) {
		this.tea = tea;
	}

	public Integer getCoffee() {
		return coffee;
	}

	public void setCoffee(Integer coffee) {
		this.coffee = coffee;
	}

	public Integer getSugar() {
		return sugar;
	}

	public void setSugar(Integer sugar) {
		this.sugar = sugar;
	}

	public Integer getWater() {
		return water;
	}

	public void setWater(Integer water) {
		this.water = water;
	}

	public Integer getMilk() {
		return milk;
	}

	public void setMilk(Integer milk) {
		this.milk = milk;
	}

	

}
