package collectionL;




class Candy{
	String name;
	int sweetness;
	
	public Candy(String name,int sweetness) {
		this.name=name;
		this.sweetness=sweetness;
	}
	@Override
	public String toString() {
		return name + "(Sweetness :"+sweetness+")";
	}
	
}
