package Pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root{
    @JsonProperty("P01") 
    public ArrayList<P01> p01;
    @JsonProperty("P02") 
    public ArrayList<P02> p02;
    
    public ArrayList<P01> getP01() {
		return p01;
	}
	public void setP01(ArrayList<P01> p01) {
		this.p01 = p01;
	}
	public ArrayList<P02> getP02() {
		return p02;
	}
	public void setP02(ArrayList<P02> p02) {
		this.p02 = p02;
	}
	
}