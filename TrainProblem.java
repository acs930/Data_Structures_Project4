
public class TrainProblem {
  
	public static class TrainRoute
	{
		private int numStations;
		private TrainStation startStation;
		private TrainStation endStation;
		private TrainStation nextStation;
		private int timeBetweenStations;
		
		public TrainRoute()
		{
			this(0, null, null, null);
		}
		
		public TrainRoute(int theNumStations, TrainStation theStartStation, TrainStation theEndStation, TrainStation theNextStation)
		{
			numStations = theNumStations;
			startStation = theStartStation;
			endStation = theEndStation;
			nextStation = theNextStation;
			timeBetweenStations = 5;
		}
		
		public int getNumStations()
		{
			return numStations;
		}
		
		public TrainStation getStartStation()
		{
			return startStation;
		}
		
		public TrainStation getEndStation()
		{
			return endStation;
		}
		
		public TrainStation getNextStation()
		{
			return nextStation;
		}
		
		public int getTime()
		{
			return timeBetweenStations;
		}
		
	}
	
	public static class Train
	{
		private int capacity;
		private int size;
		private TrainRoute theRoute;
		private TrainStation currentStation;
		private Passenger passengerArray[];
		
		public Train()
		{
			this(0,0, null, null);
		}
		
		public Train(int theCapactiy, int theSize, TrainRoute route, TrainStation startStation)
		{
			capacity = theCapactiy;
			size = theSize;
			passengerArray = new Passenger[capacity];
			theRoute = route;
			currentStation = startStation;
		}
		
		public int getCapacity()
		{
			return capacity;
		}
		
		public TrainRoute getRoute()
		{
			return theRoute;
		}
		
		public int getSize()
		{
			return size;
		}
		
		public void incrementSize(int position, Passenger newPass)
		{
			passengerArray[position] = newPass;
			size++;
		}
		
		public TrainStation getCurrentStation()
		{
			return currentStation;
		}
		
		public void setCurrentStation(TrainStation newStation)
		{
			currentStation = newStation;
		}
		
		public void setRoute(TrainRoute newRoute)
		{
			theRoute = newRoute;
		}
		
	}
	
	public static class TrainStation
	{
		private String stationName;	
		private theLinkedQueue <Passenger> theQueue;
		
		public TrainStation()
		{
			this("no name", null);
		}
		
		public TrainStation(String theStationName,  theLinkedQueue newQueue)
		{
			stationName = theStationName;		
			theQueue = newQueue;
		}
		
		public String getStationName()
		{
			return stationName;
		}
		
		public void setName(String newName)
		{
			stationName = newName;
		}
		
		public theLinkedQueue getQueue()
		{
			return theQueue;
		}
		
		
		
	}
	
	public static class Passenger
	{
		private TrainStation entryStation;
		private TrainStation destinationStation;
		private int arrivalTime;
		
		public Passenger()
		{
			this(null, null, 0);
		}
		
		public Passenger(TrainStation theEntryStation, TrainStation theDestinationStation, int theArrivalTime)
		{
			entryStation = theEntryStation;
			destinationStation = theDestinationStation;
			arrivalTime = theArrivalTime;
		}
		
		public TrainStation getEntry()
		{
			return entryStation;
		}
		
		public TrainStation getDestination()
		{
			return destinationStation;
		}
	}
	
	public static void simulate(int duration, double arrivalProb)
	{
		theLinkedQueue ts1Queue = new theLinkedQueue();
		theLinkedQueue ts3Queue = new theLinkedQueue();
		theLinkedQueue currentQueue = new theLinkedQueue();
		theLinkedQueue otherQueue = new theLinkedQueue();
		TrainStation ts1 = new TrainStation("Station1", ts1Queue);
		TrainStation ts3 = new TrainStation("Station3", ts3Queue);
		TrainStation currentStation = new TrainStation();
		TrainRoute tr3 = new TrainRoute(2, ts1, ts3, ts3);
		TrainRoute tr1 = new TrainRoute(2, ts3, ts1, ts1);
		Train t1 = new Train(20,0, tr3, ts1);
		int count = 0;
		
		for(int clock = 0; clock < duration; clock++)
		{
			if(Math.random() < arrivalProb)
			{
				Passenger newPassenger = new Passenger(ts1, ts3, clock);
				currentStation = newPassenger.getEntry();
				currentQueue = currentStation.getQueue();
				currentQueue.enqueue(newPassenger);
			
				if((clock % 5) == 0)
				{
					for(int i = 0; i < ts1Queue.size(); i++)
					{
						if((t1.getCurrentStation()) == (newPassenger.getEntry()))
						{
							if (t1.getSize() <= t1.getCapacity())
							{
								t1.incrementSize(count, newPassenger);
								currentQueue.dequeue();
								count++;
							}
						}
						else
						{
							otherQueue.enqueue(currentQueue.dequeue());
						}
					}
					System.out.println("There are " + t1.getSize() + " people on the train.");
					if((clock % 10) == 0 )
					{
						int newCount;
						if(t1.getCurrentStation() != t1.getRoute().getEndStation())
						{
							t1.setCurrentStation(t1.getRoute().getNextStation());   //gives the train its next station
							for(newCount = 0; newCount < t1.getSize(); newCount++)
							{
								if(t1.passengerArray[newCount].getDestination() == t1.getCurrentStation())
								{
									t1.passengerArray[newCount] = null;
									t1.size--;
								}
							}
							System.out.println("There are " + t1.getSize() + " people left on the train");
						}
						
						else if((t1.getCurrentStation() == t1.getRoute().getEndStation()) && (t1.getRoute() == tr3))
						{
							t1.setRoute(tr1);
						}
						
						else if((t1.getCurrentStation() == t1.getRoute().getEndStation()) && (t1.getRoute() == tr1))
						{
							t1.setRoute(tr3);
						}
					}
				}

			}

			
			
		}
	}

	
public static void main(String args[])
	{

		simulate(100, .5);
		
	//add size to train and add a add people to size to train function
//make currentstation queue be added to
//check time if time is mod 5 then update all trains and trainStations 
// and then do passenger stuff if the conditions are right for each station/train
// may need to add functions to trainstation and train class 
// like an update trainstation function and such
//good luck	
		
	}
	
}

