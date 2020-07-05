package service;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import model.*;

public class MapOperations{
	
	Map<String,TouristPlace> hash = new HashMap<String,TouristPlace>();
	Map<String,TouristPlace> linkedhash = new LinkedHashMap<String,TouristPlace>();
	Map<String,TouristPlace> tree = new TreeMap<String,TouristPlace>();
	
	public HashMap<String,TouristPlace> add(TouristPlace places)
	{
		hash.put(places.getRank(), places);
		linkedhash.put(places.getRank(), places);
		tree.put(places.getRank(), places);
		return (HashMap<String,TouristPlace>) hash;
		
	}
	public Map<String,TouristPlace> sortRandomly(Map<String,TouristPlace> places){
		
		return (HashMap<String,TouristPlace>) hash;
		
	}
	public Object sortInEntryOrder(Map<String,TouristPlace> places){
		
		return linkedhash;
		
	}
	public Object sortAlphabeticall(Map<String,TouristPlace> places){
		
		return tree;
		
	}
	public Object reset(Map<String,TouristPlace> place) {
		
		place.clear();
		return place;
		
	}
	public HashMap<String,TouristPlace> remove(TouristPlace places)
	{
		hash.remove(places.getRank(),places);
		linkedhash.remove(places.getRank(), places);
		tree.remove(places.getRank(), places);
		return (HashMap<String,TouristPlace>) hash;
	}

}