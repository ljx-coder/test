package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import entity.Books;

public interface BooksMapper {
	public int add(Books book);
	public int delete(int id);
    public int update(Books book);
    public long getCount();
    //��̬������ҳ��ѯ
    public List<Books> queryDynamic(@Param("name")String name,@Param("types")String types,@Param("firstResult")int firstResult,@Param("maxResult")int maxResult);
    
    
}
