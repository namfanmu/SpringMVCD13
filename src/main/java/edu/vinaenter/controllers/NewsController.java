package edu.vinaenter.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.dao.NewsDAO;
import edu.vinaenter.models.News;

@Controller
@RequestMapping("news")
public class NewsController {

	@Autowired // DI
	private NewsDAO newsDAO;

	public static final String MSG_ERR = "Không tim thấy id, vui lòng đọc tin khác!";
	public static final String MSG_SUCCESS = "Thêm thành công!";
	public static final String DIR_UPLOAD = "Uploads";

	private List<News> listNews = new ArrayList<News>();

	@GetMapping("list")
	public String list(Model model) {
//		model.addAttribute("datas", listNews);
		return "news/list";
	}

//	@GetMapping("detail")
//	public String detail(@RequestParam int id, Model model) {
//		News findNews = new News();
//		for (News news : newsDao.getList()) {
//			if(news.getId() == id) {
//				findNews = news;
//				break;
//			}
//		}
//		model.addAttribute("news", findNews);
//		return "news/detail";
//	}

	@GetMapping("detail/{id}/{author}") // news/detail/1
	public String detail(@PathVariable(name = "id") String id, @PathVariable String author, Model model,
			RedirectAttributes re, HttpSession session) {
		News findNews = null;
		if (session.getAttribute("datas") != null) {
			List<News> listDatas = (List<News>) session.getAttribute("datas");
			for (News news : listDatas) {
				if (news.getId().equals(id)) {
					findNews = news;
					break;
				}
			}

			// If doesn't find id then redirect to the list
			if (findNews == null) {
				re.addFlashAttribute("msg", MSG_ERR);
				return "redirect:/news/list";
			}
		}

		model.addAttribute("news", findNews);
		return "news/detail";
	}

	@GetMapping("add")
	public String add() {
		return "news/add";
	}

	@PostMapping("add")
	public String add(Model model, @ModelAttribute News news, HttpSession session, RedirectAttributes re,
			HttpServletRequest request) throws IllegalStateException, IOException {
		// Upload to server
		MultipartFile infoFile = news.getPic();
		String fileName = getFileNameServer(infoFile.getOriginalFilename());
		infoFile.transferTo(pathFile(fileName, DIR_UPLOAD, request));

		news.setId(UUID.randomUUID().toString());
		news.setCreatedBy(new Date());
		news.setPicture(fileName);
		listNews.add(news);
		session.setAttribute("datas", listNews);
		re.addFlashAttribute("msg", MSG_SUCCESS);
		return "redirect:/news/list";
	}

	public String getFileNameServer(String fileName) {
		// fileName
		if (!StringUtils.isEmpty(fileName)) {
			String extension = FilenameUtils.getExtension(fileName);
			String baseName = FilenameUtils.getBaseName(fileName);
			StringBuilder builder = new StringBuilder();
			builder.append(baseName).append("-").append(System.nanoTime()).append(".").append(extension);
			return builder.toString();
		}
		return StringUtils.EMPTY;
	}

	public File pathFile(String fileName, String folder, HttpServletRequest request) {
		String rootPath = request.getServletContext().getRealPath("");
		File disry = new File(rootPath + folder);
		if (!disry.exists()) {
			disry.mkdirs();
		}
		File file = new File(rootPath + folder + "/" + fileName);
		System.out.println(rootPath + folder + "/" + fileName);
		return file;
	}
}
