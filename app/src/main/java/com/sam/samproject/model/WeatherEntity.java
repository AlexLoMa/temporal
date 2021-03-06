package com.sam.samproject.model;

import java.util.List;

public class WeatherEntity{
	private int dt;
	private Coord coord;
	private List<WeatherItem> weather;
	private String name;
	private int cod;
	private Main main;
	private Clouds clouds;
	private int id;
	private Sys sys;
	private String base;
	private Wind wind;

	public void setDt(int dt){
		this.dt = dt;
	}

	public int getDt(){
		return dt;
	}

	public void setCoord(Coord coord){
		this.coord = coord;
	}

	public Coord getCoord(){
		return coord;
	}

	public void setWeather(List<WeatherItem> weather){
		this.weather = weather;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCod(int cod){
		this.cod = cod;
	}

	public int getCod(){
		return cod;
	}

	public void setMain(Main main){
		this.main = main;
	}

	public Main getMain(){
		return main;
	}

	public void setClouds(Clouds clouds){
		this.clouds = clouds;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setSys(Sys sys){
		this.sys = sys;
	}

	public Sys getSys(){
		return sys;
	}

	public void setBase(String base){
		this.base = base;
	}

	public String getBase(){
		return base;
	}

	public void setWind(Wind wind){
		this.wind = wind;
	}

	public Wind getWind(){
		return wind;
	}

	@Override
 	public String toString(){
		return 
			"WeatherEntity{" + 
			"dt = '" + dt + '\'' + 
			",coord = '" + coord + '\'' + 
			",weather = '" + weather + '\'' + 
			",name = '" + name + '\'' + 
			",cod = '" + cod + '\'' + 
			",main = '" + main + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",id = '" + id + '\'' + 
			",sys = '" + sys + '\'' + 
			",base = '" + base + '\'' + 
			",wind = '" + wind + '\'' + 
			"}";
		}
}