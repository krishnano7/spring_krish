package com.spring.conterollers;

import java.util.List;

import org.dom4j.rule.Mode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pojos.ItemInfo;

@Controller
public class OrderMangmentController {

	@RequestMapping(value = "/addItemPage")
	public String showAddItemPage() {
		System.out.println("exe ordermangment controlles:: showadditempage");
		return "addItemToMenu";
	}
	
	/*--------------------------------------------------------------------------------------------*/


	@RequestMapping(value = "/addItemToMenu", method = RequestMethod.POST)
	public String addItemToMenu(ItemInfo item, Model model) {
		System.out.println("exe ordermangment controlles:: items in menu");
		// save Items to database

		System.out.println(
				item.getItem() + "----" + item.getPrice() + "---" + item.getQty() + "---" + item.getTypeofitem());

		Configuration config = new Configuration().configure("hibernate.cfg.xml");// contains dbs configuration
																					// code/file
		System.out.println("need to configure");
		SessionFactory sf = config.buildSessionFactory();// sessionfactory
		Session session = sf.openSession();
		Transaction tc = session.beginTransaction();
		System.out.println("session started");

		session.save(item);
		tc.commit();
		session.close();

		String msg = item.getItem() + "add to menu sucessfully";
		model.addAttribute("message", msg);
		return "addItemToMenu";
	}
	
	/*--------------------------------------------------------------------------------------------*/


	@RequestMapping(value = "/showMenu")
	public String ShowMenu(Model model) {

		Configuration config = new Configuration().configure("hibernate.cfg.xml");// contains dbs configuration
																					// code/file
		System.out.println("need to configure");
		SessionFactory sf = config.buildSessionFactory();// sessionfactory
		Session session = sf.openSession();

		Query query = session.createQuery("from ItemInfo");// line 60 is for getting data from database
		List<ItemInfo> menuData = query.list();// data fetched from database is add to list

		for (ItemInfo itemInfo : menuData) {

			System.out.println(itemInfo.getItemid() + itemInfo.getItem() + itemInfo.getPrice() + itemInfo.getQty());

		}
		model.addAttribute("menuData", menuData);

		return "Menu";
	}
	
	/*--------------------------------------------------------------------------------------------*/


	/* code for delete items from jsp page */

	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@RequestParam("itemid") int itemid, Model model) {
		System.out.println("delete request came from :" + itemid);

		Configuration config = new Configuration().configure("hibernate.cfg.xml");// contains dbs configuration
																					// code/file
		SessionFactory sf = config.buildSessionFactory();// sessionfactory
		Session session = sf.openSession();
		Transaction tc = session.beginTransaction();

		Query userDeleteQuery = session.createQuery(" delete ItemInfo where itemid =:id ");
		System.out.println("delete query sucessfully");
		userDeleteQuery.setParameter("id", itemid);
		int executeUpdateMenu = userDeleteQuery.executeUpdate();
		tc.commit();

		if (executeUpdateMenu == 1) {
			System.out.println("delete sucessfully!!");
			String message = itemid + "delete sucessfully!!";
			model.addAttribute("message", message);

		} else {
			System.out.println("failed to delete!!");
			String message = itemid + "failed to delete!!";
			model.addAttribute("message", message);
		}

		Query fetchMenuQuery = session.createQuery("from ItemInfo");
		List<ItemInfo> menuData = fetchMenuQuery.list();
		model.addAttribute("menuData", menuData);
		session.close();

		return "Menu";

	}
	
	/*--------------------------------------------------------------------------------------------*/


	/* code for edit items from jsp page */
	@RequestMapping(value = "/editItem", method = RequestMethod.POST)
	public String editItem(@RequestParam("itemid") int itemid, Model model) {

		System.out.println("edit request came from :" + itemid);

		Configuration config = new Configuration().configure("hibernate.cfg.xml");// contains dbs configuration
																					// code/file
		SessionFactory sf = config.buildSessionFactory();// sessionfactory
		Session session = sf.openSession();

		Query fetchMenuQuery = session.createQuery("from ItemInfo where itemid=:id");
		fetchMenuQuery.setParameter("id", itemid);
		ItemInfo item = (ItemInfo) fetchMenuQuery.list().get(0);
		model.addAttribute("itemInfo", item);
		String typeofitem = item.getTypeofitem();

		if (item.getTypeofitem().equals("Veg")) {
			model.addAttribute("veg", "checked");
		} else {
			model.addAttribute("nonVeg", "checked");
		}

		session.close();

		return "EditView";
	}

	/*--------------------------------------------------------------------------------------------*/
	
	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public String updateItem(ItemInfo item, Model model) {
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.update(item);
		tx.commit();
		String message = item.getItem() + " updated successfully!!";
		model.addAttribute("msg", message);
		System.out.println(message);
		// fetching updated menu data to show in view page

		Query fetchMenuQuery = session.createQuery("from ItemInfo");
		List<ItemInfo> menuData = fetchMenuQuery.list();
		model.addAttribute("menuData", menuData);

		session.close();
		return "Menu";

	}

}
