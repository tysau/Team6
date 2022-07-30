package library.entities;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Item implements Serializable {
	
	private ItemType type;
	private String author;
	private String title;
	private String callNumber;
	private long id;
	
	private enum itemState {available, onLoan, damaged, reserved };
	private itemState state;
	
	
	public Item(ItemType itemType, String author, String title, String callNo, long id) {
	    this.type = itemType;
	    this.author = author;
	    this.title = title;
	    this.callNo = callNumber;
	    this.id = id;
	    this.state = itemState.available;
	}
	
	public String toString() {
		StringBuilder Sb = new StringBuilder();
		Sb.append("  Item:        ").append(id).append("\n")
		  .append("  Type:        ").append(type).append("\n")
		  .append("  Title:       ").append(title).append("\n")
		  .append("  Author:      ").append(author).append("\n")
		  .append("  Call Number: ").append(callNumber).append("\n")
		  .append("  State:       ").append(state);
		
	    return Sb.toString();
	}

	public Long getId() {
	    return id;
	}

	public String getTitle() {
	    return title;
	}

	public ItemType getItemType() {
	    return type;
	}


	
	public boolean isAvailable() {
	    return state == itemState.available;
	}

	
	public boolean isOnLoan() {
	    return state == itemState.onLoan;
	}

	
	public boolean isDamaged() {
	    return state == itemState.damaged;
	}

	
	public void takeOut() {
		if (state.equals(itemState.available)) {
		    state = itemState.onLoan;
		}
		
		else  {
		    throw new RuntimeException(String.format("Item: cannot borrow item while item is in state: %s", state));
		}
	    	
		
	}


	public void takeBack(boolean DaMaGeD) {
		if (state.equals(itemState.onLoan)) {
		    if (DaMaGeD) {
	                state = itemState.damaged;	
			}

			else {
			    state = itemState.available;	
			}
		}

		
		else { 
		    throw new RuntimeException(String.format("Item: cannot return item while item is in state: %s", state));
		}
				
	}

	
	public void repair() {
		if (state.equals(itemState.damaged)) {
		    state = itemState.available;
		}
		
		else {
		    throw new RuntimeException(String.format("Item: cannot repair while Item is in state: %s", state));
		}
		
	}
}
