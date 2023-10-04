package atm.com.web.jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ATMServlet")
public class ATMServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("userID");
        String pin = request.getParameter("pin");
        String action = request.getParameter("action");
        String amountStr = request.getParameter("amount");
        double ammount=1000;

        // Add your authentication logic here (e.g., check user ID and PIN)

        double amount = Double.parseDouble(amountStr);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>ATM Result</title></head><body>");

        if (authenticate(userID, pin)) {
            if ("history".equals(action)) {
                // Retrieve and display transaction history
                out.println("<h2>Transaction History for User " + userID + ":</h2>");
                // Add code to fetch and display transaction history here
                out.print("You have not any Transestion History");
                
            } else if ("withdraw".equals(action)) {
                out.println("Withdraw Ammount:"+amount);
                double d=Double.parseDouble(amountStr);
                if(d<ammount-200) {
                double tam=ammount-d;
                out.println("Totel Ammount="+tam);
                }
                else
                	out.print("You have not Suffucient Balance");
            	// Perform withdrawal and display result
                // Add code for withdrawal logic here
            } else if ("deposit".equals(action)) {
                out.println("Deposit Ammount:"+amount);
                double d=Double.parseDouble(amountStr);
                double tam=ammount+d;
                out.println("Totel Ammount="+tam);

            } else if ("transfer".equals(action)) {
               
            }
        } else {
            out.println("<h2>Authentication failed. Please try again.</h2>");
        }

        out.println("</body></html>");
    }

    private boolean authenticate(String userID, String pin) {
    	
    	
    	
        // Add your authentication logic here (e.g., check user ID and PIN against a database)
        // Return true if authentication is successful, false otherwise
        return "7890".equals(pin) && "756655".equals(userID); // For demonstration purposes, always return true
    }
}
