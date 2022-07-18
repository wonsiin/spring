package net.softsociety.spring4.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.softsociety.spring4.dao.GuestbookDAO;
import net.softsociety.spring4.vo.Guestbook;
@Service
@Slf4j
public class GuestbookServiceImpl implements GuestbookService{
	
	@Autowired
	private GuestbookDAO guestbookDAO;
	
	@Override
	public int insertGuestbook(Guestbook guestbook) {
		
		int result = guestbookDAO.insertGuestbook(guestbook);
		
		return result;
	}
	
	@Override
	public ArrayList<Guestbook> selectGuestbook() {
		ArrayList<Guestbook> result = guestbookDAO.selectGuestbook();
		return result;
	}
	
	@Override
	public int deleteGuestbook(int num) {

		int result = guestbookDAO.deleteGuestbook(num);
		
		 
		return result;
	}
	
	@Override
	public int passGuestbook(String password) {

		int result = guestbookDAO.passGuestbook(password);
		
		 
		return result;
	}

}
