package zarazio.travel.android.service;

import java.util.List;

import zarazio.travel.android.bean.attachedFileDTO;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.hashTagDTO;

public interface boardService {
	public void insertBoard(boardDTO board) throws Exception;
	public int maxboard_Code()throws Exception;
	public void insertHash(hashTagDTO hash)throws Exception;
	public void insertFile(attachedFileDTO file)throws Exception;
	public List<boardDTO> boardList()throws Exception;
	public List<attachedFileDTO> selPicture(int board_code)throws Exception;
}
