package ishop.shopping.domain;

import java.util.ArrayList;
import java.util.Iterator;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ShoppingCart {
	@Id
	String cartId;
	
	Long customerId;
	
	Boolean ordered = false;
	
	
	
	ArrayList<CartLine> cartlineList = new ArrayList<CartLine>();

	public void addToCart(Product product, int quantity) {
		for (CartLine cline : cartlineList) {
			if (cline.getProduct().getProductId().equals(product.getProductId())) {
				cline.setQuantity(cline.getQuantity()+quantity);
				return;
			}
		}
		CartLine cline = new CartLine();
		cline.setProduct(product);
		cline.setQuantity(quantity);
		cartlineList.add(cline);
	}
	
	
	public double getTotalPrice(){
		double totalPrice = 0.0;
		for (CartLine cline : cartlineList) {
			totalPrice=totalPrice+(cline.getProduct().getPrice() * cline.getQuantity());
		}
		return totalPrice;
	}
	
	public void removeFromCart(Product product){
		Iterator<CartLine> iter = cartlineList.iterator();
		while (iter.hasNext()){
			CartLine cline = iter.next();
			if (cline.getProduct().getProductId().equals(product.getProductId())){
				if (cline.getQuantity()>1){
					cline.setQuantity(cline.getQuantity()-1);
				}
				else{
					iter.remove();
				}
			}
		}
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public ArrayList<CartLine> getCartlineList() {
		return cartlineList;
	}

	public void setCartlineList(ArrayList<CartLine> cartlineList) {
		this.cartlineList = cartlineList;
	}


	public Long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}


	public Boolean getOrdered() {
		return ordered;
	}


	public void setOrdered(Boolean ordered) {
		this.ordered = ordered;
	}
	
	

}
