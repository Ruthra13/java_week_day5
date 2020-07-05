package service;
import java.util.HashSet;
import java.util.TreeSet;

import model.*;


public class SetOperations{
	
	HashSet<TouristPlace> set = new HashSet<TouristPlace>();
	
	public HashSet<TouristPlace> add(TouristPlace places)
	{
		set.add(places);
		return set;
	}
	
	
	public HashSet<TouristPlace> remove(TouristPlace places)
	{
		set.remove(places);
		return set;
	}
	public Object sortByDestination(HashSet<TouristPlace> places)
	{
		TreeSet<TouristPlace> set1 =
				new TreeSet<TouristPlace>((t1,t2) -> t1.getDestination().compareTo(t2.getDestination()) );
		for(TouristPlace t:places)
		{
			set1.add(t);
		}
		return set1;
	}
	public Object sortByRank(HashSet<TouristPlace> places)
	{
		TreeSet<TouristPlace> set1 =
				new TreeSet<TouristPlace>((t1,t2) -> t1.getRank().compareTo(t2.getRank()) );
		for(TouristPlace t:places)
		{
			set1.add(t);
		}
		return set1;
		
	}
	public Object reset(HashSet<TouristPlace> places)
	{
		places.clear();
		return places;
	}

}