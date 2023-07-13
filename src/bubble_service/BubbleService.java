package bubble_service;

import java.util.ArrayList;

import bubble_dto.BubbleDTO;

public interface BubbleService {
	public void display();
	public int option1(BubbleDTO dto);
	public int option2(BubbleDTO dto);
	public int option3(BubbleDTO dto);
	public ArrayList<BubbleDTO> getList();
}
