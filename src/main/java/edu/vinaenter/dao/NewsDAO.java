package edu.vinaenter.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.vinaenter.models.News;

@Repository
public class NewsDAO {
	
	public List<News> getList() {
		List<News> datas = new ArrayList<News>();
		datas.add(new News("1", "News 1", "John Tran", new Date(), "Detail 1", 1));
		datas.add(new News("2", "News 2", "John Tran", new Date(), "Detail 2", 1));
		datas.add(new News("3", "News 3", "John Tran", new Date(), "Detail 3", 0));
		datas.add(new News("4", "News 4", "John Tran", new Date(), "Detail 4", 1));
		datas.add(new News("5", "News 5", "John Tran", new Date(), "Detail 5", 1));
		datas.add(new News("6", "News 6", "John Tran", new Date(), "Detail 6", 1));
		return datas;
	}
}
