package zarazio.travel.android.dao;

import java.util.List;

import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.boardLIstDTO;

public interface ListViewDAO {
	public List<boardLIstDTO> serachList()throws Exception;
	public List<boardLIstDTO> mainList(String user_id)throws Exception;
	public List<boardLIstDTO> serachListHashList(String hash_tag)throws Exception;
	public void boardLike(boardDTO board) throws Exception;
}
