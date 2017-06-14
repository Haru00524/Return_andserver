package zarazio.travel.android.dao;

import java.util.List;

import zarazio.travel.android.bean.boardLIstDTO;

public interface ListViewDAO {
	public List<boardLIstDTO> serachList()throws Exception;
	public List<boardLIstDTO> serachListHashList(String hash_tag)throws Exception;
}
