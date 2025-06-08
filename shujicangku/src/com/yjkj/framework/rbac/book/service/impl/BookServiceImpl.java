package com.yjkj.framework.rbac.book.service.impl;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.book.model.Book;
import com.yjkj.framework.rbac.book.service.inte.BookService;
@Service
public class BookServiceImpl extends BaseService implements BookService {

	
	@Override
	public Pager informationLoad(Pager pager,Book Book,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("book", Book);
		List<Book> list = this.bookDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Book));
		return pager;
	}

	@Override
	public List<Book> informationLoadAll(Book Book) throws Exception {
		List<Book> list = this.bookDao.informationLoadAll(Book);
		return list;
	}
	

	@Override
	public Integer count(Book Book) throws Exception {
		Integer count = this.bookDao.count(Book);
		return count;
	}

	@Override
	public Book informationLoadOne(Book Book) throws Exception {
			Book = this.bookDao.informationLoadOne(Book);
		return Book;
	}

	@Override
	public void informationDelete(Book Book) throws Exception {
			this.bookDao.informationDelete(Book);

	}

	@Override
	public void informationAdd(Book Book) throws Exception {
			Book.setId(Regular.createId());
			Book.setCreatetime(CreatDate.getDate());
			this.bookDao.informationAdd(Book);

	}

	@Override
	public void informationUpade(Book Book) throws Exception {
			this.bookDao.informationUpdate(Book);
	}
	
	@Override
	public void exceptExcel(Book Book, HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {
		 response.setContentType("application/vnd.ms-excel");  
	         response.setHeader("content-disposition", "attachment;filename=book.xls");  
		List<Book> list = this.bookDao.informationLoadAll(Book);
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("体检报表信息");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("书籍名称");
		row.createCell(1).setCellValue("书籍语种");
		row.createCell(2).setCellValue("供应商名称");
		row.createCell(3).setCellValue("书籍价格");
		row.createCell(4).setCellValue("库存数量");
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
		for (int i = 1; i <= list.size(); i++) {
			Book Book1 = list.get(i - 1);
			row = sheet.createRow(i);
			row.createCell(0).setCellValue(Book1.getName());
			row.createCell(1).setCellValue(Book1.getLanguage());
			row.createCell(2).setCellValue(Book1.getBusiness().getName());
			row.createCell(3).setCellValue(Book1.getPrice().toString());
			row.createCell(4).setCellValue(Book1.getNum());
		}
		 OutputStream  fOut = response.getOutputStream();  
        workbook.write(fOut); 
        fOut.flush();  
        fOut.close(); 
		
	}

}
