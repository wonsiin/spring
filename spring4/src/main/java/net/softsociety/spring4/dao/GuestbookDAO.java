package net.softsociety.spring4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import net.softsociety.spring4.vo.Guestbook;

@Mapper
public interface GuestbookDAO {
	
	public int insertGuestbook(Guestbook guestbook);
	
	public ArrayList<Guestbook> selectGuestbook();
	
	public int deleteGuestbook(Guestbook guestbook);

	public int passGuestbook(String password);
}