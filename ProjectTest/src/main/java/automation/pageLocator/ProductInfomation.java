package automation.pageLocator;

public class ProductInfomation {
	public String website;
	public String productName;
	public double productPrice;
	public String productLink;
	
	public ProductInfomation(String _website , String _productName , double fomatted, String _productLink) {
		this.website = _website;
		this.productName = _productName;
		this.productPrice = fomatted;
		this.productLink = _productLink;
	}

	@Override
	public String toString() {
		return "ProductInfomation: website= " + website + "\n"
				+ productName + "\n" 
				+ String.format("%,.2f VND", productPrice) + "\n"
				+ productLink + "\n"
				+ "--------------";
	}
	
	
}
