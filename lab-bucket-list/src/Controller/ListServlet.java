package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TouristPlace;
import service.ListOperations;


@WebServlet(urlPatterns= {"/list"})
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String destination = request.getParameter("travel");
		String rank = request.getParameter("rank");
		String add = request.getParameter("add");
		
		String sortbydestination = request.getParameter("sortbydestination");
		String sortbyrank = request.getParameter("sortbyrank");
		String remove = request.getParameter("delete");
		String reset = request.getParameter("reset");
		
		System.out.println("Entering into list");
		ListOperations list = new ListOperations();
		TouristPlace places = new TouristPlace(name,destination,rank);
		List<TouristPlace> add_place = new ArrayList<TouristPlace>();
		
	
		if(add!=null) {
			// Call the add method in list operations and store the return list in list variable
			
			add_place = list.add(places);
			System.out.println("calling add equals method");
			
		
			request.setAttribute("bucketList", add_place);
			request.setAttribute("message", "user added successfully");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(remove!=null) {
			// call the remove method and store the return list in a list variable
			
			
			List<TouristPlace> remove_place = new ArrayList<TouristPlace>();
			remove_place = list.remove(places);
			
			request.setAttribute("bucketList", remove_place);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		
		if(sortbydestination!=null) {
			// call the sortByDestination method and store the value in a list variable
			List<TouristPlace> sort_destiny = new ArrayList<TouristPlace>();
			sort_destiny = (List<TouristPlace>) list.sortByDestination(add_place) ;
			request.setAttribute("bucketList", sort_destiny);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(sortbyrank!=null) {
		// call the sortByRank method and store the value in a list variable
			
			List<TouristPlace> sort_rank = new ArrayList<TouristPlace>();
			sort_rank = (List<TouristPlace>) list.sortByRank(add_place);
			request.setAttribute("bucketList", sort_rank);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

		if(reset!=null) {	
			// call the clear method and store the value in a list variable
			
			List<TouristPlace> clr = new ArrayList<TouristPlace>();
			clr = (List<TouristPlace>) list.reset(add_place);
			request.setAttribute("bucketList", clr);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/list.jsp");
			rd.forward(request, response);
		}

	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
