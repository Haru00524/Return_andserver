package zarazio.travel.android.service;

import java.util.List;

import zarazio.travel.android.bean.boardLIstDTO;

public interface ListViewService {
	public List<boardLIstDTO> serachList()throws Exception;
	public List<boardLIstDTO> serachListHashList(String hash_tag)throws Exception;
}
