package apiConfigs;

public class ApiEndPoints {
	
	public static final class apipath {
		
		//GET USERS

		public static final String GET_LIST_OF_USERS = "/users";
		public static final String GET_SINGLE_USER ="/users/{userIndex}";

		// GET PRODUCTS
		public static final String GET_LIST_OF_PRODUCTS = "/products";
		public static final String GET_SINGLE_PRODUCT = "/products/{id}";


		// GET STORES
		public static final String GET_LIST_OF_STORES = "/stores";

		//GET ORDERS
		public static final String GET_LIST_OF_ORDERS = "/orders";


		public static final String GET_NESTED_JSON = "/nested_json";
		
		
		//POST
		public static final String POST_MP_ORDER ="/orders";


		//PATCH
		public static final String PATCH_STOCK_DATA = "/products/{id}";

		//CM52
		public static final String CM52 = "/api/mcm/products/export/async";
		public static final String CM53 = "/api/mcm/products/export/async/status/{tracking_id}";


		
		
		
	}

}
