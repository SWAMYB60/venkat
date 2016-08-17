package com.niit.shoppingcart.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcartbackend.model.Product;
import com.niit.shoppingcartbackend.model.UserDetails;
import com.niit.shoppingcartbackendmodel.ProductDAO;
import com.niit.shoppingcartbackendmodel.UserDAO;
import com.niit.shoppingcartbackendmodel.UserDAOImpl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class HomeController {
	@Autowired
	ProductDAO pd;
	@Autowired
	UserDAO us;

	@RequestMapping("/")
	public ModelAndView display() {
		ModelAndView m1 = new ModelAndView("index");
		return m1;
	}

	@RequestMapping("register")
	public ModelAndView register() {
		return new ModelAndView("register");

	}

	@RequestMapping("login")
	public ModelAndView login() {

		ModelAndView m2 = new ModelAndView("login");
		return m2;

	}

	@RequestMapping("addfurniture")
	public ModelAndView display2() {

		ModelAndView m3 = new ModelAndView("addfurniture");
		return m3;

	}

	@RequestMapping("/display")
	public ModelAndView retriveRecords() {
		ModelAndView m6 = new ModelAndView("display");
		return m6;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showList() {
		List blist = pd.list();
		Gson x = new Gson();
		String json = x.toJson(blist);
		return json;
	}

	@RequestMapping(value = "viewpro", method = RequestMethod.GET)
	public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Product products) {
		Product product = pd.get(id);
		return new ModelAndView("viewpro", "product", product);
		// return new ModelAndView("ViewPro");
	}

	@RequestMapping("hi")
	public String display1() {

		return "index";

	}

	@RequestMapping("contactus")
	public ModelAndView display4() {

		ModelAndView m4 = new ModelAndView("contactus");
		return m4;
	}

	@ModelAttribute("Product")
	public Product createfuniture() {
		return new Product();
	}

	@ModelAttribute("UserDetails")
	public UserDetails createuser() {
		return new UserDetails();
	}

	@RequestMapping("storefurniture")
	public String addproducts(HttpServletRequest request, @Valid @ModelAttribute("Product") Product product,
			BindingResult result) {
		System.out.println("hello niit...........................");
		if (result.hasErrors()) {
			return "addproduct";
		}
		String filename = product.getImg().getOriginalFilename();
		product.setImage(filename);

		try {
			byte[] bytes = new byte[product.getImg().getInputStream().available()];
			product.getImg().getInputStream().read(bytes);
			BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
			MultipartFile file = product.getImg();
			String path = request.getServletContext().getRealPath("/") + "resources/images";
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			System.out.println("Image path :" + path);
			OutputStream os = new FileOutputStream(store);
			os.write(bytes);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		pd.saveOrUpdate(product);
		return "display";

	}

	@RequestMapping(value = "/storeuser", method = RequestMethod.POST)
	public String addUser(@Valid @ModelAttribute("UserDetails") UserDetails userDetails, BindingResult result,
			Model model) {

		if (result.hasErrors()) {

			return "index";
		}

		System.out.println("hello storeUser");
		System.out.println(userDetails.getUsername() + "hello @@@@@@");
		us.saveOrUpdate(userDetails);

		return "index";
	}
	
	
	
	
	
	@RequestMapping("editfurniture")
	public ModelAndView display6() {

		ModelAndView m5 = new ModelAndView("editfurniture");
		return m5;
	}
	
	@RequestMapping(value="editfurniture",method=RequestMethod.GET)
    public ModelAndView editfurniture(@RequestParam int id){
	 System.out.println("hello niit.........................niit1............");	
	 Product furniture1=pd.get(id);
	 System.out.println("hello niit.........................niit2............");
	 System.out.println("eeee "+furniture1.getFurnitureName());
    	return new ModelAndView("editfurniture","Furniture",furniture1);
    }

@RequestMapping(value="/update",method=RequestMethod.POST)
    public ModelAndView updateFurniture(HttpServletRequest request,@Valid @ModelAttribute("furniture")Product furniture,BindingResult result)
    {
    	
    	String filename=furniture.getImg().getOriginalFilename();
    	
    	furniture.setImage(filename);
    	
    	try{
    		byte[] bytes=new byte[furniture.getImg().getInputStream().available()];
    		furniture.getImg().getInputStream().read(bytes);
    		BufferedInputStream buffer=new BufferedInputStream(furniture.getImg().getInputStream());
    		MultipartFile file=furniture.getImg();
    		String path=request.getServletContext().getRealPath("/")+"resources/images";
    		File rootPath=new File(path);
    		if(!rootPath.exists())
    			rootPath.mkdirs();
    		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
    		System.out.println("Image path :"+path);
    		OutputStream os=new FileOutputStream(store);
    		os.write(bytes);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    		        
    	pd.saveOrUpdate(furniture);
    	return new ModelAndView("display");
    }



@RequestMapping("delete")
public ModelAndView deleteProduct(@RequestParam int id)
{
	 System.out.println("hello welcome to niit");
	    pd.deleteProduct(id);
	ModelAndView model=new ModelAndView("display");
	return model;
}









 

}

