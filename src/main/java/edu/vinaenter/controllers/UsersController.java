package edu.vinaenter.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.dao.UserDAO;
import edu.vinaenter.models.User;

@Controller
@RequestMapping("users")
public class UsersController {

	public static final String MSG_ERR = "Đăng nhập thất bại";
	public static final String MSG_SUCCESS = "Đăng nhập thành công!";
	public static final String MSG_LOGIN = "Bạn phải đăng nhập tại đây!";
	public static final String MSG_ACTIVE = "Tài khoản của bạn chưa được kích hoạt!";

	@Autowired // DI
	private UserDAO userDAO;

	private List<User> listUser = new ArrayList<User>();

	@GetMapping("list")
	public String list(Model model, HttpSession session, RedirectAttributes re) {
		if (session.getAttribute("userLogin") == null) {
			re.addFlashAttribute("msg", MSG_LOGIN);
			return "redirect:/users/login";
		}
		listUser = userDAO.getUsers();
		model.addAttribute("datas", listUser);
		return "users/list";
	}

	@GetMapping("login")
	public String add() {
		return "users/login";
	}

	@PostMapping("login")
	public String add(Model model, @ModelAttribute User user, HttpSession session, RedirectAttributes re,
			HttpServletRequest request) throws IllegalStateException, IOException {
		// Upload to server
//		MultipartFile infoFile = news.getPic();
//		String fileName = getFileNameServer(infoFile.getOriginalFilename());
//		infoFile.transferTo(pathFile(fileName, DIR_UPLOAD, request));
//
//		news.setId(UUID.randomUUID().toString());
//		news.setCreatedBy(new Date());
//		news.setPicture(fileName);
//		listNews.add(news);
//		session.setAttribute("datas", listNews);
//		re.addFlashAttribute("msg", MSG_SUCCESS);
		listUser = userDAO.getUsers();
		for (User user2 : listUser) {
			if ((user.getUsername()).equals(user2.getUsername()) && (user.getPassword()).equals(user2.getPassword())) {
				if ((user2.getActive()).equals("active")) {
					session.setAttribute("userLogin", user);
					re.addFlashAttribute("msg", MSG_SUCCESS);
					return "redirect:/users/list";
				} else {
					re.addFlashAttribute("msg", MSG_ACTIVE);
					return "redirect:/users/login";
				}

			}
		}
		re.addFlashAttribute("msg", MSG_ERR);
		return "redirect:/users/login";
	}

}
