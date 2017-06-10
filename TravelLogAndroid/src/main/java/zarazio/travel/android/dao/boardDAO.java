package zarazio.travel.android.dao;

import java.util.List;

import zarazio.travel.android.bean.attachedFileDTO;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.hashTagDTO;

public interface boardDAO {
	public int maxboard_Code()throws Exception;
	public void insertBoard(boardDTO board) throws Exception;
	public void insertHash(hashTagDTO hash)throws Exception;
	public void insertFile(attachedFileDTO files)throws Exception;
	public List<boardDTO> boardList()throws Exception;
	public List<boardDTO> boardHashList(String Hash)throws Exception;
	public List<attachedFileDTO> selPicture(int board_code)throws Exception;
}
