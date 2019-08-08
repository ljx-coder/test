package service;

import java.util.List;

import entity.Books;

public interface BooksService {
	public int add(Books book);
	public int delete(int id);
    public int update(Books book);
    public long getCount();
    //∂ØÃ¨∑÷“≥≤È—Ø
    public List<Books>  queryDynamic(String name,String types,int firstResult,int maxResult);

}
