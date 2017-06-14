package zarazio.travel.android.service;

import java.util.List;
import java.util.StringTokenizer;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import zarazio.travel.android.bean.attachedFileDTO;
import zarazio.travel.android.bean.boardDTO;
import zarazio.travel.android.bean.boardLIstDTO;
import zarazio.travel.android.bean.hashTagDTO;
import zarazio.travel.android.dao.ListViewDAO;
import zarazio.travel.android.dao.boardDAO;

@Service
public class LisetViewServiceImpl implements ListViewService {

	@Inject
	private ListViewDAO dao;

	@Override
	public List<boardLIstDTO> serachList() throws Exception {
		// TODO Auto-generated method stub
		return dao.serachList();
	}

	@Override
	public List<boardLIstDTO> serachListHashList(String hash_tag) throws Exception {
		// TODO Auto-generated method stub
		return dao.serachListHashList(hash_tag);
	}
	
	

}
