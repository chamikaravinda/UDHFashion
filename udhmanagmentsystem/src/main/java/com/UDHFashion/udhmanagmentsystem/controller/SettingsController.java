package com.UDHFashion.udhmanagmentsystem.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.UDHFashion.udhmanagmentsystem.model.User;
import com.UDHFashion.udhmanagmentsystem.service.UserDAOImpl;

@Controller
public class SettingsController {

	@Autowired
	UserDAOImpl serviceUser;

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public ModelAndView settings(ModelAndView model) {

		List<User> user = serviceUser.getUSers();
		model.addObject("users", user);
		model.setViewName("settings/settings");
		return model;
	}

	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public ModelAndView showEditUser(ModelAndView model, @RequestParam("id") int id) {

		User user = serviceUser.getUser(id);
		model.addObject("user", user);
		model.setViewName("settings/editUser");
		return model;
	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(ModelAndView model, @ModelAttribute("user") User user, RedirectAttributes redir) {

		int result = serviceUser.UpdateUser(user);
		if (result == 1) {

			redir.addFlashAttribute("success", 2);
			model.setViewName("redirect:/settings");
			return model;

		} else if (result == 2) {

			model.addObject("user", user);
			model.addObject("error", 2);
			model.setViewName("settings/editUser");
			return model;

		} else {
			
			model.addObject("user", user);
			model.addObject("error", 1);
			model.setViewName("settings/editUser");
			return model;
		}
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public ModelAndView showAddUser(ModelAndView model) {
		User user = new User();
		model.addObject("user", user);
		model.setViewName("settings/addUser");
		return model;
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView saveUser(ModelAndView model, @ModelAttribute("user") User user, RedirectAttributes redir) {
		if (user.getPassword().equals(user.getCpassword())) {
			int result = serviceUser.AddNewUser(user);
			if (result == 1) {

				redir.addFlashAttribute("success", 1);
				model.setViewName("redirect:/settings");
				return model;

			} else if (result == 2) {
				model.addObject("user", user);
				model.addObject("error", 3);
				model.setViewName("settings/addUser");
				return model;
			} else {
				model.addObject("user", user);
				model.addObject("error", 1);
				model.setViewName("settings/addUser");
				return model;
			}
		} else {
			model.addObject("user", user);
			model.addObject("error", 2);
			model.setViewName("settings/addUser");
			return model;
		}

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public ModelAndView deleteUser(HttpServletRequest request, ModelAndView model, @RequestParam("id") int id,
			RedirectAttributes redir) {

		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");

		if (serviceUser.deleteUSer(id)) {
			if (currentUser.getId() == id) {

				model.setViewName("redirect:/logout");
				return model;
			} else {
				redir.addFlashAttribute("success", 3);
				model.setViewName("redirect:/settings");
				return model;
			}
		} else {
			User user = serviceUser.getUser(id);
			model.addObject("user", user);
			model.setViewName("settings/editUser");
			return model;
		}
	}

	@RequestMapping(value = "/passwordUpdate", method = RequestMethod.GET)
	public ModelAndView showUpdatePassword(HttpServletRequest request, ModelAndView model, @RequestParam("id") int id,
			RedirectAttributes redir) {

		HttpSession session = request.getSession();
		User updatingUser = serviceUser.getUser(id);
		updatingUser.setPassword("");

		model.addObject("user", updatingUser);
		model.setViewName("settings/passwordUpdate");
		return model;

	}

	@RequestMapping(value = "/passwordUpdate", method = RequestMethod.POST)
	public ModelAndView updatePassword(ModelAndView model, @ModelAttribute("user") User user,
			RedirectAttributes redir) {

		User userDB = serviceUser.getUser(user.getId());
		if (user.getPassword().equals(userDB.getPassword())) {
			if (user.getNpassword().equals(user.getCpassword())) {
				if (serviceUser.UpdatePassword(user)) {
					redir.addFlashAttribute("success", 4);
					model.setViewName("redirect:/settings");
					return model;
				} else {
					model.addObject("user", user);
					model.addObject("error", 1);
					model.setViewName("settings/passwordUpdate");
					return model;
				}
			} else {
				model.addObject("user", user);
				model.addObject("error", 2);
				model.setViewName("settings/passwordUpdate");
				return model;
			}

		} else {
			model.addObject("user", user);
			model.addObject("error", 1);
			model.setViewName("settings/passwordUpdate");
			return model;
		}
	}
}
