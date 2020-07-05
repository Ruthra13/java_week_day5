package service;
import java.util.ArrayList;
import java.util.List;
import model.*;


public class ListOperations{
	List<TouristPlace> place = new ArrayList<TouristPlace>();
	
	public List<TouristPlace> add(TouristPlace places){
		
		place.add(places);
		return place;
		
	}  
	
	public List<TouristPlace> remove(TouristPlace places)
	{
		place.remove(places);
		return place;
	}
	
	public Object sortByDestination(List<TouristPlace> places)
	{
	
		places.sort((TouristPlace t1,TouristPlace t2)-> t1.getDestination().compareTo(t2.getDestination()));
		return places;
	}
	
	public Object sortByRank(List<TouristPlace> places)
	{
		places.sort((TouristPlace t1,TouristPlace t2)-> t1.getRank().compareTo(t2.getRank()));
		return places;
	}
	public Object reset(List<TouristPlace> places)
	{
		places.clear();
		return places;
	}

}
