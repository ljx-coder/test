package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Books;

import service.BooksService;
import util.Page;

@Controller
@RequestMapping("/books")
public class BooksController {
	@Autowired
	private BooksService booksService;
	
	//ajax实现动态分页查询
	/*@RequestMapping("/queryDynamic.do")
	@ResponseBody
	public Object queryDynamic(Page<Books> page,Books book){
		int firstResult=(page.getPageNo()-1)*page.getPageSize();
		int maxResult=page.getPageSize();
		page.setPageCount((booksService.getCount()-1)/page.getPageSize()+1);
		List<Books> list=booksService.queryDynamic(book.getName(), book.getTypes(), firstResult, maxResult);
		page.setPageData(list);
		return page;
	}*/
	//页面转发实现动态分页查询
	@RequestMapping("/queryDynamic.do")
	public String  queryDynamic(Page<Books> page,Books book,Model model){
		int firstResult=(page.getPageNo()-1)*page.getPageSize();
		int maxResult=page.getPageSize();
		page.setPageCount((booksService.getCount()-1)/page.getPageSize()+1);
		page.setPageData(booksService.queryDynamic(book.getName(), book.getTypes(), firstResult, maxResult));
		int pageBack=page.getPageNo()-1>0?page.getPageNo()-1:page.getPageNo();
		long pageNext= page.getPageNo()+1>page.getPageCount()?page.getPageCount():page.getPageNo()+1;
		model.addAttribute("pageBack", pageBack);
		model.addAttribute("pageNext", pageNext);
		model.addAttribute("page",page);
		//数据回显
		model.addAttribute("name", book.getName());
		model.addAttribute("types", book.getTypes());
		return "showBooks";
	}
	//页面间删除
	@RequestMapping("/delete.do")
	public String delete(Page<Books> page,Books book,Model model){
		booksService.delete(book.getBid());
		queryDynamic(page, book, model);
		return "showBooks";
	}
	

}
