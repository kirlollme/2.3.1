package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.UserService.UserService;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;
import web.model.User;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/new")
	public String newUser(@ModelAttribute("user") User user) {
		return "new";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") @Valid User user,
						 BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "new";

		userService.addUser(user);
		return "redirect:/";
	}
	@RequestMapping("/show")
	public String show(Model model, @RequestParam(value = "id", defaultValue = "1") Long id) {
		model.addAttribute("user", userService.getById(id));
		return "showUser";
	}
	@RequestMapping("/edit")
	public String edit(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
					   @RequestParam(value = "id", defaultValue = "1") Long id , Model model) {
		model.addAttribute("user", userService.getById(id));
		return "edit";
	}

//	@PatchMapping("/{id}")
//	public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
//						 @PathVariable("id") Long id) {
//		if (bindingResult.hasErrors())
//			return "/edit";
//
//		userService.changeDataUser(id, user);
//		return "redirect:/";
//	}
	@RequestMapping(value = "/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/";
	}
	@RequestMapping(value = "/edit/{id}")
	public String edit(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
					   @PathVariable(value = "id") Long id) {
		userService.changeDataUser(id,user);
		return "redirect:/";
	}

}