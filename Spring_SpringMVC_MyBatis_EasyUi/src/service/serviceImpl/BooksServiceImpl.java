package service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BooksMapper;

import entity.Books;
import service.BooksService;

@Service
@Transactional
public class BooksServiceImpl  implements BooksService{
	@Autowired
	private BooksMapper mapper;

	public int add(Books book) {
		return mapper.add(book);
	}

	public int delete(int id) {
		return mapper.delete(id);
	}

	public List<Books> queryDynamic(String name,String types,int firstResult,int maxResult) {
		return mapper.queryDynamic(name,types,firstResult,maxResult);
	}

	public int update(Books book) {
		return mapper.update(book);
	}

	public long getCount() {
		return mapper.getCount();
	}

}
