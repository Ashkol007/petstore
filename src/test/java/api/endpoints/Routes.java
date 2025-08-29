package api.endpoints;



public class Routes {

	public static String baseurl = "https://petstore.swagger.io/v2";
	
	public static String post_url = baseurl + "/user";
	public static String get_url = baseurl + "/user/{username}";
	public static String update_url = baseurl + "/user/{username}";
	public static String delete_url = baseurl + "/user/{username}";
	public static String login_url = baseurl + "/user/login";
	public static String logout_url = baseurl + "/user/logout";
	public static String postUsers_url = baseurl +"/user/createWithArray";
	
	
//	Store Routes
	
	public static String getStore_url = baseurl + "/store/inventory";
	public static String postOrder_url = baseurl + "/store/order";
    public static String getOrder_url = baseurl + "/store/order/{orderId}";
    public static String deleteOrder_url = baseurl + "/store/order/{orderId}";
	
	
	
	
	
	
	
	
	
}
