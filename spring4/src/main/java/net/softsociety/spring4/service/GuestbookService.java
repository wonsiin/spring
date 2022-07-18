package net.softsociety.spring4.service;

import java.util.ArrayList;

import net.softsociety.spring4.vo.Guestbook;

public interface GuestbookService {
	
	public int insertGuestbook(Guestbook guestbook);
	
	public ArrayList<Guestbook> selectGuestbook();
	
	public int deleteGuestbook(int num);
	
	public int passGuestbook(String password);
}
