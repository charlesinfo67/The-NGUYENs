package bcccp.tickets.adhoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdhocTicketDAO  implements IAdhocTicketDAO  {

	private Map<String, IAdhocTicket> currentTickets;
	private IAdhocTicketFactory adhocTicketFactory_;
	private int currentTicketNo;

	
	
	public AdhocTicketDAO(IAdhocTicketFactory factory) {
		//TODO Implement constructor           
            this.factory = factory;
            
	}

	
	
	@Override
	public IAdhocTicket createTicket(String carparkId) {
		 IAdhocTicket NewTicket = this.factory.make(carparkId, currentTicketNo);
            ticketList.add(NewTicket);            
            currentTicketNo++;
            return NewTicket;
	}
	
	
	
	@Override
	public IAdhocTicket findTicketByBarcode(String barcode) {
		for(int i = 0; i < ticketList.size(); i++){
                    IAdhocTicket t = ticketList.get(i);
                    if(t.getBarcode().equals(barcode)){
                        return t;                    
                    }
                }
                System.out.println("Ticket not in system");
		return null;
	}

	
	
	@Override
	public List<IAdhocTicket> getCurrentTickets() {
		
		return this.ticketList;
	}



}
